package com.smartclassroom;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 投影仪服务接口定义
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: projector.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProjectorServiceGrpc {

  private ProjectorServiceGrpc() {}

  public static final String SERVICE_NAME = "ProjectorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ProjectorProto.GetProjectorStatusRequest,
      ProjectorProto.ProjectorStatus> getGetProjectorStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProjectorStatus",
      requestType = ProjectorProto.GetProjectorStatusRequest.class,
      responseType = ProjectorProto.ProjectorStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ProjectorProto.GetProjectorStatusRequest,
      ProjectorProto.ProjectorStatus> getGetProjectorStatusMethod() {
    io.grpc.MethodDescriptor<ProjectorProto.GetProjectorStatusRequest, ProjectorProto.ProjectorStatus> getGetProjectorStatusMethod;
    if ((getGetProjectorStatusMethod = ProjectorServiceGrpc.getGetProjectorStatusMethod) == null) {
      synchronized (ProjectorServiceGrpc.class) {
        if ((getGetProjectorStatusMethod = ProjectorServiceGrpc.getGetProjectorStatusMethod) == null) {
          ProjectorServiceGrpc.getGetProjectorStatusMethod = getGetProjectorStatusMethod =
              io.grpc.MethodDescriptor.<ProjectorProto.GetProjectorStatusRequest, ProjectorProto.ProjectorStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProjectorStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ProjectorProto.GetProjectorStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ProjectorProto.ProjectorStatus.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectorServiceMethodDescriptorSupplier("GetProjectorStatus"))
              .build();
        }
      }
    }
    return getGetProjectorStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ProjectorProto.ControlProjectorRequest,
      ProjectorProto.ProjectorControlResponse> getControlProjectorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlProjectors",
      requestType = ProjectorProto.ControlProjectorRequest.class,
      responseType = ProjectorProto.ProjectorControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ProjectorProto.ControlProjectorRequest,
      ProjectorProto.ProjectorControlResponse> getControlProjectorsMethod() {
    io.grpc.MethodDescriptor<ProjectorProto.ControlProjectorRequest, ProjectorProto.ProjectorControlResponse> getControlProjectorsMethod;
    if ((getControlProjectorsMethod = ProjectorServiceGrpc.getControlProjectorsMethod) == null) {
      synchronized (ProjectorServiceGrpc.class) {
        if ((getControlProjectorsMethod = ProjectorServiceGrpc.getControlProjectorsMethod) == null) {
          ProjectorServiceGrpc.getControlProjectorsMethod = getControlProjectorsMethod =
              io.grpc.MethodDescriptor.<ProjectorProto.ControlProjectorRequest, ProjectorProto.ProjectorControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlProjectors"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ProjectorProto.ControlProjectorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ProjectorProto.ProjectorControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectorServiceMethodDescriptorSupplier("ControlProjectors"))
              .build();
        }
      }
    }
    return getControlProjectorsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProjectorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectorServiceStub>() {
        @Override
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
        @Override
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
        @Override
        public ProjectorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectorServiceFutureStub(channel, callOptions);
        }
      };
    return ProjectorServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 投影仪服务接口定义
   * </pre>
   */
  public static abstract class ProjectorServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 一元 RPC：获取投影仪状态
     * </pre>
     */
    public void getProjectorStatus(ProjectorProto.GetProjectorStatusRequest request,
                                   io.grpc.stub.StreamObserver<ProjectorProto.ProjectorStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProjectorStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * 客户端流式 RPC：批量控制投影仪
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ProjectorProto.ControlProjectorRequest> controlProjectors(
        io.grpc.stub.StreamObserver<ProjectorProto.ProjectorControlResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getControlProjectorsMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetProjectorStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ProjectorProto.GetProjectorStatusRequest,
                ProjectorProto.ProjectorStatus>(
                  this, METHODID_GET_PROJECTOR_STATUS)))
          .addMethod(
            getControlProjectorsMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                ProjectorProto.ControlProjectorRequest,
                ProjectorProto.ProjectorControlResponse>(
                  this, METHODID_CONTROL_PROJECTORS)))
          .build();
    }
  }

  /**
   * <pre>
   * 投影仪服务接口定义
   * </pre>
   */
  public static final class ProjectorServiceStub extends io.grpc.stub.AbstractAsyncStub<ProjectorServiceStub> {
    private ProjectorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ProjectorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectorServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一元 RPC：获取投影仪状态
     * </pre>
     */
    public void getProjectorStatus(ProjectorProto.GetProjectorStatusRequest request,
                                   io.grpc.stub.StreamObserver<ProjectorProto.ProjectorStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProjectorStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 客户端流式 RPC：批量控制投影仪
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ProjectorProto.ControlProjectorRequest> controlProjectors(
        io.grpc.stub.StreamObserver<ProjectorProto.ProjectorControlResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getControlProjectorsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * 投影仪服务接口定义
   * </pre>
   */
  public static final class ProjectorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProjectorServiceBlockingStub> {
    private ProjectorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ProjectorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectorServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一元 RPC：获取投影仪状态
     * </pre>
     */
    public ProjectorProto.ProjectorStatus getProjectorStatus(ProjectorProto.GetProjectorStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProjectorStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 投影仪服务接口定义
   * </pre>
   */
  public static final class ProjectorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ProjectorServiceFutureStub> {
    private ProjectorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ProjectorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectorServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一元 RPC：获取投影仪状态
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ProjectorProto.ProjectorStatus> getProjectorStatus(
        ProjectorProto.GetProjectorStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProjectorStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PROJECTOR_STATUS = 0;
  private static final int METHODID_CONTROL_PROJECTORS = 1;

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

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PROJECTOR_STATUS:
          serviceImpl.getProjectorStatus((ProjectorProto.GetProjectorStatusRequest) request,
              (io.grpc.stub.StreamObserver<ProjectorProto.ProjectorStatus>) responseObserver);
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
        case METHODID_CONTROL_PROJECTORS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.controlProjectors(
              (io.grpc.stub.StreamObserver<ProjectorProto.ProjectorControlResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ProjectorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProjectorServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ProjectorProto.getDescriptor();
    }

    @Override
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

    @Override
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
              .addMethod(getControlProjectorsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
