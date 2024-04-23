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

    // 构造函数，初始化channel和stub
    public ProjectorClient(String host, int port) {
        // 构建连接到gRPC服务器的channel
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext() // 在这里不使用TLS加密
                .build();

        // 阻塞stub用于一元RPC调用
        this.blockingStub = ProjectorServiceGrpc.newBlockingStub(channel);
        // 异步stub用于流式RPC调用
        this.asyncStub = ProjectorServiceGrpc.newStub(channel);
    }

    // 关闭客户端channel
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    // 发送获取投影仪状态的请求
    public void getProjectorStatus() {
        // 构建请求
        GetProjectorStatusRequest request = GetProjectorStatusRequest.getDefaultInstance();
        ProjectorStatus response;

        try {
            // 调用服务器方法
            response = blockingStub.getProjectorStatus(request);
            System.out.println("投影仪状态: 名称=" + response.getName() + ", 是否开启=" + response.getIsOn());
        } catch (RuntimeException e) {
            System.err.println("RPC调用失败: " + e.getMessage());
            return;
        }
    }

    // 发送控制投影仪的请求
    public void controlProjectors(boolean turnOn) {
        ControlProjectorRequest request = ControlProjectorRequest.newBuilder()
                .setTurnOn(turnOn)
                .build();

        StreamObserver<ProjectorControlResponse> responseObserver = new StreamObserver<ProjectorControlResponse>() {
            @Override
            public void onNext(ProjectorControlResponse response) {
                System.out.println("收到投影仪控制响应: 操作成功=" + response.getSuccess());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("投影仪控制失败: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("投影仪控制请求完成");
            }
        };

        // 异步发送流式请求
        StreamObserver<ControlProjectorRequest> requestObserver = asyncStub.controlProjectors(responseObserver);
        requestObserver.onNext(request);
        requestObserver.onCompleted();
    }

    // 客户端主方法，用于演示客户端调用
    public static void main(String[] args) throws InterruptedException {
        // 服务器地址和端口
        ProjectorClient client = new ProjectorClient("localhost", 8080);
        try {
            // 获取投影仪状态
            client.getProjectorStatus();
            // 控制投影仪
            client.controlProjectors(true); // 开启投影仪
            client.controlProjectors(false); // 关闭投影仪
        } finally {
            // 关闭客户端
            client.shutdown();
        }
    }
}

