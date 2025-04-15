package distsys.smartclimatecontrolsystem.thermostat;

/**
 * gRPC Server for the Thermostat service.
 * 
 * This server hosts the ThermostatServiceImpl, listening on port 50051.
 * It handles RPCs such as setting temperature, retrieving the current temperature,
 * enabling/disabling auto-adjust mode, and streaming temperature updates.
 *
 * Author: guilhermesilveira
 */

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ThermostatServer {
    
    public static void main(String[] args) {
        final int PORT = 50051;
        
        try {
            // Build the server and add the service
            Server server = ServerBuilder
                .forPort(PORT)
                .addService(new ThermostatServiceImpl())
                .build();

            // Start the server
            server.start();
            System.out.println("Thermostat Server started on port " + PORT);

            // Shutdown the server on termination
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("Shutting down Thermostat server...");
                server.shutdown();
            }));
            
            // Keep it running until termination
            server.awaitTermination();

        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
