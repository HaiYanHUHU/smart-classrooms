package com.smartclassroom.server;

import com.smartclassroom.ProjectorServiceGrpc;
import com.smartclassroom.ProjectorProto.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ProjectorServer {

    private Server server;

    // 启动服务并监听指定端口
    public void start(int port) throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new ProjectorServiceImpl())
                .build()
                .start();
        System.out.println("投影仪服务已在端口 " + port + " 上启动");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("关闭gRPC投影仪服务");
            try {
                ProjectorServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }));
    }

    // 停止服务
    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    // 服务持续运行直到外部请求终止
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    // 实现proto文件中定义的投影仪服务
    private static class ProjectorServiceImpl extends ProjectorServiceGrpc.ProjectorServiceImplBase {

        // 一元RPC方法：获取投影仪状态
        @Override
        public void getProjectorStatus(GetProjectorStatusRequest req, StreamObserver<ProjectorStatus> responseObserver) {
            // 这里应添加获取投影仪状态的实际逻辑
            ProjectorStatus status = ProjectorStatus.newBuilder()
                    .setName("主投影仪")
                    .setIsOn(false)
                    .build();
            responseObserver.onNext(status);
            responseObserver.onCompleted();
        }

        // 客户端流RPC方法：批量控制投影仪
        @Override
        public StreamObserver<ControlProjectorRequest> controlProjectors(StreamObserver<ProjectorControlResponse> responseObserver) {
            return new StreamObserver<>() {
                // 当收到客户端的控制请求时
                @Override
                public void onNext(ControlProjectorRequest req) {
                    // 这里应添加控制投影仪的实际逻辑
                    System.out.println("收到控制投影仪请求：" + (req.getTurnOn() ? "开启" : "关闭"));
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("控制投影仪时发生错误：" + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // 所有控制请求已处理完毕
                    ProjectorControlResponse response = ProjectorControlResponse.newBuilder()
                            .setSuccess(true)
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                    System.out.println("投影仪控制流程完成");
                }
            };
        }
    }

    // 主方法，启动服务器实例
    public static void main(String[] args) throws IOException, InterruptedException {
        ProjectorServer server = new ProjectorServer();
        server.start(8081); // 端口号可以根据实际情况进行调整
        server.blockUntilShutdown();
    }
}

