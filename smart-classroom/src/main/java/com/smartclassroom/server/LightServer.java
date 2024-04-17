package com.smartclassroom.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.ImmutableRegCheck;
import com.orbitz.consul.AgentClient;
import com.orbitz.consul.model.agent.Registration;
import com.orbitz.consul.model.agent.ImmutableRegistration;

public class LightServer {
    public static void main(String[] args) throws Exception {
        int port = 10001;
        Server server = ServerBuilder.forPort(port)
                .addService(new LightService())
                .build()
                .start();

        // 创建Consul客户端
        Consul consul = Consul.builder().build();
        AgentClient agentClient = consul.agentClient();

        // 设置健康检查
        Registration.RegCheck check = ImmutableRegCheck.builder()
                .tcp("localhost:" + port)
                .interval("10s")
                .timeout("5s")
                .build();

        // 注册服务到Consul
        Registration registration = ImmutableRegistration.builder()
                .id("light-server")
                .name("light-service")
                .port(port)
                .check(check)
                .build();

        agentClient.register(registration);
        System.out.println("Server started listening on " + port);

        server.awaitTermination();
        //
        Runtime.getRuntime().addShutdownHook(new Thread(() -> agentClient.deregister("light-server")));
    }
}
