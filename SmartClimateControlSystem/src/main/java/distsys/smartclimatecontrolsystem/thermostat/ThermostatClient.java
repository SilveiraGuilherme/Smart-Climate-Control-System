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
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ThermostatClient {

    public static void main(String[] args) {
        // Connect to the server
        ManagedChannel channel = ManagedChannelBuilder
            .forAddress("localhost", 50051)
            .usePlaintext() // disables TLS for simplicity
            .build();

        // Create a stub (remote control)
        ThermostatGrpc.ThermostatBlockingStub thermostatStub =
            ThermostatGrpc.newBlockingStub(channel);

        // Create request
        TemperatureRequest request = TemperatureRequest.newBuilder()
            .setTemperature(22.5f)
            .build();

        // Send request and receive response
        TemperatureResponse response = thermostatStub.setTemperature(request);
        // Display result after setting the temperature
        System.out.println("New temperature set to " + response.getCurrentTemperature());
        
        // Get current temperature
        TemperatureResponse current = thermostatStub.getCurrentTemperature(Empty.newBuilder().build());
        System.out.println("Current temperature is " + current.getCurrentTemperature());
        
        System.out.println("\nStreaming temperature updates:\n");

        // Call the server streaming method
        thermostatStub.streamTemperatureUpdates(Empty.newBuilder().build())
        .forEachRemaining(update -> {
             System.out.println("Received update: " + update.getCurrentTemperature());
        });

        System.out.println("Stream ended.");
        
        // Call AutoAdjustMode with "true" (enable)
        AutoAdjustRequest enableRequest = AutoAdjustRequest.newBuilder()
            .setEnable(true)
            .build();

        StatusResponse enableResponse = thermostatStub.autoAdjustMode(enableRequest);
        System.out.println("\n" + enableResponse.getMessage());

        // Call AutoAdjustMode with "false" (disable)
        AutoAdjustRequest disableRequest = AutoAdjustRequest.newBuilder()
            .setEnable(false)
            .build();

        StatusResponse disableResponse = thermostatStub.autoAdjustMode(disableRequest);
        System.out.println(disableResponse.getMessage());
        
        // Shutdown channel
        channel.shutdown();
    }
}
