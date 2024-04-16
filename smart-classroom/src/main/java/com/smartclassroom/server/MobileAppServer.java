package com.smartclassroom.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;


public class MobileAppServer {
    public static void main(String[] args) throws Exception {
        int port = 50053; // 确保这个端口不与其他服务冲突
        Server server = ServerBuilder.forPort(port)
                .addService(new MobileAppService())  // 使用服务实现类的实例
                .build()
                .start();

        System.out.println("Server started, listening on " + port);
        server.awaitTermination();
    }
}



