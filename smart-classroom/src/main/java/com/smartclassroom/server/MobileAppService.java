package com.smartclassroom.server;

import com.smartclassroom.MobileAppServiceGrpc;
import io.grpc.stub.StreamObserver;
import com.smartclassroom.MobileAppProto.*;

public class MobileAppService extends MobileAppServiceGrpc.MobileAppServiceImplBase {


    public void showStatus(ShowStatusRequest req, StreamObserver<ShowStatusResponse> responseObserver) {
        // 构造假设的设备状态响应
        ShowStatusResponse response = ShowStatusResponse.newBuilder()
                .addDevicesStatus(ShowStatusResponse.DeviceStatus.newBuilder()
                        .setName("Classroom Light")
                        .setIsOn(true)
                        .build())
                .addDevicesStatus(ShowStatusResponse.DeviceStatus.newBuilder()
                        .setName("Main Projector")
                        .setIsOn(false)
                        .build())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    public StreamObserver<ControlDevicesRequest> controlDevices(final StreamObserver<ControlDevicesResponse> responseObserver) {
        return new StreamObserver<ControlDevicesRequest>() {
            @Override
            public void onNext(ControlDevicesRequest request) {
                System.out.println("Received control request for device: " + request.getDeviceName() + " to turn " + (request.getTurnOn() ? "on" : "off"));
                // 假设设备控制成功
                ControlDevicesResponse response = ControlDevicesResponse.newBuilder()
                        .setSuccess(true)
                        .build();
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Stream failed: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("All device control requests processed.");
                responseObserver.onCompleted();
            }
        };
    }
}
