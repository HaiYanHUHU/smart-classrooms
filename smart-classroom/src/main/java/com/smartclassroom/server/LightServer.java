package com.smartclassroom.server;

import com.smartclassroom.LightServiceGrpc;
import com.smartclassroom.LightProto.*;
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

public class LightServer{

    private Server server;

    // start server
    public void start(int port) throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new LightServiceImpl())
                .build()
                .start();
        System.out.println("Light service is up on port " + port);
        // Register server to Consul
        registerToConsul();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Turn off the gRPC light service");
            try {
                LightServer.this.stop();
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
    private static class LightServiceImpl extends LightServiceGrpc.LightServiceImplBase {

        // Unary RPC：get light state
        @Override
        public void getLightStatus(GetLightStatusRequest req, StreamObserver<LightStatus> responseObserver) {
            // need to add actual logic to get the state of the light
            //
            LightStatus status = LightStatus.newBuilder()
                    .setName("LightName")
                    .setIsOn(true)
                    .build();
            responseObserver.onNext(status);
            responseObserver.onCompleted();
        }

        // Client Streaming RPC：control of light
        @Override
        public StreamObserver<ControlLightRequest> controlLights(StreamObserver<LightControlResponse> responseObserver) {
            return new StreamObserver<>() {
                // receive control request from client
                @Override
                public void onNext(ControlLightRequest req) {
                    // add the actual logic for controlling light
                    System.out.println("receive request to control light:" + (req.getTurnOn() ? "turn on" : "turn off"));
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("error occurs when control the light:" + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // all control requests have been processed
                    LightControlResponse response = LightControlResponse.newBuilder()
                            .setSuccess(true)
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                    System.out.println("light control process complete");
                }
            };
        }
    }
    //consul
    private void registerToConsul() {
        System.out.println("Registering server to Consul...");

        // Load Consul configuration from light-service.properties file
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/light-service.properties")) {
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
        LightServer server = new LightServer();
        server.start(8080); // port 8080
        server.blockUntilShutdown();
    }
}
