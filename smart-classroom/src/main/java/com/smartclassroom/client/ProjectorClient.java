package com.smartclassroom.client;

import com.smartclassroom.ProjectorServiceGrpc;
import com.smartclassroom.ProjectorProto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class ProjectorClient {
    private final ManagedChannel channel;
    private final ProjectorServiceGrpc.ProjectorServiceBlockingStub blockingStub;
    private final ProjectorServiceGrpc.ProjectorServiceStub asyncStub;

    // Constructor, initialize channel and stub
    public ProjectorClient(String host, int port) {
        // Building a channel to connect to a gRPC server
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();

        //
        this.blockingStub = ProjectorServiceGrpc.newBlockingStub(channel);
        //
        this.asyncStub = ProjectorServiceGrpc.newStub(channel);
    }
    //GUI
    public void toggleProjector(boolean isOn) {
        controlProjectors(isOn);
    }
    // close the client channel
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    // Send a request to get the projector status
    public void getProjectorStatus() {
        //
        GetProjectorStatusRequest request = GetProjectorStatusRequest.getDefaultInstance();
        ProjectorStatus response;

        try {
            // get server methods
            response = blockingStub.getProjectorStatus(request);
            System.out.println("projector Status: name=" + response.getName() + ",  Status=" + response.getIsOn());
        } catch (RuntimeException e) {
            System.err.println("RPC get fail:  " + e.getMessage());
            return;
        }
    }

    // Send request to control the lights
    public void controlProjectors(boolean turnOn) {
        ControlProjectorRequest request = ControlProjectorRequest.newBuilder()
                .setTurnOn(turnOn)
                .build();

        StreamObserver<ProjectorControlResponse> responseObserver = new StreamObserver<ProjectorControlResponse>() {
            @Override
            public void onNext(ProjectorControlResponse response) {
                System.out.println("projector control response received: operation success=" + response.getSuccess());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("projector control failed: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("projector end");
            }
        };

        // requests
        StreamObserver<ControlProjectorRequest> requestObserver = asyncStub.controlProjectors(responseObserver);
        requestObserver.onNext(request);
        requestObserver.onCompleted();
    }

    //
    public static void main(String[] args) throws InterruptedException {
        // server address and port
        ProjectorClient client = new ProjectorClient("localhost", 9090);
        try {
            // get projector status
            client.getProjectorStatus();
            // control projector
            client.controlProjectors(true); // true
            client.controlProjectors(false); // false
        } finally {
            // close client
            client.shutdown();
        }
    }
}

