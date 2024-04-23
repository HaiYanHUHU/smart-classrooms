package com.smartclassroom.server;

import com.smartclassroom.LightServiceGrpc;
import com.smartclassroom.LightProto.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;

public class LightServer{

    private Server server;

    // 启动服务，监听传入的端口
    public void start(int port) throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new LightServiceImpl())
                .build()
                .start();
        System.out.println("灯光服务已在端口 " + port + " 上启动");
        // Register server to Consul
        registerToConsul();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("关闭gRPC灯光服务");
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

    // 服务持续运行直到被外部请求终止
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    // 实现定义在proto文件中的服务方法
    private static class LightServiceImpl extends LightServiceGrpc.LightServiceImplBase {

        // 一元RPC方法：获取灯光状态
        @Override
        public void getLightStatus(GetLightStatusRequest req, StreamObserver<LightStatus> responseObserver) {
            // 这里需要添加获取灯光状态的实际逻辑
            // 以下是示例实现
            LightStatus status = LightStatus.newBuilder()
                    .setName("教室前排的灯")
                    .setIsOn(true)
                    .build();
            responseObserver.onNext(status);
            responseObserver.onCompleted();
        }

        // 客户端流RPC方法：批量控制灯光
        @Override
        public StreamObserver<ControlLightRequest> controlLights(StreamObserver<LightControlResponse> responseObserver) {
            return new StreamObserver<>() {
                // 当收到客户端的控制请求时
                @Override
                public void onNext(ControlLightRequest req) {
                    // 这里需要添加控制灯光的实际逻辑
                    System.out.println("收到控制灯光请求：" + (req.getTurnOn() ? "开启" : "关闭"));
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("控制灯光时发生错误：" + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // 所有的控制请求都已处理完毕
                    LightControlResponse response = LightControlResponse.newBuilder()
                            .setSuccess(true)
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                    System.out.println("灯光控制流程完成");
                }
            };
        }
    }
    //consul
    private void registerToConsul() {
        System.out.println("Registering server to Consul...");

        // Load Consul configuration from light-service.properties file
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/light-service.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Extract Consul configuration properties
        String consulHost = props.getProperty("consul.host");
        int consulPort = Integer.parseInt(props.getProperty("consul.port"));
        String serviceName = props.getProperty("consul.service.name");
        int servicePort = Integer.parseInt(props.getProperty("consul.service.port"));
        String healthCheckInterval = props.getProperty("consul.service.healthCheckInterval");

        // Get host address
        String hostAddress;
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        }

        // Create a Consul client
        ConsulClient consulClient = new ConsulClient(consulHost, consulPort);

        // Define service details
        NewService newService = new NewService();
        newService.setName(serviceName);
        newService.setPort(servicePort);
        newService.setAddress(hostAddress); // Set host address

        // Register service with Consul
        consulClient.agentServiceRegister(newService);

        // Print registration success message
        System.out.println("Server registered to Consul successfully. Host: " + hostAddress);
    }
    // 主方法，启动服务器实例
    public static void main(String[] args) throws IOException, InterruptedException {
        LightServer server = new LightServer();
        server.start(8080); // 可以选择不同的端口号
        server.blockUntilShutdown();
    }
}
