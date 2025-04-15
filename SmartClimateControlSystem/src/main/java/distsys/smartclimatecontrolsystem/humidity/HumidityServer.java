package distsys.smartclimatecontrolsystem.humidity;

/**
 * gRPC Server for the HumidityControl service.
 *
 * This server hosts the HumidityServiceImpl on port 50052 and handles
 * client-streaming RPCs for receiving and processing humidity data.
 *
 * Author: guilhermesilveira
 */

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class HumidityServer {
    public static void main(String[] args) {
        final int PORT = 50052; // Use a different port than thermostat (50051)

        try {
            // Create the gRPC server and register the service
            Server server = ServerBuilder.forPort(PORT)
                .addService(new HumidityServiceImpl())
                .build()
                .start(); // Start the server
            
            System.out.println("Humidity Server started on port " + PORT);
            
            // Shutdown the server on termination
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("Shutting down Humidity Server...");
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
