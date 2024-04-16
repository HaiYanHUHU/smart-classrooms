package com.smartclassroom.server;

import com.smartclassroom.LightServiceGrpc;
import io.grpc.stub.StreamObserver;
import com.smartclassroom.LightProto.*;

public class LightService extends LightServiceGrpc.LightServiceImplBase {

    @Override
    public void getLightStatus(GetLightStatusRequest req, StreamObserver<LightStatus> responseObserver) {
        LightStatus status = LightStatus.newBuilder()
                .setName("Classroom Light")
                .setIsOn(true) // 假设默认灯是开的
                .build();
        responseObserver.onNext(status);
        responseObserver.onCompleted();
    }

    @Override
    public void controlLight(ControlLightRequest req, StreamObserver<LightControlResponse> responseObserver) {
        boolean isOn = req.getTurnOn();
        // 实现控制逻辑
        LightControlResponse response = LightControlResponse.newBuilder()
                .setSuccess(true) // 假设控制总是成功
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void monitorLightStream(StreamObserver<MonitorLightRequest> requestObserver,
                                   StreamObserver<LightStatus> responseObserver) {
        // 实现持续监控逻辑
        requestObserver.onCompleted();
    }
}
