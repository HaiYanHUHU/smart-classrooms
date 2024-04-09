//package com.smartclassroom.client;
//
//import io.grpc.ManagedChannel;
//import io.grpc.ManagedChannelBuilder;
//import io.grpc.stub.StreamObserver;
//
//import java.util.concurrent.TimeUnit;
//
//public class LightClient {
//
//    private final ManagedChannel channel;
//    private final LightServiceGrpc.LightServiceStub stub;
//
//    public LightClient(String host, int port) {
//        channel = ManagedChannelBuilder.forAddress(host, port)
//                .usePlaintext()
//                .build();
//        stub = LightServiceGrpc.newStub(channel);
//    }
//
//    public void shutdown() throws InterruptedException {
//        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
//    }
//
//    public void getLightStatus(String name) {
//        GetLightStatusRequest request = GetLightStatusRequest.newBuilder().setName(name).build();
//        stub.getLightStatus(request, new StreamObserver<LightStatus>() {
//            @Override
//            public void onNext(LightStatus lightStatus) {
//                System.out.println("Light status - Name: " + lightStatus.getName() + ", Is On: " + lightStatus.getIsOn());
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                System.err.println("Error: " + throwable.getMessage());
//            }
//
//            @Override
//            public void onCompleted() {
//                System.out.println("Light status request completed.");
//            }
//        });
//    }
//
//    public void controlLight(String name, boolean turnOn) {
//        ControlLightRequest request = ControlLightRequest.newBuilder().setName(name).setTurnOn(turnOn).build();
//        stub.controlLight(request, new StreamObserver<LightControlResponse>() {
//            @Override
//            public void onNext(LightControlResponse lightControlResponse) {
//                if (lightControlResponse.getSuccess()) {
//                    System.out.println("Light control successful.");
//                } else {
//                    System.out.println("Light control failed.");
//                }
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                System.err.println("Error: " + throwable.getMessage());
//            }
//
//            @Override
//            public void onCompleted() {
//                System.out.println("Light control request completed.");
//            }
//        });
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        String host = "localhost";
//        int port = 50051;
//        LightClient client = new LightClient(host, port);
//
//        // Example usage:
//        client.getLightStatus("Desk Lamp");
//        client.controlLight("Ceiling Light", true);
//
//        Thread.sleep(1000); // Waiting for RPCs to complete
//
//        client.shutdown();
//    }
//}
//
