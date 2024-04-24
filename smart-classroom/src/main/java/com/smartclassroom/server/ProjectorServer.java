package com.smartclassroom.server;

import com.smartclassroom.ProjectorServiceGrpc;
import com.smartclassroom.ProjectorProto.*;
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

public class ProjectorServer {

    private Server server;

    // start server
    public void start(int port) throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new ProjectorServiceImpl())
                .build()
                .start();
        System.out.println("Projector service is up on port  " + port);
        // Register server to Consul
        registerToConsul();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Turn off the gRPC projector service");
            try {
                ProjectorServer.this.stop();
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

    // service methods defined in the proto file
    private static class ProjectorServiceImpl extends ProjectorServiceGrpc.ProjectorServiceImplBase {

        // Unary RPC：get projector state
        @Override
        public void getProjectorStatus(GetProjectorStatusRequest req, StreamObserver<ProjectorStatus> responseObserver) {
            // need to add actual logic to get the state of the projector
            //
            ProjectorStatus status = ProjectorStatus.newBuilder()
                    .setName("ProjectorName")
                    .setIsOn(false)
                    .build();
            responseObserver.onNext(status);
            responseObserver.onCompleted();
        }

        // Client Streaming RPC：control of projector
        @Override
        public StreamObserver<ControlProjectorRequest> controlProjectors(StreamObserver<ProjectorControlResponse> responseObserver) {
            return new StreamObserver<>() {
                // receive control request from client
                @Override
                public void onNext(ControlProjectorRequest req) {
                    // add the actual logic for controlling projector
                    System.out.println("receive request to control projector:" + (req.getTurnOn() ? "turn on" : "turn off"));
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("error occurs when control the projector" + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    //  all control requests have been processed
                    ProjectorControlResponse response = ProjectorControlResponse.newBuilder()
                            .setSuccess(true)
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                    System.out.println("projector control process complete");
                }
            };
        }
    }

    //consul
    private void registerToConsul() {
        System.out.println("Registering server to Consul...");

        // Load Consul configuration from projector-service.properties file
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/projector-service.properties")) {
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
        ProjectorServer server = new ProjectorServer();
        server.start(9090); // port 9090
        server.blockUntilShutdown();
    }
}

