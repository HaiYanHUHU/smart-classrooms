package com.smartclassroom.server;

import com.smartclassroom.HeatingServiceGrpc;
import com.smartclassroom.HeatingProto.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;

public class HeatingServer {

    private Server server;

    // start server
    public void start(int port) throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new HeatingServiceImpl())
                .build()
                .start();
        System.out.println("Heating service is up on port " + port);
        // Register server to Consul
        registerToConsul();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Turn off the gRPC heating service");
            try {
                HeatingServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }));
    }

    // end service
    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    // service continues to run until terminated by an external request
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    // service methods defined in the proto
    private static class HeatingServiceImpl extends HeatingServiceGrpc.HeatingServiceImplBase {

        // Unary RPC：get heating state
        @Override
        public void getHeatingStatus(GetHeatingStatusRequest req, StreamObserver<HeatingStatus> responseObserver) {
            // need to add actual logic to get the state of the heating
            HeatingStatus status = HeatingStatus.newBuilder()
                    .setName("Heating")
                    .setIsOn(true)
                    .setTemperature(22.5)
                    .build();
            responseObserver.onNext(status);
            responseObserver.onCompleted();
        }

        // Client Streaming RPC：control heating
        @Override
        public StreamObserver<ControlHeatingRequest> controlHeating(StreamObserver<HeatingControlResponse> responseObserver) {
            return new StreamObserver<>() {
                // receive control request from client
                @Override
                public void onNext(ControlHeatingRequest req) {
                    // add the actual logic for controlling heating
                    System.out.println("receive a request to control the heating: Turn on:=" + req.getTurnOn() + ", temperature set to " + req.getSetTemperature() + "°C");
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("error occurs when control the heating：" + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // all control requests have been processed
                    HeatingControlResponse response = HeatingControlResponse.newBuilder()
                            .setSuccess(true)
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                    System.out.println("heating control process complete");
                }
            };
        }


        // Client Streaming RPC：Receive continuous heating control commands from clients

        public StreamObserver<HeatingEventsRequest> streamHeating(StreamObserver<HeatingStatus> responseObserver) {
            return new StreamObserver<HeatingEventsRequest>() {
                // control request is received from a client
                @Override
                public void onNext(HeatingEventsRequest request) {
                    //
                    System.out.println("Continuous heating control command received：" + request);

                    //
                    HeatingStatus status = HeatingStatus.newBuilder()
                            .setName("Heating")
                            .build();
                    responseObserver.onNext(status);
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error while receiving continuous heating control command:" + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    //
                    responseObserver.onCompleted();
                }
            };
        }

        // Bi-directional Stream RPC:Bidirectional transmission of heating status and control commands

        public StreamObserver<MonitorHeatingRequest> monitorHeating(StreamObserver<HeatingStatus> responseObserver) {
            return new StreamObserver<MonitorHeatingRequest>() {
                //
                @Override
                public void onNext(MonitorHeatingRequest request) {
                    // bidirectional transmission
                    System.out.println("Heating monitoring request received");

                    //
                    HeatingStatus status = HeatingStatus.newBuilder()
                            .setName("classroom-heating")
                            .setIsOn(false)
                            .setTemperature(22.5)
                            .build();
                    responseObserver.onNext(status);
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error during heating monitoring:" + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // Bidirectional streaming complete, closing response streaming
                    responseObserver.onCompleted();
                }
            };
        }

        //
    }
    //consul
    private void registerToConsul() {
        System.out.println("Registering server to Consul...");

        // Load Consul configuration from heating-service.properties file
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/heating-service.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Extract Consul configuration properties
        String consulHost = props.getProperty("consul.host");
        int consulPort = Integer.parseInt(props.getProperty("consul.port"));
        String serviceName = props.getProperty("consul.service.name");
        int servicePort = Integer.parseInt(props.getProperty("consul.service.port"));
        String healthCheckInterval = props.getProperty("consul.service.healthCheckInterval");

        // Get host address
        String hostAddress;
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        }

        // Create a Consul client
        ConsulClient consulClient = new ConsulClient(consulHost, consulPort);

        // Define service details
        NewService newService = new NewService();
        newService.setName(serviceName);
        newService.setPort(servicePort);
        newService.setAddress(hostAddress); // Set host address

        // Register service with Consul
        consulClient.agentServiceRegister(newService);

        // Print registration success message
        System.out.println("Server registered to Consul successfully. Host: " + hostAddress);
    }

    // main method, start server
    public static void main(String[] args) throws IOException, InterruptedException {
        HeatingServer server = new HeatingServer();
        server.start(50051); // port 50051
        server.blockUntilShutdown();
    }
}

