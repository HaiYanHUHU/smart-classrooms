package com.smartclassroom.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.ImmutableRegCheck;
import com.orbitz.consul.model.agent.ImmutableRegistration;

public class LightServer {
    private static void registerServiceWithConsul() {
        Consul consul = Consul.builder().build(); // 默认连接到localhost:8500
        ImmutableRegistration registration = ImmutableRegistration.builder()
                .id("light-server")
                .name("Light Service")
                .port(50051)
                .addTags("light", "classroom")
                .check(ImmutableRegCheck.builder()
                        .ttl("15s") // 定时健康检查时间间隔
                        .build())
                .build();
        consul.agentClient().register(registration);
        consul.agentClient().pass("light-server"); // 假设服务启动即健康
    }

    private static void deregisterServiceWithConsul() {
        Consul consul = Consul.builder().build();
        consul.agentClient().deregister("light-server");
    }

    public static void main(String[] args) throws Exception {
        int port = 50051;
        registerServiceWithConsul();
        Server server = ServerBuilder.forPort(port)
                .addService(new LightService())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(LightServer::deregisterServiceWithConsul));

        server.awaitTermination();
    }
}
