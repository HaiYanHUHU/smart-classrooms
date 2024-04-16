package com.smartclassroom.server;


import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ProjectorServer {
    public static void main(String[] args) throws Exception {
        int port = 50052; // 确保这个端口不与其他服务冲突
        Server server = ServerBuilder.forPort(port)
                .addService(new ProjectorService())
                .build()
                .start();

        System.out.println("Server started, listening on " + port);
        server.awaitTermination();
    }
}

