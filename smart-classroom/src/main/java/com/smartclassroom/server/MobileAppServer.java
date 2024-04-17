package com.smartclassroom.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.Registration;
import com.orbitz.consul.AgentClient;
import com.orbitz.consul.model.agent.ImmutableRegCheck;
import com.orbitz.consul.model.agent.ImmutableRegistration;

public class MobileAppServer {
    public static void main(String[] args) throws Exception {
        int port = 10003;
        Server server = ServerBuilder.forPort(port)
                .addService(new MobileAppService())
                .build()
                .start();

        Consul consul = Consul.builder().build();
        AgentClient agentClient = consul.agentClient();

        Registration.RegCheck check = ImmutableRegCheck.builder()
                .tcp("localhost:" + port)
                .interval("10s")
                .timeout("5s")
                .build();

        Registration registration = ImmutableRegistration.builder()
                .id("mobileapp-server")
                .name("mobileapp-service")
                .port(port)
                .check(check)
                .build();

        agentClient.register(registration);
        System.out.println("Server started listening on " + port);

        server.awaitTermination();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> agentClient.deregister("mobileapp-server")));
    }
}
