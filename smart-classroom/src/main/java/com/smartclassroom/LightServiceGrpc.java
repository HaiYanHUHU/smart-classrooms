package com.smartclassroom;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 定义灯的服务接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: light.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LightServiceGrpc {

  private LightServiceGrpc() {}

  public static final String SERVICE_NAME = "smartclassroom.LightService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.LightProto.GetLightStatusRequest,
      com.smartclassroom.LightProto.LightStatus> getGetLightStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLightStatus",
      requestType = com.smartclassroom.LightProto.GetLightStatusRequest.class,
      responseType = com.smartclassroom.LightProto.LightStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartclassroom.LightProto.GetLightStatusRequest,
      com.smartclassroom.LightProto.LightStatus> getGetLightStatusMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.LightProto.GetLightStatusRequest, com.smartclassroom.LightProto.LightStatus> getGetLightStatusMethod;
    if ((getGetLightStatusMethod = LightServiceGrpc.getGetLightStatusMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getGetLightStatusMethod = LightServiceGrpc.getGetLightStatusMethod) == null) {
          LightServiceGrpc.getGetLightStatusMethod = getGetLightStatusMethod =
              io.grpc.MethodDescriptor.<com.smartclassroom.LightProto.GetLightStatusRequest, com.smartclassroom.LightProto.LightStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLightStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.LightProto.GetLightStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.LightProto.LightStatus.getDefaultInstance()))
              .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("GetLightStatus"))
              .build();
        }
      }
    }
    return getGetLightStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.LightProto.ControlLightRequest,
      com.smartclassroom.LightProto.LightControlResponse> getControlLightMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlLight",
      requestType = com.smartclassroom.LightProto.ControlLightRequest.class,
      responseType = com.smartclassroom.LightProto.LightControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartclassroom.LightProto.ControlLightRequest,
      com.smartclassroom.LightProto.LightControlResponse> getControlLightMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.LightProto.ControlLightRequest, com.smartclassroom.LightProto.LightControlResponse> getControlLightMethod;
    if ((getControlLightMethod = LightServiceGrpc.getControlLightMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getControlLightMethod = LightServiceGrpc.getControlLightMethod) == null) {
          LightServiceGrpc.getControlLightMethod = getControlLightMethod =
              io.grpc.MethodDescriptor.<com.smartclassroom.LightProto.ControlLightRequest, com.smartclassroom.LightProto.LightControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlLight"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.LightProto.ControlLightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.LightProto.LightControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("ControlLight"))
              .build();
        }
      }
    }
    return getControlLightMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.LightProto.MonitorLightRequest,
      com.smartclassroom.LightProto.LightStatus> getMonitorLightStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorLightStream",
      requestType = com.smartclassroom.LightProto.MonitorLightRequest.class,
      responseType = com.smartclassroom.LightProto.LightStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartclassroom.LightProto.MonitorLightRequest,
      com.smartclassroom.LightProto.LightStatus> getMonitorLightStreamMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.LightProto.MonitorLightRequest, com.smartclassroom.LightProto.LightStatus> getMonitorLightStreamMethod;
    if ((getMonitorLightStreamMethod = LightServiceGrpc.getMonitorLightStreamMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getMonitorLightStreamMethod = LightServiceGrpc.getMonitorLightStreamMethod) == null) {
          LightServiceGrpc.getMonitorLightStreamMethod = getMonitorLightStreamMethod =
              io.grpc.MethodDescriptor.<com.smartclassroom.LightProto.MonitorLightRequest, com.smartclassroom.LightProto.LightStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorLightStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.LightProto.MonitorLightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.LightProto.LightStatus.getDefaultInstance()))
              .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("MonitorLightStream"))
              .build();
        }
      }
    }
    return getMonitorLightStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightServiceStub>() {
        @java.lang.Override
        public LightServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightServiceStub(channel, callOptions);
        }
      };
    return LightServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightServiceBlockingStub>() {
        @java.lang.Override
        public LightServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightServiceBlockingStub(channel, callOptions);
        }
      };
    return LightServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightServiceFutureStub>() {
        @java.lang.Override
        public LightServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightServiceFutureStub(channel, callOptions);
        }
      };
    return LightServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 定义灯的服务接口
   * </pre>
   */
  public static abstract class LightServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 获取灯的状态
     * </pre>
     */
    public void getLightStatus(com.smartclassroom.LightProto.GetLightStatusRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.LightProto.LightStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLightStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * 控制灯的开关
     * </pre>
     */
    public void controlLight(com.smartclassroom.LightProto.ControlLightRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.LightProto.LightControlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getControlLightMethod(), responseObserver);
    }

    /**
     * <pre>
     * 实时监控灯的状态
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.smartclassroom.LightProto.MonitorLightRequest> monitorLightStream(
        io.grpc.stub.StreamObserver<com.smartclassroom.LightProto.LightStatus> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getMonitorLightStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetLightStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.smartclassroom.LightProto.GetLightStatusRequest,
                com.smartclassroom.LightProto.LightStatus>(
                  this, METHODID_GET_LIGHT_STATUS)))
          .addMethod(
            getControlLightMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.smartclassroom.LightProto.ControlLightRequest,
                com.smartclassroom.LightProto.LightControlResponse>(
                  this, METHODID_CONTROL_LIGHT)))
          .addMethod(
            getMonitorLightStreamMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.smartclassroom.LightProto.MonitorLightRequest,
                com.smartclassroom.LightProto.LightStatus>(
                  this, METHODID_MONITOR_LIGHT_STREAM)))
          .build();
    }
  }

  /**
   * <pre>
   * 定义灯的服务接口
   * </pre>
   */
  public static final class LightServiceStub extends io.grpc.stub.AbstractAsyncStub<LightServiceStub> {
    private LightServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取灯的状态
     * </pre>
     */
    public void getLightStatus(com.smartclassroom.LightProto.GetLightStatusRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.LightProto.LightStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLightStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 控制灯的开关
     * </pre>
     */
    public void controlLight(com.smartclassroom.LightProto.ControlLightRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.LightProto.LightControlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getControlLightMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 实时监控灯的状态
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.smartclassroom.LightProto.MonitorLightRequest> monitorLightStream(
        io.grpc.stub.StreamObserver<com.smartclassroom.LightProto.LightStatus> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getMonitorLightStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * 定义灯的服务接口
   * </pre>
   */
  public static final class LightServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<LightServiceBlockingStub> {
    private LightServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取灯的状态
     * </pre>
     */
    public com.smartclassroom.LightProto.LightStatus getLightStatus(com.smartclassroom.LightProto.GetLightStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLightStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 控制灯的开关
     * </pre>
     */
    public com.smartclassroom.LightProto.LightControlResponse controlLight(com.smartclassroom.LightProto.ControlLightRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getControlLightMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 定义灯的服务接口
   * </pre>
   */
  public static final class LightServiceFutureStub extends io.grpc.stub.AbstractFutureStub<LightServiceFutureStub> {
    private LightServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取灯的状态
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartclassroom.LightProto.LightStatus> getLightStatus(
        com.smartclassroom.LightProto.GetLightStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLightStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 控制灯的开关
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartclassroom.LightProto.LightControlResponse> controlLight(
        com.smartclassroom.LightProto.ControlLightRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getControlLightMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LIGHT_STATUS = 0;
  private static final int METHODID_CONTROL_LIGHT = 1;
  private static final int METHODID_MONITOR_LIGHT_STREAM = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LIGHT_STATUS:
          serviceImpl.getLightStatus((com.smartclassroom.LightProto.GetLightStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.smartclassroom.LightProto.LightStatus>) responseObserver);
          break;
        case METHODID_CONTROL_LIGHT:
          serviceImpl.controlLight((com.smartclassroom.LightProto.ControlLightRequest) request,
              (io.grpc.stub.StreamObserver<com.smartclassroom.LightProto.LightControlResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MONITOR_LIGHT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.monitorLightStream(
              (io.grpc.stub.StreamObserver<com.smartclassroom.LightProto.LightStatus>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartclassroom.LightProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightService");
    }
  }

  private static final class LightServiceFileDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier {
    LightServiceFileDescriptorSupplier() {}
  }

  private static final class LightServiceMethodDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LightServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightServiceFileDescriptorSupplier())
              .addMethod(getGetLightStatusMethod())
              .addMethod(getControlLightMethod())
              .addMethod(getMonitorLightStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
