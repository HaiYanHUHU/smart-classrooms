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

    // 构造函数，初始化channel和stub
    public HeatingClient(String host, int port) {
        // 构建连接到gRPC服务器的channel
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext() // 指明不使用TLS加密
                .build();

        // 阻塞式存根，用于一元RPC调用
        this.blockingStub = HeatingServiceGrpc.newBlockingStub(channel);
        // 异步存根，用于流式RPC调用
        this.asyncStub = HeatingServiceGrpc.newStub(channel);
    }

    // 关闭客户端channel
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    // 发送获取暖气状态的请求
    public void getHeatingStatus() {
        GetHeatingStatusRequest request = GetHeatingStatusRequest.getDefaultInstance();
        HeatingStatus response;

        try {
            // 调用服务器方法获取暖气状态
            response = blockingStub.getHeatingStatus(request);
            System.out.println("暖气状态: 名称=" + response.getName() + ", 是否开启=" + response.getIsOn() + ", 当前温度=" + response.getTemperature());
        } catch (RuntimeException e) {
            System.err.println("RPC调用失败: " + e.getMessage());
        }
    }

    // 发送控制暖气的请求
    public void controlHeating(boolean turnOn, double temperature) {
        ControlHeatingRequest request = ControlHeatingRequest.newBuilder()
                .setTurnOn(turnOn)
                .setSetTemperature(temperature)
                .build();

        StreamObserver<HeatingControlResponse> responseObserver = new StreamObserver<HeatingControlResponse>() {
            @Override
            public void onNext(HeatingControlResponse response) {
                System.out.println("暖气控制响应: 操作成功=" + response.getSuccess());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("暖气控制失败: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("暖气控制请求完成");
            }
        };

        // 异步发送流式请求控制暖气
        StreamObserver<ControlHeatingRequest> requestObserver = asyncStub.controlHeating(responseObserver);
        requestObserver.onNext(request);
        requestObserver.onCompleted();
    }

    // 客户端主方法，用于演示客户端调用
    public static void main(String[] args) throws InterruptedException {
        // 暖气服务器地址和端口
        HeatingClient client = new HeatingClient("localhost", 50051);
        try {
            // 获取暖气状态
            client.getHeatingStatus();
            // 控制暖气，以下为示例参数：开启暖气并设置温度为22.5°C
            client.controlHeating(true, 22.5);
            // 关闭暖气作为演示，不更改温度设置
            client.controlHeating(false, 22.5);
        } finally {
            // 关闭客户端
            client.shutdown();
        }
    }
}

