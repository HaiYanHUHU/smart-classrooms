package com.smartclassroom.client;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import com.smartclassroom.MobileAppProto.*;
import com.smartclassroom.MobileAppServiceGrpc;

import java.util.concurrent.TimeUnit;

public class MobileAppClient {
    private final ManagedChannel channel;
    private final MobileAppServiceGrpc.MobileAppServiceBlockingStub blockingStub;
    private final MobileAppServiceGrpc.MobileAppServiceStub asyncStub;

    public MobileAppClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.blockingStub = MobileAppServiceGrpc.newBlockingStub(channel);
        this.asyncStub = MobileAppServiceGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void showStatus() {
        ShowStatusRequest request = ShowStatusRequest.newBuilder().build();
        ShowStatusResponse response;
        try {
            response = blockingStub.showStatus(request);
            response.getDevicesStatusList().forEach(deviceStatus ->
                    System.out.println("Device Name: " + deviceStatus.getName() + ", Is On: " + deviceStatus.getIsOn())
            );
        } catch (Exception e) {
            System.err.println("RPC failed: " + e.getMessage());
        }
    }

    public void controlDevices() {
        StreamObserver<ControlDevicesRequest> requestObserver = asyncStub.controlDevices(new StreamObserver<ControlDevicesResponse>() {
            @Override
            public void onNext(ControlDevicesResponse response) {
                System.out.println("Control response received: Success = " + response.getSuccess());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Control failed: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Finished controlling devices.");
            }
        });

        try {
            // Sending a few control commands as an example
            String[] devices = {"Classroom Light", "Main Projector"};
            boolean[] status = {true, false}; // Example states

            for (int i = 0; i < devices.length; i++) {
                ControlDevicesRequest request = ControlDevicesRequest.newBuilder()
                        .setDeviceName(devices[i])
                        .setTurnOn(status[i])
                        .build();
                requestObserver.onNext(request);
            }

            // Mark the end of requests
            requestObserver.onCompleted();
            Thread.sleep(1000); // Wait to ensure all responses are received
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MobileAppClient client = new MobileAppClient("localhost", 50053);
        try {
            client.showStatus();
            client.controlDevices();
        } finally {
            client.shutdown();
        }
    }
}

