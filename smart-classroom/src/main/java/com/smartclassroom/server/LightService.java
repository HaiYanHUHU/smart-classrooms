package com.smartclassroom.server;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.smartclassroom.LightProto;
import com.smartclassroom.LightServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LightService extends LightServiceGrpc.LightServiceImplBase {

    private Map<String, Boolean> lightStatusMap = new HashMap<>();
    private boolean energySavingMode = false;

    @Override
    public void getLightStatus(LightProto.GetLightStatusRequest request, StreamObserver<LightProto.LightStatus> responseObserver) {
        String name = request.getName();
        boolean isOn = lightStatusMap.getOrDefault(name, false);
        smartclassroom.LightProto.LightStatus = LightProto.LightStatus.newBuilder().setName(name).setIsOn(isOn).build();
        responseObserver.onNext(LightStatus);
        responseObserver.onCompleted();
    }

    @Override
    public void controlLight(LightProto.ControlLightRequest request, StreamObserver<LightProto.LightControlResponse> responseObserver) {
        String name = request.getName();
        boolean turnOn = request.getTurnOn();
        lightStatusMap.put(name, turnOn);
        boolean success = true;
        LightProto.LightControlResponse lightControlResponse = LightProto.LightControlResponse.newBuilder().setSuccess(success).build();
        responseObserver.onNext(lightControlResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void monitorLightStream(Empty request, StreamObserver<LightStatus> responseObserver) {
        for (Map.Entry<String, Boolean> entry : lightStatusMap.entrySet()) {
            LightStatus lightStatus = LightStatus.newBuilder().setName(entry.getKey()).setIsOn(entry.getValue()).build();
            responseObserver.onNext(lightStatus);
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<BoolValue> energySavingOptimization(StreamObserver<Empty> responseObserver) {
        return new StreamObserver<BoolValue>() {
            @Override
            public void onNext(BoolValue value) {
                energySavingMode = value.getValue();
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error in energy saving optimization: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(Empty.getDefaultInstance());
                responseObserver.onCompleted();
            }
        };
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        LightService lightService = new LightService();
        int port = 50051;
        Server server = ServerBuilder.forPort(port)
                .addService(lightService)
                .build();
        server.start();
        System.out.println("Light service started, listening on " + port);
        server.awaitTermination();
    }
}
