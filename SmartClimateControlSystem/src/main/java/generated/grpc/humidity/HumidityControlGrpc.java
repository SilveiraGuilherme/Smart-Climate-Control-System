package generated.grpc.humidity;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: HumidityControl.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HumidityControlGrpc {

  private HumidityControlGrpc() {}

  public static final String SERVICE_NAME = "humiditycontrol.HumidityControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.humidity.HumidityControlOuterClass.HumidityRequest,
      generated.grpc.humidity.HumidityControlOuterClass.StatusResponse> getSetHumidityLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetHumidityLevel",
      requestType = generated.grpc.humidity.HumidityControlOuterClass.HumidityRequest.class,
      responseType = generated.grpc.humidity.HumidityControlOuterClass.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.humidity.HumidityControlOuterClass.HumidityRequest,
      generated.grpc.humidity.HumidityControlOuterClass.StatusResponse> getSetHumidityLevelMethod() {
    io.grpc.MethodDescriptor<generated.grpc.humidity.HumidityControlOuterClass.HumidityRequest, generated.grpc.humidity.HumidityControlOuterClass.StatusResponse> getSetHumidityLevelMethod;
    if ((getSetHumidityLevelMethod = HumidityControlGrpc.getSetHumidityLevelMethod) == null) {
      synchronized (HumidityControlGrpc.class) {
        if ((getSetHumidityLevelMethod = HumidityControlGrpc.getSetHumidityLevelMethod) == null) {
          HumidityControlGrpc.getSetHumidityLevelMethod = getSetHumidityLevelMethod =
              io.grpc.MethodDescriptor.<generated.grpc.humidity.HumidityControlOuterClass.HumidityRequest, generated.grpc.humidity.HumidityControlOuterClass.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetHumidityLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.humidity.HumidityControlOuterClass.HumidityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.humidity.HumidityControlOuterClass.StatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HumidityControlMethodDescriptorSupplier("SetHumidityLevel"))
              .build();
        }
      }
    }
    return getSetHumidityLevelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HumidityControlStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HumidityControlStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HumidityControlStub>() {
        @java.lang.Override
        public HumidityControlStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HumidityControlStub(channel, callOptions);
        }
      };
    return HumidityControlStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HumidityControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HumidityControlBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HumidityControlBlockingStub>() {
        @java.lang.Override
        public HumidityControlBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HumidityControlBlockingStub(channel, callOptions);
        }
      };
    return HumidityControlBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HumidityControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HumidityControlFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HumidityControlFutureStub>() {
        @java.lang.Override
        public HumidityControlFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HumidityControlFutureStub(channel, callOptions);
        }
      };
    return HumidityControlFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class HumidityControlImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Client Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.humidity.HumidityControlOuterClass.HumidityRequest> setHumidityLevel(
        io.grpc.stub.StreamObserver<generated.grpc.humidity.HumidityControlOuterClass.StatusResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSetHumidityLevelMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetHumidityLevelMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                generated.grpc.humidity.HumidityControlOuterClass.HumidityRequest,
                generated.grpc.humidity.HumidityControlOuterClass.StatusResponse>(
                  this, METHODID_SET_HUMIDITY_LEVEL)))
          .build();
    }
  }

  /**
   */
  public static final class HumidityControlStub extends io.grpc.stub.AbstractAsyncStub<HumidityControlStub> {
    private HumidityControlStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HumidityControlStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HumidityControlStub(channel, callOptions);
    }

    /**
     * <pre>
     * Client Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.humidity.HumidityControlOuterClass.HumidityRequest> setHumidityLevel(
        io.grpc.stub.StreamObserver<generated.grpc.humidity.HumidityControlOuterClass.StatusResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSetHumidityLevelMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class HumidityControlBlockingStub extends io.grpc.stub.AbstractBlockingStub<HumidityControlBlockingStub> {
    private HumidityControlBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HumidityControlBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HumidityControlBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class HumidityControlFutureStub extends io.grpc.stub.AbstractFutureStub<HumidityControlFutureStub> {
    private HumidityControlFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HumidityControlFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HumidityControlFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SET_HUMIDITY_LEVEL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HumidityControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HumidityControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_HUMIDITY_LEVEL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.setHumidityLevel(
              (io.grpc.stub.StreamObserver<generated.grpc.humidity.HumidityControlOuterClass.StatusResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HumidityControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HumidityControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.humidity.HumidityControlOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HumidityControl");
    }
  }

  private static final class HumidityControlFileDescriptorSupplier
      extends HumidityControlBaseDescriptorSupplier {
    HumidityControlFileDescriptorSupplier() {}
  }

  private static final class HumidityControlMethodDescriptorSupplier
      extends HumidityControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HumidityControlMethodDescriptorSupplier(String methodName) {
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
      synchronized (HumidityControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HumidityControlFileDescriptorSupplier())
              .addMethod(getSetHumidityLevelMethod())
              .build();
        }
      }
    }
    return result;
  }
}
