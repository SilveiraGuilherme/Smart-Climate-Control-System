/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartclimatecontrolsystem.thermostat;

/**
 *
 * @author guilhermesilveira
 */
import generated.grpc.thermostat.ThermostatGrpc;
import generated.grpc.thermostat.ThermostatOuterClass.*;
import io.grpc.stub.StreamObserver;

public class ThermostatServiceImpl extends ThermostatGrpc.ThermostatImplBase {

    private float currentTemperature = 20.0f; // default value
    private boolean autoAdjustEnabled = false; // default state

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
        // Read the flag from the request
        autoAdjustEnabled = request.getEnable();

        // Create a confirmation message
        String message = autoAdjustEnabled ? "Auto-adjust mode enabled" : "Auto-adjust mode disabled";

        // Build the response
        StatusResponse response = StatusResponse.newBuilder()
            .setMessage(message)
            .build();

        // Send response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
