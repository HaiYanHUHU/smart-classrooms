package com.smartclassroom;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 暖气服务定义
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: heating.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HeatingServiceGrpc {

  private HeatingServiceGrpc() {}

  public static final String SERVICE_NAME = "HeatingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<HeatingProto.GetHeatingStatusRequest,
      HeatingProto.HeatingStatus> getGetHeatingStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHeatingStatus",
      requestType = HeatingProto.GetHeatingStatusRequest.class,
      responseType = HeatingProto.HeatingStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<HeatingProto.GetHeatingStatusRequest,
      HeatingProto.HeatingStatus> getGetHeatingStatusMethod() {
    io.grpc.MethodDescriptor<HeatingProto.GetHeatingStatusRequest, HeatingProto.HeatingStatus> getGetHeatingStatusMethod;
    if ((getGetHeatingStatusMethod = HeatingServiceGrpc.getGetHeatingStatusMethod) == null) {
      synchronized (HeatingServiceGrpc.class) {
        if ((getGetHeatingStatusMethod = HeatingServiceGrpc.getGetHeatingStatusMethod) == null) {
          HeatingServiceGrpc.getGetHeatingStatusMethod = getGetHeatingStatusMethod =
              io.grpc.MethodDescriptor.<HeatingProto.GetHeatingStatusRequest, HeatingProto.HeatingStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHeatingStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HeatingProto.GetHeatingStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HeatingProto.HeatingStatus.getDefaultInstance()))
              .setSchemaDescriptor(new HeatingServiceMethodDescriptorSupplier("GetHeatingStatus"))
              .build();
        }
      }
    }
    return getGetHeatingStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<HeatingProto.HeatingEventsRequest,
      HeatingProto.HeatingStatus> getStreamHeatingEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamHeatingEvents",
      requestType = HeatingProto.HeatingEventsRequest.class,
      responseType = HeatingProto.HeatingStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<HeatingProto.HeatingEventsRequest,
      HeatingProto.HeatingStatus> getStreamHeatingEventsMethod() {
    io.grpc.MethodDescriptor<HeatingProto.HeatingEventsRequest, HeatingProto.HeatingStatus> getStreamHeatingEventsMethod;
    if ((getStreamHeatingEventsMethod = HeatingServiceGrpc.getStreamHeatingEventsMethod) == null) {
      synchronized (HeatingServiceGrpc.class) {
        if ((getStreamHeatingEventsMethod = HeatingServiceGrpc.getStreamHeatingEventsMethod) == null) {
          HeatingServiceGrpc.getStreamHeatingEventsMethod = getStreamHeatingEventsMethod =
              io.grpc.MethodDescriptor.<HeatingProto.HeatingEventsRequest, HeatingProto.HeatingStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamHeatingEvents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HeatingProto.HeatingEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HeatingProto.HeatingStatus.getDefaultInstance()))
              .setSchemaDescriptor(new HeatingServiceMethodDescriptorSupplier("StreamHeatingEvents"))
              .build();
        }
      }
    }
    return getStreamHeatingEventsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<HeatingProto.ControlHeatingRequest,
      HeatingProto.HeatingControlResponse> getControlHeatingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlHeating",
      requestType = HeatingProto.ControlHeatingRequest.class,
      responseType = HeatingProto.HeatingControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<HeatingProto.ControlHeatingRequest,
      HeatingProto.HeatingControlResponse> getControlHeatingMethod() {
    io.grpc.MethodDescriptor<HeatingProto.ControlHeatingRequest, HeatingProto.HeatingControlResponse> getControlHeatingMethod;
    if ((getControlHeatingMethod = HeatingServiceGrpc.getControlHeatingMethod) == null) {
      synchronized (HeatingServiceGrpc.class) {
        if ((getControlHeatingMethod = HeatingServiceGrpc.getControlHeatingMethod) == null) {
          HeatingServiceGrpc.getControlHeatingMethod = getControlHeatingMethod =
              io.grpc.MethodDescriptor.<HeatingProto.ControlHeatingRequest, HeatingProto.HeatingControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlHeating"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HeatingProto.ControlHeatingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HeatingProto.HeatingControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HeatingServiceMethodDescriptorSupplier("ControlHeating"))
              .build();
        }
      }
    }
    return getControlHeatingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<HeatingProto.MonitorHeatingRequest,
      HeatingProto.HeatingStatus> getMonitorHeatingStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorHeatingStream",
      requestType = HeatingProto.MonitorHeatingRequest.class,
      responseType = HeatingProto.HeatingStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<HeatingProto.MonitorHeatingRequest,
      HeatingProto.HeatingStatus> getMonitorHeatingStreamMethod() {
    io.grpc.MethodDescriptor<HeatingProto.MonitorHeatingRequest, HeatingProto.HeatingStatus> getMonitorHeatingStreamMethod;
    if ((getMonitorHeatingStreamMethod = HeatingServiceGrpc.getMonitorHeatingStreamMethod) == null) {
      synchronized (HeatingServiceGrpc.class) {
        if ((getMonitorHeatingStreamMethod = HeatingServiceGrpc.getMonitorHeatingStreamMethod) == null) {
          HeatingServiceGrpc.getMonitorHeatingStreamMethod = getMonitorHeatingStreamMethod =
              io.grpc.MethodDescriptor.<HeatingProto.MonitorHeatingRequest, HeatingProto.HeatingStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorHeatingStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HeatingProto.MonitorHeatingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HeatingProto.HeatingStatus.getDefaultInstance()))
              .setSchemaDescriptor(new HeatingServiceMethodDescriptorSupplier("MonitorHeatingStream"))
              .build();
        }
      }
    }
    return getMonitorHeatingStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HeatingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HeatingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HeatingServiceStub>() {
        @Override
        public HeatingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HeatingServiceStub(channel, callOptions);
        }
      };
    return HeatingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HeatingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HeatingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HeatingServiceBlockingStub>() {
        @Override
        public HeatingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HeatingServiceBlockingStub(channel, callOptions);
        }
      };
    return HeatingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HeatingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HeatingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HeatingServiceFutureStub>() {
        @Override
        public HeatingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HeatingServiceFutureStub(channel, callOptions);
        }
      };
    return HeatingServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 暖气服务定义
   * </pre>
   */
  public static abstract class HeatingServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 一元 RPC：获取暖气状态
     * </pre>
     */
    public void getHeatingStatus(HeatingProto.GetHeatingStatusRequest request,
                                 io.grpc.stub.StreamObserver<HeatingProto.HeatingStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetHeatingStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * 服务端流式 RPC：持续发送暖气状态
     * </pre>
     */
    public void streamHeatingEvents(HeatingProto.HeatingEventsRequest request,
                                    io.grpc.stub.StreamObserver<HeatingProto.HeatingStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamHeatingEventsMethod(), responseObserver);
    }

    /**
     * <pre>
     * 客户端流式 RPC：接收多个控制命令并返回统一响应
     * </pre>
     */
    public io.grpc.stub.StreamObserver<HeatingProto.ControlHeatingRequest> controlHeating(
        io.grpc.stub.StreamObserver<HeatingProto.HeatingControlResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getControlHeatingMethod(), responseObserver);
    }

    /**
     * <pre>
     * 双向流 RPC：暖气状态和控制命令双向传输
     * </pre>
     */
    public io.grpc.stub.StreamObserver<HeatingProto.MonitorHeatingRequest> monitorHeatingStream(
        io.grpc.stub.StreamObserver<HeatingProto.HeatingStatus> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getMonitorHeatingStreamMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetHeatingStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                HeatingProto.GetHeatingStatusRequest,
                HeatingProto.HeatingStatus>(
                  this, METHODID_GET_HEATING_STATUS)))
          .addMethod(
            getStreamHeatingEventsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                HeatingProto.HeatingEventsRequest,
                HeatingProto.HeatingStatus>(
                  this, METHODID_STREAM_HEATING_EVENTS)))
          .addMethod(
            getControlHeatingMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                HeatingProto.ControlHeatingRequest,
                HeatingProto.HeatingControlResponse>(
                  this, METHODID_CONTROL_HEATING)))
          .addMethod(
            getMonitorHeatingStreamMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                HeatingProto.MonitorHeatingRequest,
                HeatingProto.HeatingStatus>(
                  this, METHODID_MONITOR_HEATING_STREAM)))
          .build();
    }
  }

  /**
   * <pre>
   * 暖气服务定义
   * </pre>
   */
  public static final class HeatingServiceStub extends io.grpc.stub.AbstractAsyncStub<HeatingServiceStub> {
    private HeatingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected HeatingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HeatingServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一元 RPC：获取暖气状态
     * </pre>
     */
    public void getHeatingStatus(HeatingProto.GetHeatingStatusRequest request,
                                 io.grpc.stub.StreamObserver<HeatingProto.HeatingStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHeatingStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 服务端流式 RPC：持续发送暖气状态
     * </pre>
     */
    public void streamHeatingEvents(HeatingProto.HeatingEventsRequest request,
                                    io.grpc.stub.StreamObserver<HeatingProto.HeatingStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamHeatingEventsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 客户端流式 RPC：接收多个控制命令并返回统一响应
     * </pre>
     */
    public io.grpc.stub.StreamObserver<HeatingProto.ControlHeatingRequest> controlHeating(
        io.grpc.stub.StreamObserver<HeatingProto.HeatingControlResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getControlHeatingMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * 双向流 RPC：暖气状态和控制命令双向传输
     * </pre>
     */
    public io.grpc.stub.StreamObserver<HeatingProto.MonitorHeatingRequest> monitorHeatingStream(
        io.grpc.stub.StreamObserver<HeatingProto.HeatingStatus> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getMonitorHeatingStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * 暖气服务定义
   * </pre>
   */
  public static final class HeatingServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<HeatingServiceBlockingStub> {
    private HeatingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected HeatingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HeatingServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一元 RPC：获取暖气状态
     * </pre>
     */
    public HeatingProto.HeatingStatus getHeatingStatus(HeatingProto.GetHeatingStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHeatingStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 服务端流式 RPC：持续发送暖气状态
     * </pre>
     */
    public java.util.Iterator<HeatingProto.HeatingStatus> streamHeatingEvents(
        HeatingProto.HeatingEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamHeatingEventsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 暖气服务定义
   * </pre>
   */
  public static final class HeatingServiceFutureStub extends io.grpc.stub.AbstractFutureStub<HeatingServiceFutureStub> {
    private HeatingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected HeatingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HeatingServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一元 RPC：获取暖气状态
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<HeatingProto.HeatingStatus> getHeatingStatus(
        HeatingProto.GetHeatingStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHeatingStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_HEATING_STATUS = 0;
  private static final int METHODID_STREAM_HEATING_EVENTS = 1;
  private static final int METHODID_CONTROL_HEATING = 2;
  private static final int METHODID_MONITOR_HEATING_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HeatingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HeatingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_HEATING_STATUS:
          serviceImpl.getHeatingStatus((HeatingProto.GetHeatingStatusRequest) request,
              (io.grpc.stub.StreamObserver<HeatingProto.HeatingStatus>) responseObserver);
          break;
        case METHODID_STREAM_HEATING_EVENTS:
          serviceImpl.streamHeatingEvents((HeatingProto.HeatingEventsRequest) request,
              (io.grpc.stub.StreamObserver<HeatingProto.HeatingStatus>) responseObserver);
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
        case METHODID_CONTROL_HEATING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.controlHeating(
              (io.grpc.stub.StreamObserver<HeatingProto.HeatingControlResponse>) responseObserver);
        case METHODID_MONITOR_HEATING_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.monitorHeatingStream(
              (io.grpc.stub.StreamObserver<HeatingProto.HeatingStatus>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HeatingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HeatingServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return HeatingProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HeatingService");
    }
  }

  private static final class HeatingServiceFileDescriptorSupplier
      extends HeatingServiceBaseDescriptorSupplier {
    HeatingServiceFileDescriptorSupplier() {}
  }

  private static final class HeatingServiceMethodDescriptorSupplier
      extends HeatingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HeatingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HeatingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HeatingServiceFileDescriptorSupplier())
              .addMethod(getGetHeatingStatusMethod())
              .addMethod(getStreamHeatingEventsMethod())
              .addMethod(getControlHeatingMethod())
              .addMethod(getMonitorHeatingStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
