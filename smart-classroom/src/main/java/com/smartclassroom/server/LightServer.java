package com.smartclassroom.server;


import io.grpc.Server;
import io.grpc.ServerBuilder;

public class LightServer {
    public static void main(String[] args) throws Exception {
        int port = 50051;
        Server server = ServerBuilder.forPort(port)
                .addService(new LightService())
                .build()
                .start();

        System.out.println("Server started, listening on " + port);
        server.awaitTermination();
    }
}

