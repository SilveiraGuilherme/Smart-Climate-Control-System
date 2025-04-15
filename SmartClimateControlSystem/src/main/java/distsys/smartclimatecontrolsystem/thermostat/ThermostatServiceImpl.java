package distsys.smartclimatecontrolsystem.thermostat;

/**
 * Implementation of the Thermostat gRPC service.
 * Handles operations defined in Thermostat.proto:
 *
 * - SetTemperature: sets a new temperature value (Unary)
 * - GetCurrentTemperature: retrieves the current temperature (Unary)
 * - StreamTemperatureUpdates: sends a series of simulated temperature readings (Server Streaming)
 * - AutoAdjustMode: enables or disables automatic temperature adjustment (Unary)
 *
 * This service simulates the behavior of a smart thermostat in a smart home environment,
 * allowing clients to configure and monitor temperature settings and modes.
 *
 * Author: guilhermesilveira
 */

import generated.grpc.thermostat.ThermostatGrpc;
import generated.grpc.thermostat.ThermostatOuterClass.*;
import io.grpc.stub.StreamObserver;

public class ThermostatServiceImpl extends ThermostatGrpc.ThermostatImplBase {

    private float currentTemperature = 20.0f; // Default value
    private boolean autoAdjustEnabled = false; // Auto-adjust toogle

    @Override
    public void setTemperature(TemperatureRequest request, StreamObserver<TemperatureResponse> responseObserver) {
        
        // Extract the temperature from the request
        float newTemp = request.getTemperature();

        // Store it (simulate setting it)
        currentTemperature = newTemp;

        // Build the response
        TemperatureResponse response = TemperatureResponse.newBuilder()
            .setCurrentTemperature(currentTemperature)
            .build();

        // Send the response back to the client
        responseObserver.onNext(response);

        // Signal that the response is complete
        responseObserver.onCompleted();
    }
    
    @Override
    public void getCurrentTemperature(Empty request, StreamObserver<TemperatureResponse> responseObserver) {
        // Build the response with the current value
        TemperatureResponse response = TemperatureResponse.newBuilder()
            .setCurrentTemperature(currentTemperature)
            .build();

        // Send it back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void streamTemperatureUpdates(Empty request, StreamObserver<TemperatureResponse> responseObserver) {
        // Simulateting 10 updates (every 1 second)
        try {
            for (int i = 0; i < 10; i++) {
                // Simulate a temperature update
                TemperatureResponse response = TemperatureResponse.newBuilder()
                    .setCurrentTemperature(currentTemperature + i * 0.1f) // increasing temp slightly
                    .build();

                responseObserver.onNext(response); // Send update

                Thread.sleep(1000); // 1-second pause between updates
            }
        } catch (InterruptedException e) {
            responseObserver.onError(e); // Notify the client of error
            return;
        }

        responseObserver.onCompleted(); // End the stream
    }

    @Override
    public void autoAdjustMode(AutoAdjustRequest request, StreamObserver<StatusResponse> responseObserver) {
        // Toggle auto-adjust mode
        autoAdjustEnabled = request.getEnable();

        // Create a confirmation message
        String message = autoAdjustEnabled
                ? "Auto-adjust mode enabled"
                : "Auto-adjust mode disabled";

        // Build the response
        StatusResponse response = StatusResponse.newBuilder()
            .setMessage(message)
            .build();

        // Send response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
