package com.smartclassroom;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 灯光服务接口定义
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: light.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LightServiceGrpc {

  private LightServiceGrpc() {}

  public static final String SERVICE_NAME = "LightService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<LightProto.GetLightStatusRequest,
      LightProto.LightStatus> getGetLightStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLightStatus",
      requestType = LightProto.GetLightStatusRequest.class,
      responseType = LightProto.LightStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<LightProto.GetLightStatusRequest,
      LightProto.LightStatus> getGetLightStatusMethod() {
    io.grpc.MethodDescriptor<LightProto.GetLightStatusRequest, LightProto.LightStatus> getGetLightStatusMethod;
    if ((getGetLightStatusMethod = LightServiceGrpc.getGetLightStatusMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getGetLightStatusMethod = LightServiceGrpc.getGetLightStatusMethod) == null) {
          LightServiceGrpc.getGetLightStatusMethod = getGetLightStatusMethod =
              io.grpc.MethodDescriptor.<LightProto.GetLightStatusRequest, LightProto.LightStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLightStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LightProto.GetLightStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LightProto.LightStatus.getDefaultInstance()))
              .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("GetLightStatus"))
              .build();
        }
      }
    }
    return getGetLightStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<LightProto.ControlLightRequest,
      LightProto.LightControlResponse> getControlLightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlLights",
      requestType = LightProto.ControlLightRequest.class,
      responseType = LightProto.LightControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<LightProto.ControlLightRequest,
      LightProto.LightControlResponse> getControlLightsMethod() {
    io.grpc.MethodDescriptor<LightProto.ControlLightRequest, LightProto.LightControlResponse> getControlLightsMethod;
    if ((getControlLightsMethod = LightServiceGrpc.getControlLightsMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getControlLightsMethod = LightServiceGrpc.getControlLightsMethod) == null) {
          LightServiceGrpc.getControlLightsMethod = getControlLightsMethod =
              io.grpc.MethodDescriptor.<LightProto.ControlLightRequest, LightProto.LightControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlLights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LightProto.ControlLightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LightProto.LightControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("ControlLights"))
              .build();
        }
      }
    }
    return getControlLightsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightServiceStub>() {
        @Override
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
        @Override
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
        @Override
        public LightServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightServiceFutureStub(channel, callOptions);
        }
      };
    return LightServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 灯光服务接口定义
   * </pre>
   */
  public static abstract class LightServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 一元 RPC：获取灯的状态
     * </pre>
     */
    public void getLightStatus(LightProto.GetLightStatusRequest request,
                               io.grpc.stub.StreamObserver<LightProto.LightStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLightStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * 客户端流式 RPC：批量控制灯光
     * </pre>
     */
    public io.grpc.stub.StreamObserver<LightProto.ControlLightRequest> controlLights(
        io.grpc.stub.StreamObserver<LightProto.LightControlResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getControlLightsMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetLightStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                LightProto.GetLightStatusRequest,
                LightProto.LightStatus>(
                  this, METHODID_GET_LIGHT_STATUS)))
          .addMethod(
            getControlLightsMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                LightProto.ControlLightRequest,
                LightProto.LightControlResponse>(
                  this, METHODID_CONTROL_LIGHTS)))
          .build();
    }
  }

  /**
   * <pre>
   * 灯光服务接口定义
   * </pre>
   */
  public static final class LightServiceStub extends io.grpc.stub.AbstractAsyncStub<LightServiceStub> {
    private LightServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LightServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一元 RPC：获取灯的状态
     * </pre>
     */
    public void getLightStatus(LightProto.GetLightStatusRequest request,
                               io.grpc.stub.StreamObserver<LightProto.LightStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLightStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 客户端流式 RPC：批量控制灯光
     * </pre>
     */
    public io.grpc.stub.StreamObserver<LightProto.ControlLightRequest> controlLights(
        io.grpc.stub.StreamObserver<LightProto.LightControlResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getControlLightsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * 灯光服务接口定义
   * </pre>
   */
  public static final class LightServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<LightServiceBlockingStub> {
    private LightServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LightServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一元 RPC：获取灯的状态
     * </pre>
     */
    public LightProto.LightStatus getLightStatus(LightProto.GetLightStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLightStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 灯光服务接口定义
   * </pre>
   */
  public static final class LightServiceFutureStub extends io.grpc.stub.AbstractFutureStub<LightServiceFutureStub> {
    private LightServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LightServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一元 RPC：获取灯的状态
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<LightProto.LightStatus> getLightStatus(
        LightProto.GetLightStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLightStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LIGHT_STATUS = 0;
  private static final int METHODID_CONTROL_LIGHTS = 1;

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

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LIGHT_STATUS:
          serviceImpl.getLightStatus((LightProto.GetLightStatusRequest) request,
              (io.grpc.stub.StreamObserver<LightProto.LightStatus>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONTROL_LIGHTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.controlLights(
              (io.grpc.stub.StreamObserver<LightProto.LightControlResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return LightProto.getDescriptor();
    }

    @Override
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

    @Override
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
              .addMethod(getControlLightsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
