package generated.grpc.airquality;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: AirQualityMonitor.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AirQualityMonitorGrpc {

  private AirQualityMonitorGrpc() {}

  public static final String SERVICE_NAME = "airqualitymonitor.AirQualityMonitor";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityCheck,
      generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityAlert> getMonitorAirQualityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorAirQuality",
      requestType = generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityCheck.class,
      responseType = generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityAlert.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityCheck,
      generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityAlert> getMonitorAirQualityMethod() {
    io.grpc.MethodDescriptor<generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityCheck, generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityAlert> getMonitorAirQualityMethod;
    if ((getMonitorAirQualityMethod = AirQualityMonitorGrpc.getMonitorAirQualityMethod) == null) {
      synchronized (AirQualityMonitorGrpc.class) {
        if ((getMonitorAirQualityMethod = AirQualityMonitorGrpc.getMonitorAirQualityMethod) == null) {
          AirQualityMonitorGrpc.getMonitorAirQualityMethod = getMonitorAirQualityMethod =
              io.grpc.MethodDescriptor.<generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityCheck, generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityAlert>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorAirQuality"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityCheck.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityAlert.getDefaultInstance()))
              .setSchemaDescriptor(new AirQualityMonitorMethodDescriptorSupplier("MonitorAirQuality"))
              .build();
        }
      }
    }
    return getMonitorAirQualityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AirQualityMonitorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AirQualityMonitorStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AirQualityMonitorStub>() {
        @java.lang.Override
        public AirQualityMonitorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AirQualityMonitorStub(channel, callOptions);
        }
      };
    return AirQualityMonitorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AirQualityMonitorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AirQualityMonitorBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AirQualityMonitorBlockingStub>() {
        @java.lang.Override
        public AirQualityMonitorBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AirQualityMonitorBlockingStub(channel, callOptions);
        }
      };
    return AirQualityMonitorBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AirQualityMonitorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AirQualityMonitorFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AirQualityMonitorFutureStub>() {
        @java.lang.Override
        public AirQualityMonitorFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AirQualityMonitorFutureStub(channel, callOptions);
        }
      };
    return AirQualityMonitorFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AirQualityMonitorImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Bi-directional Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityCheck> monitorAirQuality(
        io.grpc.stub.StreamObserver<generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityAlert> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getMonitorAirQualityMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMonitorAirQualityMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityCheck,
                generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityAlert>(
                  this, METHODID_MONITOR_AIR_QUALITY)))
          .build();
    }
  }

  /**
   */
  public static final class AirQualityMonitorStub extends io.grpc.stub.AbstractAsyncStub<AirQualityMonitorStub> {
    private AirQualityMonitorStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirQualityMonitorStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AirQualityMonitorStub(channel, callOptions);
    }

    /**
     * <pre>
     * Bi-directional Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityCheck> monitorAirQuality(
        io.grpc.stub.StreamObserver<generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityAlert> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getMonitorAirQualityMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class AirQualityMonitorBlockingStub extends io.grpc.stub.AbstractBlockingStub<AirQualityMonitorBlockingStub> {
    private AirQualityMonitorBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirQualityMonitorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AirQualityMonitorBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class AirQualityMonitorFutureStub extends io.grpc.stub.AbstractFutureStub<AirQualityMonitorFutureStub> {
    private AirQualityMonitorFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirQualityMonitorFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AirQualityMonitorFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_MONITOR_AIR_QUALITY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AirQualityMonitorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AirQualityMonitorImplBase serviceImpl, int methodId) {
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
        case METHODID_MONITOR_AIR_QUALITY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.monitorAirQuality(
              (io.grpc.stub.StreamObserver<generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityAlert>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AirQualityMonitorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AirQualityMonitorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.airquality.AirQualityMonitorOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AirQualityMonitor");
    }
  }

  private static final class AirQualityMonitorFileDescriptorSupplier
      extends AirQualityMonitorBaseDescriptorSupplier {
    AirQualityMonitorFileDescriptorSupplier() {}
  }

  private static final class AirQualityMonitorMethodDescriptorSupplier
      extends AirQualityMonitorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AirQualityMonitorMethodDescriptorSupplier(String methodName) {
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
      synchronized (AirQualityMonitorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AirQualityMonitorFileDescriptorSupplier())
              .addMethod(getMonitorAirQualityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
