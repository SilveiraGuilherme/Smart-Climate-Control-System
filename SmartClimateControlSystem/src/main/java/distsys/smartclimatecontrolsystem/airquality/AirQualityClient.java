/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartclimatecontrolsystem.airquality;

/**
 *
 * @author guilhermesilveira
 */

import generated.grpc.airquality.AirQualityMonitorGrpc;
import generated.grpc.airquality.AirQualityMonitorOuterClass.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AirQualityClient {

    public static void main(String[] args) throws InterruptedException {
        // Connect to the server
        ManagedChannel channel = ManagedChannelBuilder
            .forAddress("localhost", 50053)
            .usePlaintext()
            .build();

        // Create an async stub (required for bi-directional streaming)
        AirQualityMonitorGrpc.AirQualityMonitorStub stub = AirQualityMonitorGrpc.newStub(channel);

        // Use a latch to wait for the server to finish
        CountDownLatch latch = new CountDownLatch(1);

        // Define how to handle server's streamed responses
        StreamObserver<AirQualityAlert> responseObserver = new StreamObserver<AirQualityAlert>() {
            @Override
            public void onNext(AirQualityAlert value) {
                // Called each time the server sends a response
                System.out.println("Alert received: " + value.getAlertMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Server finished sending alerts.");
                latch.countDown();
            }
        };

        // Start the stream: this is how we send messages to the server
        StreamObserver<AirQualityCheck> requestObserver = stub.monitorAirQuality(responseObserver);

        // Simulate sending a list of locations
        String[] locations = {"Kitchen", "Bedroom", "Living Room", "Garage"};

        for (String location : locations) {
            System.out.println("Sending location: " + location);

            AirQualityCheck request = AirQualityCheck.newBuilder()
                .setLocation(location)
                .build();

            requestObserver.onNext(request);
            Thread.sleep(1500); // simulate delay
        }

        // Tell the server we’re done sending
        requestObserver.onCompleted();

        // Wait for server to finish responding (max 10 seconds)
        latch.await(10, TimeUnit.SECONDS);

        // Shutdown the channel
        channel.shutdown();
    }
}
