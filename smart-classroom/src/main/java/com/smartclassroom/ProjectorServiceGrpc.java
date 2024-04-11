package com.smartclassroom;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 定义投影仪的服务接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: projector.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProjectorServiceGrpc {

  private ProjectorServiceGrpc() {}

  public static final String SERVICE_NAME = "smartclassroom.ProjectorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.ProjectorProto.GetProjectorStatusRequest,
      com.smartclassroom.ProjectorProto.ProjectorStatus> getGetProjectorStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProjectorStatus",
      requestType = com.smartclassroom.ProjectorProto.GetProjectorStatusRequest.class,
      responseType = com.smartclassroom.ProjectorProto.ProjectorStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartclassroom.ProjectorProto.GetProjectorStatusRequest,
      com.smartclassroom.ProjectorProto.ProjectorStatus> getGetProjectorStatusMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.ProjectorProto.GetProjectorStatusRequest, com.smartclassroom.ProjectorProto.ProjectorStatus> getGetProjectorStatusMethod;
    if ((getGetProjectorStatusMethod = ProjectorServiceGrpc.getGetProjectorStatusMethod) == null) {
      synchronized (ProjectorServiceGrpc.class) {
        if ((getGetProjectorStatusMethod = ProjectorServiceGrpc.getGetProjectorStatusMethod) == null) {
          ProjectorServiceGrpc.getGetProjectorStatusMethod = getGetProjectorStatusMethod =
              io.grpc.MethodDescriptor.<com.smartclassroom.ProjectorProto.GetProjectorStatusRequest, com.smartclassroom.ProjectorProto.ProjectorStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProjectorStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.ProjectorProto.GetProjectorStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.ProjectorProto.ProjectorStatus.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectorServiceMethodDescriptorSupplier("GetProjectorStatus"))
              .build();
        }
      }
    }
    return getGetProjectorStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.ProjectorProto.ControlProjectorRequest,
      com.smartclassroom.ProjectorProto.ProjectorControlResponse> getControlProjectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlProjector",
      requestType = com.smartclassroom.ProjectorProto.ControlProjectorRequest.class,
      responseType = com.smartclassroom.ProjectorProto.ProjectorControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartclassroom.ProjectorProto.ControlProjectorRequest,
      com.smartclassroom.ProjectorProto.ProjectorControlResponse> getControlProjectorMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.ProjectorProto.ControlProjectorRequest, com.smartclassroom.ProjectorProto.ProjectorControlResponse> getControlProjectorMethod;
    if ((getControlProjectorMethod = ProjectorServiceGrpc.getControlProjectorMethod) == null) {
      synchronized (ProjectorServiceGrpc.class) {
        if ((getControlProjectorMethod = ProjectorServiceGrpc.getControlProjectorMethod) == null) {
          ProjectorServiceGrpc.getControlProjectorMethod = getControlProjectorMethod =
              io.grpc.MethodDescriptor.<com.smartclassroom.ProjectorProto.ControlProjectorRequest, com.smartclassroom.ProjectorProto.ProjectorControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlProjector"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.ProjectorProto.ControlProjectorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.ProjectorProto.ProjectorControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectorServiceMethodDescriptorSupplier("ControlProjector"))
              .build();
        }
      }
    }
    return getControlProjectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.ProjectorProto.MonitorProjectorRequest,
      com.smartclassroom.ProjectorProto.ProjectorStatus> getMonitorProjectorStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorProjectorStream",
      requestType = com.smartclassroom.ProjectorProto.MonitorProjectorRequest.class,
      responseType = com.smartclassroom.ProjectorProto.ProjectorStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartclassroom.ProjectorProto.MonitorProjectorRequest,
      com.smartclassroom.ProjectorProto.ProjectorStatus> getMonitorProjectorStreamMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.ProjectorProto.MonitorProjectorRequest, com.smartclassroom.ProjectorProto.ProjectorStatus> getMonitorProjectorStreamMethod;
    if ((getMonitorProjectorStreamMethod = ProjectorServiceGrpc.getMonitorProjectorStreamMethod) == null) {
      synchronized (ProjectorServiceGrpc.class) {
        if ((getMonitorProjectorStreamMethod = ProjectorServiceGrpc.getMonitorProjectorStreamMethod) == null) {
          ProjectorServiceGrpc.getMonitorProjectorStreamMethod = getMonitorProjectorStreamMethod =
              io.grpc.MethodDescriptor.<com.smartclassroom.ProjectorProto.MonitorProjectorRequest, com.smartclassroom.ProjectorProto.ProjectorStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorProjectorStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.ProjectorProto.MonitorProjectorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.ProjectorProto.ProjectorStatus.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectorServiceMethodDescriptorSupplier("MonitorProjectorStream"))
              .build();
        }
      }
    }
    return getMonitorProjectorStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProjectorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectorServiceStub>() {
        @java.lang.Override
        public ProjectorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectorServiceStub(channel, callOptions);
        }
      };
    return ProjectorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProjectorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectorServiceBlockingStub>() {
        @java.lang.Override
        public ProjectorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectorServiceBlockingStub(channel, callOptions);
        }
      };
    return ProjectorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProjectorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectorServiceFutureStub>() {
        @java.lang.Override
        public ProjectorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectorServiceFutureStub(channel, callOptions);
        }
      };
    return ProjectorServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 定义投影仪的服务接口
   * </pre>
   */
  public static abstract class ProjectorServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 获取投影仪的状态
     * </pre>
     */
    public void getProjectorStatus(com.smartclassroom.ProjectorProto.GetProjectorStatusRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.ProjectorProto.ProjectorStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProjectorStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * 控制投影仪的开关
     * </pre>
     */
    public void controlProjector(com.smartclassroom.ProjectorProto.ControlProjectorRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.ProjectorProto.ProjectorControlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getControlProjectorMethod(), responseObserver);
    }

    /**
     * <pre>
     * 实时监控投影仪的状态
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.smartclassroom.ProjectorProto.MonitorProjectorRequest> monitorProjectorStream(
        io.grpc.stub.StreamObserver<com.smartclassroom.ProjectorProto.ProjectorStatus> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getMonitorProjectorStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetProjectorStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.smartclassroom.ProjectorProto.GetProjectorStatusRequest,
                com.smartclassroom.ProjectorProto.ProjectorStatus>(
                  this, METHODID_GET_PROJECTOR_STATUS)))
          .addMethod(
            getControlProjectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.smartclassroom.ProjectorProto.ControlProjectorRequest,
                com.smartclassroom.ProjectorProto.ProjectorControlResponse>(
                  this, METHODID_CONTROL_PROJECTOR)))
          .addMethod(
            getMonitorProjectorStreamMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.smartclassroom.ProjectorProto.MonitorProjectorRequest,
                com.smartclassroom.ProjectorProto.ProjectorStatus>(
                  this, METHODID_MONITOR_PROJECTOR_STREAM)))
          .build();
    }
  }

  /**
   * <pre>
   * 定义投影仪的服务接口
   * </pre>
   */
  public static final class ProjectorServiceStub extends io.grpc.stub.AbstractAsyncStub<ProjectorServiceStub> {
    private ProjectorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectorServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取投影仪的状态
     * </pre>
     */
    public void getProjectorStatus(com.smartclassroom.ProjectorProto.GetProjectorStatusRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.ProjectorProto.ProjectorStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProjectorStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 控制投影仪的开关
     * </pre>
     */
    public void controlProjector(com.smartclassroom.ProjectorProto.ControlProjectorRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.ProjectorProto.ProjectorControlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getControlProjectorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 实时监控投影仪的状态
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.smartclassroom.ProjectorProto.MonitorProjectorRequest> monitorProjectorStream(
        io.grpc.stub.StreamObserver<com.smartclassroom.ProjectorProto.ProjectorStatus> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getMonitorProjectorStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * 定义投影仪的服务接口
   * </pre>
   */
  public static final class ProjectorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProjectorServiceBlockingStub> {
    private ProjectorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectorServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取投影仪的状态
     * </pre>
     */
    public com.smartclassroom.ProjectorProto.ProjectorStatus getProjectorStatus(com.smartclassroom.ProjectorProto.GetProjectorStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProjectorStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 控制投影仪的开关
     * </pre>
     */
    public com.smartclassroom.ProjectorProto.ProjectorControlResponse controlProjector(com.smartclassroom.ProjectorProto.ControlProjectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getControlProjectorMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 定义投影仪的服务接口
   * </pre>
   */
  public static final class ProjectorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ProjectorServiceFutureStub> {
    private ProjectorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectorServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取投影仪的状态
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartclassroom.ProjectorProto.ProjectorStatus> getProjectorStatus(
        com.smartclassroom.ProjectorProto.GetProjectorStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProjectorStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 控制投影仪的开关
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartclassroom.ProjectorProto.ProjectorControlResponse> controlProjector(
        com.smartclassroom.ProjectorProto.ControlProjectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getControlProjectorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PROJECTOR_STATUS = 0;
  private static final int METHODID_CONTROL_PROJECTOR = 1;
  private static final int METHODID_MONITOR_PROJECTOR_STREAM = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProjectorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProjectorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PROJECTOR_STATUS:
          serviceImpl.getProjectorStatus((com.smartclassroom.ProjectorProto.GetProjectorStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.smartclassroom.ProjectorProto.ProjectorStatus>) responseObserver);
          break;
        case METHODID_CONTROL_PROJECTOR:
          serviceImpl.controlProjector((com.smartclassroom.ProjectorProto.ControlProjectorRequest) request,
              (io.grpc.stub.StreamObserver<com.smartclassroom.ProjectorProto.ProjectorControlResponse>) responseObserver);
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
        case METHODID_MONITOR_PROJECTOR_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.monitorProjectorStream(
              (io.grpc.stub.StreamObserver<com.smartclassroom.ProjectorProto.ProjectorStatus>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ProjectorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProjectorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartclassroom.ProjectorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProjectorService");
    }
  }

  private static final class ProjectorServiceFileDescriptorSupplier
      extends ProjectorServiceBaseDescriptorSupplier {
    ProjectorServiceFileDescriptorSupplier() {}
  }

  private static final class ProjectorServiceMethodDescriptorSupplier
      extends ProjectorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProjectorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProjectorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProjectorServiceFileDescriptorSupplier())
              .addMethod(getGetProjectorStatusMethod())
              .addMethod(getControlProjectorMethod())
              .addMethod(getMonitorProjectorStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
