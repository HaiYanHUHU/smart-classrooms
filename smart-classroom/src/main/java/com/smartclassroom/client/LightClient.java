package com.smartclassroom.client;

import com.smartclassroom.LightServiceGrpc;
import com.smartclassroom.LightProto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class LightClient {
    private final ManagedChannel channel;
    private final LightServiceGrpc.LightServiceBlockingStub blockingStub;
    private final LightServiceGrpc.LightServiceStub asyncStub;

    // Constructor, initialize channel and stub
    public LightClient(String host, int port) {
        // Building a channel to connect to a gRPC server
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();

        //
        this.blockingStub = LightServiceGrpc.newBlockingStub(channel);
        //
        this.asyncStub = LightServiceGrpc.newStub(channel);
    }
    // GUI
    public void toggleLight(boolean isOn) {
        controlLights(isOn);
    }


    // Close the client channel
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    // Send a request to get the light status
    public void getLightStatus() {
        //
        GetLightStatusRequest request = GetLightStatusRequest.getDefaultInstance();
        LightStatus response;

        try {
            //get server methods
            response = blockingStub.getLightStatus(request);
            System.out.println("Light Status: name=" + response.getName() + ", Status=" + response.getIsOn());
        } catch (RuntimeException e) {
            System.err.println("RPC get fail: " + e.getMessage());
            return;
        }
    }

    // Send a request to control the lights
    public void controlLights(boolean turnOn) {
        ControlLightRequest request = ControlLightRequest.newBuilder()
                .setTurnOn(turnOn)
                .build();

        StreamObserver<LightControlResponse> responseObserver = new StreamObserver<LightControlResponse>() {
            @Override
            public void onNext(LightControlResponse response) {
                System.out.println("Light control response received: operation success=" + response.getSuccess());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Light control failed: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("light end");
            }
        };

        // requests
        StreamObserver<ControlLightRequest> requestObserver = asyncStub.controlLights(responseObserver);
        requestObserver.onNext(request);
        requestObserver.onCompleted();
    }

    //
    public static void main(String[] args) throws InterruptedException {
        // server address and port
        LightClient client = new LightClient("localhost", 8080);
        try {
            // get light status
            client.getLightStatus();
            // control light
            client.controlLights(true); // true
            client.controlLights(false); // flase
        } finally {
            // close client
            client.shutdown();
        }
    }
}

