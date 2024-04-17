package com.smartclassroom.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.ImmutableRegCheck;
import com.orbitz.consul.AgentClient;
import com.orbitz.consul.model.agent.Registration;
import com.orbitz.consul.model.agent.ImmutableRegistration;

public class ProjectorServer {
    public static void main(String[] args) throws Exception {
        int port = 20242;
        Server server = ServerBuilder.forPort(port)
                .addService(new ProjectorService())
                .build()
                .start();

        Consul consul = Consul.builder().build();
        AgentClient agentClient = consul.agentClient();

        Registration.RegCheck check = ImmutableRegCheck.builder()
                .tcp("localhost:" + port)
                .interval("20s")
                .timeout("5s")
                .build();

        Registration registration = ImmutableRegistration.builder()
                .id("projector-server")
                .name("projector-service")
                .port(port)
                .check(check)
                .build();

        agentClient.register(registration);
        System.out.println("Server started listening on " + port);

        server.awaitTermination();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> agentClient.deregister("projector-server")));
    }
}
