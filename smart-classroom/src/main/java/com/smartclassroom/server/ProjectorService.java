package com.smartclassroom.server;

import com.smartclassroom.ProjectorServiceGrpc;
import io.grpc.stub.StreamObserver;
import com.smartclassroom.ProjectorProto.*;

public class ProjectorService extends ProjectorServiceGrpc.ProjectorServiceImplBase {

    @Override
    public void getProjectorStatus(GetProjectorStatusRequest req, StreamObserver<ProjectorStatus> responseObserver) {
        ProjectorStatus status = ProjectorStatus.newBuilder()
                .setName("Main Projector")
                .setIsOn(true) // 假设投影仪默认是开的
                .build();
        responseObserver.onNext(status);
        responseObserver.onCompleted();
    }

    @Override
    public void controlProjector(ControlProjectorRequest req, StreamObserver<ProjectorControlResponse> responseObserver) {
        boolean isOn = req.getTurnOn();
        // 实现控制逻辑
        ProjectorControlResponse response = ProjectorControlResponse.newBuilder()
                .setSuccess(true) // 假设控制总是成功
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    public void monitorProjectorStream(StreamObserver<MonitorProjectorRequest> requestObserver,
                                       StreamObserver<ProjectorStatus> responseObserver) {
        // 实现持续监控逻辑
        requestObserver.onCompleted();
    }
}
