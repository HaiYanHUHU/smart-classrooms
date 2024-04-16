package com.smartclassroom.client;


import com.smartclassroom.ProjectorServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import com.smartclassroom.ProjectorProto.*;

import java.util.concurrent.TimeUnit;

public class ProjectorClient {
    private final ManagedChannel channel;
    private final ProjectorServiceGrpc.ProjectorServiceBlockingStub blockingStub;
    private final ProjectorServiceGrpc.ProjectorServiceStub asyncStub;

    public ProjectorClient(String host, int port) {
        // 使用明文传输创建一个新的Channel
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        // 创建阻塞式存根
        this.blockingStub = ProjectorServiceGrpc.newBlockingStub(channel);
        // 创建非阻塞式存根
        this.asyncStub = ProjectorServiceGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        // 关闭Channel
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void getProjectorStatus() {
        // 构建空请求体
        GetProjectorStatusRequest request = GetProjectorStatusRequest.newBuilder().build();
        ProjectorStatus response;
        try {
            // 同步调用服务端方法
            response = blockingStub.getProjectorStatus(request);
            System.out.println("Projector Status: Name = " + response.getName() + ", Is On = " + response.getIsOn());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void controlProjector(boolean turnOn) {
        // 构建请求体，设置开关状态
        ControlProjectorRequest request = ControlProjectorRequest.newBuilder().setTurnOn(turnOn).build();
        ProjectorControlResponse response;
        try {
            // 同步调用控制投影仪的服务方法
            response = blockingStub.controlProjector(request);
            System.out.println("Projector Control Success: " + response.getSuccess());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void monitorProjectorStream() {
        // 创建响应观察者处理服务器响应
        StreamObserver<ProjectorStatus> responseObserver = new StreamObserver<ProjectorStatus>() {
            @Override
            public void onNext(ProjectorStatus status) {
                System.out.println("Received Projector Status Update: Name = " + status.getName() + ", Is On = " + status.getIsOn());
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

        // 创建请求观察者向服务器发送请求
        StreamObserver<MonitorProjectorRequest> requestObserver = asyncStub.monitorProjectorStream(responseObserver);
        try {
            // 发送请求
            requestObserver.onNext(MonitorProjectorRequest.newBuilder().build());
            // 等待一段时间
            Thread.sleep(2000); // 等待服务器响应
            // 完成请求
            requestObserver.onCompleted();
            // 再次等待，以确保接收完所有数据
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProjectorClient client = new ProjectorClient("localhost", 50052);
        try {
            client.getProjectorStatus();
            client.controlProjector(true); // 尝试开启投影仪
            client.monitorProjectorStream(); // 实时监控投影仪状态
        } finally {
            client.shutdown();
        }
    }
}

