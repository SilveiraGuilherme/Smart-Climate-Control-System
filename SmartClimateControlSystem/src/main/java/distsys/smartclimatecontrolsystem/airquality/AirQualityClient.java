package distsys.smartclimatecontrolsystem.airquality;

import generated.grpc.airquality.AirQualityMonitorGrpc;
import generated.grpc.airquality.AirQualityMonitorOuterClass.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AirQualityClient {

    public static void main(String[] args) throws InterruptedException {
        // Connect to the gRPC server on the correct port
        ManagedChannel channel = ManagedChannelBuilder
            .forAddress("localhost", 50053)
            .usePlaintext()
            .build();

        // Create an asynchronous stub for bi-directional communication
        AirQualityMonitorGrpc.AirQualityMonitorStub stub = AirQualityMonitorGrpc.newStub(channel);
        
        // Use CountDownLatch to block the main thread until all server responses are received
        CountDownLatch latch = new CountDownLatch(1);

        // Define how to handle server-streamed responses
        StreamObserver<AirQualityAlert> responseObserver = new StreamObserver<AirQualityAlert>() {
            @Override
            public void onNext(AirQualityAlert value) {
                // Server pushed a new alert message
                System.out.println("Alert received: " + value.getAlertMessage());
            }

            @Override
            public void onError(Throwable t) {
                // Handle errors in the stream
                System.err.println("Error: " + t.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                // Server signaled the end of the stream
                System.out.println("Server finished sending alerts.");
                latch.countDown();
            }
        };

        // Open the stream for sending requests to the server
        StreamObserver<AirQualityCheck> requestObserver = stub.monitorAirQuality(responseObserver);

        // Simulate sending room names to the server
        String[] locations = {"Kitchen", "Bedroom", "Living Room", "Garage"};

        for (String location : locations) {
            System.out.println("Sending location: " + location);

            AirQualityCheck request = AirQualityCheck.newBuilder()
                .setLocation(location)
                .build();

            requestObserver.onNext(request);
            Thread.sleep(1000); // small delay between sends
        }

        // Wait for a few seconds before closing the stream
        Thread.sleep(8000); // enough to receive delayed alerts
        requestObserver.onCompleted();

        // Block until server sends final onCompleted() or timeout occurs
        latch.await(5, TimeUnit.SECONDS);

        // Shut down the channel
        channel.shutdown();
        System.out.println("Client shut down.");
    }
}