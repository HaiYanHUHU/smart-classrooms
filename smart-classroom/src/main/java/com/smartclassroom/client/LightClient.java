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

    // 构造函数，初始化channel和stub
    public LightClient(String host, int port) {
        // 构建连接到gRPC服务器的channel
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext() // 在这里不使用TLS加密
                .build();

        // 阻塞stub用于一元RPC调用
        this.blockingStub = LightServiceGrpc.newBlockingStub(channel);
        // 异步stub用于流式RPC调用
        this.asyncStub = LightServiceGrpc.newStub(channel);
    }
    // 供GUI直接调用
    public void toggleLight(boolean isOn) {
        controlLights(isOn);
    }


    // 关闭客户端channel
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    // 发送获取灯光状态的请求
    public void getLightStatus() {
        // 构建请求
        GetLightStatusRequest request = GetLightStatusRequest.getDefaultInstance();
        LightStatus response;

        try {
            // 调用服务器方法
            response = blockingStub.getLightStatus(request);
            System.out.println("灯光状态: 名称=" + response.getName() + ", 是否开启=" + response.getIsOn());
        } catch (RuntimeException e) {
            System.err.println("RPC调用失败: " + e.getMessage());
            return;
        }
    }

    // 发送控制灯光的请求
    public void controlLights(boolean turnOn) {
        ControlLightRequest request = ControlLightRequest.newBuilder()
                .setTurnOn(turnOn)
                .build();

        StreamObserver<LightControlResponse> responseObserver = new StreamObserver<LightControlResponse>() {
            @Override
            public void onNext(LightControlResponse response) {
                System.out.println("收到灯光控制响应: 操作成功=" + response.getSuccess());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("灯光控制失败: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("灯光控制请求完成");
            }
        };

        // 异步发送流式请求
        StreamObserver<ControlLightRequest> requestObserver = asyncStub.controlLights(responseObserver);
        requestObserver.onNext(request);
        requestObserver.onCompleted();
    }

    // 客户端主方法，用于演示客户端调用
    public static void main(String[] args) throws InterruptedException {
        // 服务器地址和端口
        LightClient client = new LightClient("localhost", 8080);
        try {
            // 获取灯光状态
            client.getLightStatus();
            // 控制灯光
            client.controlLights(true); // 开灯
            client.controlLights(false); // 关灯
        } finally {
            // 关闭客户端
            client.shutdown();
        }
    }
}

