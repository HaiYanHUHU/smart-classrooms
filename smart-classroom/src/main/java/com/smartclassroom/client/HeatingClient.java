package com.smartclassroom.client;

import com.smartclassroom.HeatingServiceGrpc;
import com.smartclassroom.HeatingProto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class HeatingClient {
    private final ManagedChannel channel;
    private final HeatingServiceGrpc.HeatingServiceBlockingStub blockingStub;
    private final HeatingServiceGrpc.HeatingServiceStub asyncStub;

    // Constructor, initialize channel and stub
    public HeatingClient(String host, int port) {
        // Building a channel to connect to a gRPC server
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext() //
                .build();

        //
        this.blockingStub = HeatingServiceGrpc.newBlockingStub(channel);
        //
        this.asyncStub = HeatingServiceGrpc.newStub(channel);
    }
    //GUI
    public void toggleHeating(boolean isOn, double temperature) {
        controlHeating(isOn, temperature);
    }

    // close the client channel
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    // Send a request to get the heating status
    public void getHeatingStatus() {
        GetHeatingStatusRequest request = GetHeatingStatusRequest.getDefaultInstance();
        HeatingStatus response;

        try {
            // get server methods
            response = blockingStub.getHeatingStatus(request);
            System.out.println("heating Status: name=" + response.getName() + ", Status=" + response.getIsOn() + ", 当前温度=" + response.getTemperature());
        } catch (RuntimeException e) {
            System.err.println("RPC get fail:  " + e.getMessage());
        }
    }

    // Send request to control the heating
    public void controlHeating(boolean turnOn, double temperature) {
        ControlHeatingRequest request = ControlHeatingRequest.newBuilder()
                .setTurnOn(turnOn)
                .setSetTemperature(temperature)
                .build();

        StreamObserver<HeatingControlResponse> responseObserver = new StreamObserver<HeatingControlResponse>() {
            @Override
            public void onNext(HeatingControlResponse response) {
                System.out.println("heating control response received: operation success=" + response.getSuccess());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("heating control failed:" + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("heating end");
            }
        };

        // requests
        StreamObserver<ControlHeatingRequest> requestObserver = asyncStub.controlHeating(responseObserver);
        requestObserver.onNext(request);
        requestObserver.onCompleted();
    }

    //
    public static void main(String[] args) throws InterruptedException {
        // address and port
        HeatingClient client = new HeatingClient("localhost", 50051);
        try {
            // get heating status
            client.getHeatingStatus();
            // control heating :set the temperature to 22.5°C
            client.controlHeating(true, 22.5);
            // turn off heating
            client.controlHeating(false, 22.5);
        } finally {
            // close
            client.shutdown();
        }
    }
}

