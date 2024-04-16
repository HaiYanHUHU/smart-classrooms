package com.smartclassroom.client;


import com.smartclassroom.LightServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import com.smartclassroom.LightProto.*;
import io.grpc.StatusRuntimeException;


import java.util.concurrent.TimeUnit;

public class LightClient {
    private final ManagedChannel channel;
    private final LightServiceGrpc.LightServiceBlockingStub blockingStub;
    private final LightServiceGrpc.LightServiceStub asyncStub;

    public LightClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.blockingStub = LightServiceGrpc.newBlockingStub(channel);
        this.asyncStub = LightServiceGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void getLightStatus() {
        GetLightStatusRequest request = GetLightStatusRequest.newBuilder().build();
        LightStatus response;
        try {
            response = blockingStub.getLightStatus(request);
            System.out.println("Light Status: " + response.getIsOn());
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }


    public void controlLight(boolean turnOn) {
        ControlLightRequest request = ControlLightRequest.newBuilder().setTurnOn(turnOn).build();
        LightControlResponse response;
        try {
            response = blockingStub.controlLight(request);
            System.out.println("Light Control Success: " + response.getSuccess());
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public void monitorLightStream() {
        StreamObserver<LightStatus> responseObserver = new StreamObserver<LightStatus>() {
            @Override
            public void onNext(LightStatus status) {
                System.out.println("Received Light Status Update: " + status.getIsOn());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Stream Failed: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Stream Completed");
            }
        };

        StreamObserver<MonitorLightRequest> requestObserver = asyncStub.monitorLightStream(responseObserver);
        try {
            for (int i = 0; i < 5; i++) {
                requestObserver.onNext(MonitorLightRequest.newBuilder().build());
                Thread.sleep(1000); // 发送请求的时间间隔
            }
            requestObserver.onCompleted(); // 完成请求
            Thread.sleep(1000); // 等待处理完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LightClient client = new LightClient("localhost", 50051);
        try {
            client.getLightStatus();
            client.controlLight(true); // 试图打开灯
            client.monitorLightStream(); // 实时监控灯状态
        } finally {
            client.shutdown();
        }
    }
}
