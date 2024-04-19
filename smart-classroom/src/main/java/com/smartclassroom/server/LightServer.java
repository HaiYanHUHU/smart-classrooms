package com.smartclassroom.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LightServer {
    private Server server;

    // 启动服务，并监听特定端口
    public void start(int port) throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new LightServiceImpl())
                .build()
                .start();
        System.out.println("Server started, listening on port " + port);

        // 添加 JVM 关闭钩子来优雅关闭 gRPC 服务器
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server");
            try {
                LightServer.this.stop();
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

    // 服务阻塞运行，直至外部中断
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private static class LightServiceImpl extends LightServiceGrpc.LightServiceImplBase {
        // 一元 RPC 方法：获取灯光状态
        @Override
        public void getLightStatus(GetLightStatusRequest request, StreamObserver<LightStatus> responseObserver) {
            LightStatus status = LightStatus.newBuilder()
                    .setName("Main Hall Light")  // 灯光名称
                    .setIsOn(true)              // 灯光状态，true 为开启
                    .build();
            responseObserver.onNext(status);
            responseObserver.onCompleted();
        }

        // 客户端流式 RPC 方法：控制灯光
        @Override
        public StreamObserver<ControlLightRequest> controlLights(StreamObserver<LightControlResponse> responseObserver) {
            return new StreamObserver<ControlLightRequest>() {
                @Override
                public void onNext(ControlLightRequest request) {
                    System.out.println("Received control request to turn " + (request.getTurnOn() ? "ON" : "OFF"));
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Control lights streaming error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    LightControlResponse response = LightControlResponse.newBuilder()
                            .setSuccess(true)  // 控制成功标志
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
            };
        }
    }

    // 主函数，启动服务器
    public static void main(String[] args) throws IOException, InterruptedException {
        LightServer server = new LightServer();
        server.start(8080);  // 在端口 8080 上启动服务
        server.blockUntilShutdown();
    }
}
