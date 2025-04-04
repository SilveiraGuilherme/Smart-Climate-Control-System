package distsys.smartclimatecontrolsystem.thermostat;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: Thermostat.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ThermostatGrpc {

  private ThermostatGrpc() {}

  public static final String SERVICE_NAME = "thermostat.Thermostat";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureRequest,
      distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> getSetTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetTemperature",
      requestType = distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureRequest.class,
      responseType = distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureRequest,
      distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> getSetTemperatureMethod() {
    io.grpc.MethodDescriptor<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureRequest, distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> getSetTemperatureMethod;
    if ((getSetTemperatureMethod = ThermostatGrpc.getSetTemperatureMethod) == null) {
      synchronized (ThermostatGrpc.class) {
        if ((getSetTemperatureMethod = ThermostatGrpc.getSetTemperatureMethod) == null) {
          ThermostatGrpc.getSetTemperatureMethod = getSetTemperatureMethod =
              io.grpc.MethodDescriptor.<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureRequest, distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ThermostatMethodDescriptorSupplier("SetTemperature"))
              .build();
        }
      }
    }
    return getSetTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty,
      distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> getGetCurrentTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCurrentTemperature",
      requestType = distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty.class,
      responseType = distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty,
      distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> getGetCurrentTemperatureMethod() {
    io.grpc.MethodDescriptor<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty, distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> getGetCurrentTemperatureMethod;
    if ((getGetCurrentTemperatureMethod = ThermostatGrpc.getGetCurrentTemperatureMethod) == null) {
      synchronized (ThermostatGrpc.class) {
        if ((getGetCurrentTemperatureMethod = ThermostatGrpc.getGetCurrentTemperatureMethod) == null) {
          ThermostatGrpc.getGetCurrentTemperatureMethod = getGetCurrentTemperatureMethod =
              io.grpc.MethodDescriptor.<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty, distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCurrentTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ThermostatMethodDescriptorSupplier("GetCurrentTemperature"))
              .build();
        }
      }
    }
    return getGetCurrentTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty,
      distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> getStreamTemperatureUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamTemperatureUpdates",
      requestType = distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty.class,
      responseType = distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty,
      distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> getStreamTemperatureUpdatesMethod() {
    io.grpc.MethodDescriptor<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty, distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> getStreamTemperatureUpdatesMethod;
    if ((getStreamTemperatureUpdatesMethod = ThermostatGrpc.getStreamTemperatureUpdatesMethod) == null) {
      synchronized (ThermostatGrpc.class) {
        if ((getStreamTemperatureUpdatesMethod = ThermostatGrpc.getStreamTemperatureUpdatesMethod) == null) {
          ThermostatGrpc.getStreamTemperatureUpdatesMethod = getStreamTemperatureUpdatesMethod =
              io.grpc.MethodDescriptor.<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty, distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamTemperatureUpdates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ThermostatMethodDescriptorSupplier("StreamTemperatureUpdates"))
              .build();
        }
      }
    }
    return getStreamTemperatureUpdatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.AutoAdjustRequest,
      distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.StatusResponse> getAutoAdjustModeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AutoAdjustMode",
      requestType = distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.AutoAdjustRequest.class,
      responseType = distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.AutoAdjustRequest,
      distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.StatusResponse> getAutoAdjustModeMethod() {
    io.grpc.MethodDescriptor<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.AutoAdjustRequest, distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.StatusResponse> getAutoAdjustModeMethod;
    if ((getAutoAdjustModeMethod = ThermostatGrpc.getAutoAdjustModeMethod) == null) {
      synchronized (ThermostatGrpc.class) {
        if ((getAutoAdjustModeMethod = ThermostatGrpc.getAutoAdjustModeMethod) == null) {
          ThermostatGrpc.getAutoAdjustModeMethod = getAutoAdjustModeMethod =
              io.grpc.MethodDescriptor.<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.AutoAdjustRequest, distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AutoAdjustMode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.AutoAdjustRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.StatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ThermostatMethodDescriptorSupplier("AutoAdjustMode"))
              .build();
        }
      }
    }
    return getAutoAdjustModeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ThermostatStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ThermostatStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ThermostatStub>() {
        @java.lang.Override
        public ThermostatStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ThermostatStub(channel, callOptions);
        }
      };
    return ThermostatStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ThermostatBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ThermostatBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ThermostatBlockingStub>() {
        @java.lang.Override
        public ThermostatBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ThermostatBlockingStub(channel, callOptions);
        }
      };
    return ThermostatBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ThermostatFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ThermostatFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ThermostatFutureStub>() {
        @java.lang.Override
        public ThermostatFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ThermostatFutureStub(channel, callOptions);
        }
      };
    return ThermostatFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ThermostatImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void setTemperature(distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureRequest request,
        io.grpc.stub.StreamObserver<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetTemperatureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void getCurrentTemperature(distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty request,
        io.grpc.stub.StreamObserver<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCurrentTemperatureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public void streamTemperatureUpdates(distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty request,
        io.grpc.stub.StreamObserver<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamTemperatureUpdatesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void autoAdjustMode(distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.AutoAdjustRequest request,
        io.grpc.stub.StreamObserver<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.StatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAutoAdjustModeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetTemperatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureRequest,
                distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse>(
                  this, METHODID_SET_TEMPERATURE)))
          .addMethod(
            getGetCurrentTemperatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty,
                distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse>(
                  this, METHODID_GET_CURRENT_TEMPERATURE)))
          .addMethod(
            getStreamTemperatureUpdatesMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty,
                distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse>(
                  this, METHODID_STREAM_TEMPERATURE_UPDATES)))
          .addMethod(
            getAutoAdjustModeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.AutoAdjustRequest,
                distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.StatusResponse>(
                  this, METHODID_AUTO_ADJUST_MODE)))
          .build();
    }
  }

  /**
   */
  public static final class ThermostatStub extends io.grpc.stub.AbstractAsyncStub<ThermostatStub> {
    private ThermostatStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThermostatStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ThermostatStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void setTemperature(distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureRequest request,
        io.grpc.stub.StreamObserver<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetTemperatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void getCurrentTemperature(distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty request,
        io.grpc.stub.StreamObserver<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCurrentTemperatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public void streamTemperatureUpdates(distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty request,
        io.grpc.stub.StreamObserver<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamTemperatureUpdatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void autoAdjustMode(distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.AutoAdjustRequest request,
        io.grpc.stub.StreamObserver<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.StatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAutoAdjustModeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ThermostatBlockingStub extends io.grpc.stub.AbstractBlockingStub<ThermostatBlockingStub> {
    private ThermostatBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThermostatBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ThermostatBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse setTemperature(distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetTemperatureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse getCurrentTemperature(distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCurrentTemperatureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public java.util.Iterator<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> streamTemperatureUpdates(
        distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamTemperatureUpdatesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.StatusResponse autoAdjustMode(distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.AutoAdjustRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAutoAdjustModeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ThermostatFutureStub extends io.grpc.stub.AbstractFutureStub<ThermostatFutureStub> {
    private ThermostatFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThermostatFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ThermostatFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> setTemperature(
        distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetTemperatureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse> getCurrentTemperature(
        distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCurrentTemperatureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.StatusResponse> autoAdjustMode(
        distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.AutoAdjustRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAutoAdjustModeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_TEMPERATURE = 0;
  private static final int METHODID_GET_CURRENT_TEMPERATURE = 1;
  private static final int METHODID_STREAM_TEMPERATURE_UPDATES = 2;
  private static final int METHODID_AUTO_ADJUST_MODE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ThermostatImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ThermostatImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_TEMPERATURE:
          serviceImpl.setTemperature((distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureRequest) request,
              (io.grpc.stub.StreamObserver<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse>) responseObserver);
          break;
        case METHODID_GET_CURRENT_TEMPERATURE:
          serviceImpl.getCurrentTemperature((distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty) request,
              (io.grpc.stub.StreamObserver<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse>) responseObserver);
          break;
        case METHODID_STREAM_TEMPERATURE_UPDATES:
          serviceImpl.streamTemperatureUpdates((distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.Empty) request,
              (io.grpc.stub.StreamObserver<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.TemperatureResponse>) responseObserver);
          break;
        case METHODID_AUTO_ADJUST_MODE:
          serviceImpl.autoAdjustMode((distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.AutoAdjustRequest) request,
              (io.grpc.stub.StreamObserver<distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.StatusResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ThermostatBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ThermostatBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return distsys.smartclimatecontrolsystem.thermostat.ThermostatOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Thermostat");
    }
  }

  private static final class ThermostatFileDescriptorSupplier
      extends ThermostatBaseDescriptorSupplier {
    ThermostatFileDescriptorSupplier() {}
  }

  private static final class ThermostatMethodDescriptorSupplier
      extends ThermostatBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ThermostatMethodDescriptorSupplier(String methodName) {
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
      synchronized (ThermostatGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ThermostatFileDescriptorSupplier())
              .addMethod(getSetTemperatureMethod())
              .addMethod(getGetCurrentTemperatureMethod())
              .addMethod(getStreamTemperatureUpdatesMethod())
              .addMethod(getAutoAdjustModeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
