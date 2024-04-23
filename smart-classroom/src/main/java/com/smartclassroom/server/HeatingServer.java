package com.smartclassroom.server;

import com.smartclassroom.HeatingServiceGrpc;
import com.smartclassroom.HeatingProto.*;
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

public class HeatingServer {

    private Server server;

    // 启动服务并监听指定端口
    public void start(int port) throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new HeatingServiceImpl())
                .build()
                .start();
        System.out.println("暖气服务已在端口 " + port + " 上启动");
        // Register server to Consul
        registerToConsul();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("关闭gRPC暖气服务");
            try {
                HeatingServer.this.stop();
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

    // 实现proto文件中定义的暖气服务
    private static class HeatingServiceImpl extends HeatingServiceGrpc.HeatingServiceImplBase {

        // 一元RPC方法：获取暖气状态
        @Override
        public void getHeatingStatus(GetHeatingStatusRequest req, StreamObserver<HeatingStatus> responseObserver) {
            // 这里应添加获取暖气状态的实际逻辑
            HeatingStatus status = HeatingStatus.newBuilder()
                    .setName("教室暖气")
                    .setIsOn(true)
                    .setTemperature(22.5)
                    .build();
            responseObserver.onNext(status);
            responseObserver.onCompleted();
        }

        // 客户端流RPC方法：批量控制暖气
        @Override
        public StreamObserver<ControlHeatingRequest> controlHeating(StreamObserver<HeatingControlResponse> responseObserver) {
            return new StreamObserver<>() {
                // 当收到客户端的控制请求时
                @Override
                public void onNext(ControlHeatingRequest req) {
                    // 这里应添加控制暖气的实际逻辑
                    System.out.println("收到控制暖气请求：开启=" + req.getTurnOn() + ", 温度设置为 " + req.getSetTemperature() + "°C");
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("控制暖气时发生错误：" + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // 所有控制请求已处理完毕
                    HeatingControlResponse response = HeatingControlResponse.newBuilder()
                            .setSuccess(true)
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                    System.out.println("暖气控制流程完成");
                }
            };
        }

        // 请根据需要实现其他RPC方法
    }
    //consul
    private void registerToConsul() {
        System.out.println("Registering server to Consul...");

        // Load Consul configuration from heating-service.properties file
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/heating-service.properties")) {
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
        HeatingServer server = new HeatingServer();
        server.start(50051); // 端口号可以根据实际情况进行调整
        server.blockUntilShutdown();
    }
}

