/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        ManagedChannel channel = ManagedChannelBuilder
            .forAddress("localhost", 50053)
            .usePlaintext()
            .build();

        AirQualityMonitorGrpc.AirQualityMonitorStub stub = AirQualityMonitorGrpc.newStub(channel);
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<AirQualityAlert> responseObserver = new StreamObserver<AirQualityAlert>() {
            @Override
            public void onNext(AirQualityAlert value) {
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

        StreamObserver<AirQualityCheck> requestObserver = stub.monitorAirQuality(responseObserver);

        String[] locations = {"Kitchen", "Bedroom", "Living Room", "Garage"};

        for (String location : locations) {
            System.out.println("Sending location: " + location);

            AirQualityCheck request = AirQualityCheck.newBuilder()
                .setLocation(location)
                .build();

            requestObserver.onNext(request);
            Thread.sleep(1000); // small delay between sends
        }

        // ✅ Wait for a few seconds BEFORE closing the stream
        Thread.sleep(8000); // enough to receive delayed alerts

        // Now we signal the server we're done
        requestObserver.onCompleted();

        // Wait for server's onCompleted (extra safety)
        latch.await(5, TimeUnit.SECONDS);

        channel.shutdown();
        System.out.println("Client shut down.");
    }
}