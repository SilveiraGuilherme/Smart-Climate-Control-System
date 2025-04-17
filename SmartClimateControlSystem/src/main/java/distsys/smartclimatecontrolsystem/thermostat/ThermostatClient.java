package distsys.smartclimatecontrolsystem.thermostat;

/**
 * The Thermostat service demonstrates how to call unary and server streaming RPC methods.
 * 
 * @author guilhermesilveira
 */

import distsys.smartclimatecontrolsystem.security.JwtClientInterceptor;
import distsys.smartclimatecontrolsystem.security.JwtUtil;
import generated.grpc.thermostat.ThermostatGrpc;
import generated.grpc.thermostat.ThermostatOuterClass.*;
import io.grpc.Channel;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ThermostatClient {

    public static void main(String[] args) {
        // Connect to the server
        ManagedChannel channel = ManagedChannelBuilder
            .forAddress("localhost", 50051)
            .usePlaintext() // disables TLS for simplicity
            .build();
        
        // Generate token
        String jwtToken = JwtUtil.generateToken("client-user");
        
        // Attach interceptor
        ClientInterceptor jwtInterceptor = new JwtClientInterceptor(jwtToken);
        Channel interceptedChannel = ClientInterceptors.intercept(channel, jwtInterceptor);

        // Create a stub for unary and streaming RPCs
        ThermostatGrpc.ThermostatBlockingStub thermostatStub =
            ThermostatGrpc.newBlockingStub(interceptedChannel);

        // Set the temperature using a unary RPC
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

        // Stream temperature updates from the server (Server Streaming)
        System.out.println("\nStreaming temperature updates:\n");
        thermostatStub.streamTemperatureUpdates(Empty.newBuilder().build())
        .forEachRemaining(update -> {
             System.out.println("Received update: " + update.getCurrentTemperature());
        });

        System.out.println("Stream ended.");
        
        // Call AutoAdjustMode with "true" (enable auto-adjust mode)
        AutoAdjustRequest enableRequest = AutoAdjustRequest.newBuilder()
            .setEnable(true)
            .build();

        StatusResponse enableResponse = thermostatStub.autoAdjustMode(enableRequest);
        System.out.println("\n" + enableResponse.getMessage());

        // Call AutoAdjustMode with "false" (disable auto-adjust mode)
        AutoAdjustRequest disableRequest = AutoAdjustRequest.newBuilder()
            .setEnable(false)
            .build();

        StatusResponse disableResponse = thermostatStub.autoAdjustMode(disableRequest);
        System.out.println(disableResponse.getMessage());
        
        // Shutdown the channel
        channel.shutdown();
    }
}
