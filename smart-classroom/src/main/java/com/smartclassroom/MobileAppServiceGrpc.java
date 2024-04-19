package com.smartclassroom;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 定义移动应用的服务接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: mobileapp.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MobileAppServiceGrpc {

  private MobileAppServiceGrpc() {}

  public static final String SERVICE_NAME = "smartclassroom.MobileAppService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.MobileAppProto.ShowStatusRequest,
      com.smartclassroom.MobileAppProto.ShowStatusResponse> getShowStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ShowStatus",
      requestType = com.smartclassroom.MobileAppProto.ShowStatusRequest.class,
      responseType = com.smartclassroom.MobileAppProto.ShowStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartclassroom.MobileAppProto.ShowStatusRequest,
      com.smartclassroom.MobileAppProto.ShowStatusResponse> getShowStatusMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.MobileAppProto.ShowStatusRequest, com.smartclassroom.MobileAppProto.ShowStatusResponse> getShowStatusMethod;
    if ((getShowStatusMethod = MobileAppServiceGrpc.getShowStatusMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getShowStatusMethod = MobileAppServiceGrpc.getShowStatusMethod) == null) {
          MobileAppServiceGrpc.getShowStatusMethod = getShowStatusMethod =
              io.grpc.MethodDescriptor.<com.smartclassroom.MobileAppProto.ShowStatusRequest, com.smartclassroom.MobileAppProto.ShowStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ShowStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.MobileAppProto.ShowStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.MobileAppProto.ShowStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("ShowStatus"))
              .build();
        }
      }
    }
    return getShowStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.MobileAppProto.ControlDevicesRequest,
      com.smartclassroom.MobileAppProto.ControlDevicesResponse> getControlDevicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlDevices",
      requestType = com.smartclassroom.MobileAppProto.ControlDevicesRequest.class,
      responseType = com.smartclassroom.MobileAppProto.ControlDevicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartclassroom.MobileAppProto.ControlDevicesRequest,
      com.smartclassroom.MobileAppProto.ControlDevicesResponse> getControlDevicesMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.MobileAppProto.ControlDevicesRequest, com.smartclassroom.MobileAppProto.ControlDevicesResponse> getControlDevicesMethod;
    if ((getControlDevicesMethod = MobileAppServiceGrpc.getControlDevicesMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getControlDevicesMethod = MobileAppServiceGrpc.getControlDevicesMethod) == null) {
          MobileAppServiceGrpc.getControlDevicesMethod = getControlDevicesMethod =
              io.grpc.MethodDescriptor.<com.smartclassroom.MobileAppProto.ControlDevicesRequest, com.smartclassroom.MobileAppProto.ControlDevicesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlDevices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.MobileAppProto.ControlDevicesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.MobileAppProto.ControlDevicesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("ControlDevices"))
              .build();
        }
      }
    }
    return getControlDevicesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MobileAppServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MobileAppServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MobileAppServiceStub>() {
        @java.lang.Override
        public MobileAppServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MobileAppServiceStub(channel, callOptions);
        }
      };
    return MobileAppServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MobileAppServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MobileAppServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MobileAppServiceBlockingStub>() {
        @java.lang.Override
        public MobileAppServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MobileAppServiceBlockingStub(channel, callOptions);
        }
      };
    return MobileAppServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MobileAppServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MobileAppServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MobileAppServiceFutureStub>() {
        @java.lang.Override
        public MobileAppServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MobileAppServiceFutureStub(channel, callOptions);
        }
      };
    return MobileAppServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 定义移动应用的服务接口
   * </pre>
   */
  public static abstract class MobileAppServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 显示灯和投影仪的状态
     * </pre>
     */
    public void showStatus(com.smartclassroom.MobileAppProto.ShowStatusRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.MobileAppProto.ShowStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getShowStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * 控制灯和投影仪 这是一个客户端流
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.smartclassroom.MobileAppProto.ControlDevicesRequest> controlDevices(
        io.grpc.stub.StreamObserver<com.smartclassroom.MobileAppProto.ControlDevicesResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getControlDevicesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getShowStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.smartclassroom.MobileAppProto.ShowStatusRequest,
                com.smartclassroom.MobileAppProto.ShowStatusResponse>(
                  this, METHODID_SHOW_STATUS)))
          .addMethod(
            getControlDevicesMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                com.smartclassroom.MobileAppProto.ControlDevicesRequest,
                com.smartclassroom.MobileAppProto.ControlDevicesResponse>(
                  this, METHODID_CONTROL_DEVICES)))
          .build();
    }
  }

  /**
   * <pre>
   * 定义移动应用的服务接口
   * </pre>
   */
  public static final class MobileAppServiceStub extends io.grpc.stub.AbstractAsyncStub<MobileAppServiceStub> {
    private MobileAppServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MobileAppServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MobileAppServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 显示灯和投影仪的状态
     * </pre>
     */
    public void showStatus(com.smartclassroom.MobileAppProto.ShowStatusRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.MobileAppProto.ShowStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShowStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 控制灯和投影仪 这是一个客户端流
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.smartclassroom.MobileAppProto.ControlDevicesRequest> controlDevices(
        io.grpc.stub.StreamObserver<com.smartclassroom.MobileAppProto.ControlDevicesResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getControlDevicesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * 定义移动应用的服务接口
   * </pre>
   */
  public static final class MobileAppServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MobileAppServiceBlockingStub> {
    private MobileAppServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MobileAppServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MobileAppServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 显示灯和投影仪的状态
     * </pre>
     */
    public com.smartclassroom.MobileAppProto.ShowStatusResponse showStatus(com.smartclassroom.MobileAppProto.ShowStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShowStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 定义移动应用的服务接口
   * </pre>
   */
  public static final class MobileAppServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MobileAppServiceFutureStub> {
    private MobileAppServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MobileAppServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MobileAppServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 显示灯和投影仪的状态
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartclassroom.MobileAppProto.ShowStatusResponse> showStatus(
        com.smartclassroom.MobileAppProto.ShowStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShowStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SHOW_STATUS = 0;
  private static final int METHODID_CONTROL_DEVICES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MobileAppServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MobileAppServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SHOW_STATUS:
          serviceImpl.showStatus((com.smartclassroom.MobileAppProto.ShowStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.smartclassroom.MobileAppProto.ShowStatusResponse>) responseObserver);
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
        case METHODID_CONTROL_DEVICES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.controlDevices(
              (io.grpc.stub.StreamObserver<com.smartclassroom.MobileAppProto.ControlDevicesResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MobileAppServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MobileAppServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartclassroom.MobileAppProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MobileAppService");
    }
  }

  private static final class MobileAppServiceFileDescriptorSupplier
      extends MobileAppServiceBaseDescriptorSupplier {
    MobileAppServiceFileDescriptorSupplier() {}
  }

  private static final class MobileAppServiceMethodDescriptorSupplier
      extends MobileAppServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MobileAppServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MobileAppServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MobileAppServiceFileDescriptorSupplier())
              .addMethod(getShowStatusMethod())
              .addMethod(getControlDevicesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
