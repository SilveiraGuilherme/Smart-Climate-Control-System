/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartclimatecontrolsystem.humidity;

/**
 *
 * @author guilhermesilveira
 */

import generated.grpc.humidity.HumidityControlGrpc;
import generated.grpc.humidity.HumidityControlOuterClass.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class HumidityClient {

    public static void main(String[] args) throws InterruptedException {
        // Connect to the gRPC server
        ManagedChannel channel = ManagedChannelBuilder
            .forAddress("localhost", 50052)
            .usePlaintext() // no TLS
            .build();

        // Create an async stub (required for streaming)
        HumidityControlGrpc.HumidityControlStub stub = HumidityControlGrpc.newStub(channel);

        // Synchronization tool to wait for server response before exiting
        CountDownLatch latch = new CountDownLatch(1);

        // Define how to handle the server's final response
        StreamObserver<StatusResponse> responseObserver = new StreamObserver<StatusResponse>() {
            @Override
            public void onNext(StatusResponse value) {
                // Called when server sends the final response
                System.out.println("\nServer response: " + value.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                // Server has finished sending its single response
                System.out.println("Streaming completed.");
                latch.countDown(); // release wait
            }
        };

        // Start the stream — this returns the input stream to send messages
        StreamObserver<HumidityRequest> requestObserver = stub.setHumidityLevel(responseObserver);

        // Send multiple humidity values (simulate sensor readings)
        float[] readings = {45.0f, 47.5f, 46.2f, 48.0f, 44.3f};

        for (float humidity : readings) {
            HumidityRequest request = HumidityRequest.newBuilder()
                .setHumidity(humidity)
                .build();

            System.out.println("Sending humidity: " + humidity);
            requestObserver.onNext(request);
            Thread.sleep(1000); // simulate delay between readings
        }

        // Tell the server you're done sending
        requestObserver.onCompleted();

        // Wait for server to finish (max 10 seconds)
        latch.await(10, TimeUnit.SECONDS);

        // Shutdown the channel
        channel.shutdown();
    }
}
