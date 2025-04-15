package distsys.smartclimatecontrolsystem.airquality;

/**
 * gRPC Server for the AirQualityMonitor service.
 *
 * This server hosts the AirQualityServiceImpl on port 50053 and supports
 * bi-directional streaming communication between clients and the service.
 * It simulates an air quality monitoring system for a smart home environment.
 *
 * Author: guilhermesilveira
 */


import io.grpc.Server;
import io.grpc.ServerBuilder;

public class AirQualityServer {
    public static void main(String[] args) {
        final int PORT = 50053; // Unique port for Air Quality service

        
        try {
            // Build and start the gRPC server on port 50053
            Server server = ServerBuilder.forPort(PORT)
                .addService(new AirQualityServiceImpl()) // Register the service implementation
                .build()
                .start();

            System.out.println("Air Quality Server started on port " + PORT);
            
            // Shutdown the server on termination
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("Shutting down server...");
                server.shutdown();
            }));
            
            // Keep the server running to accept client requests
            server.awaitTermination();
        } catch (Exception e) {
            System.err.println("Server failed to start: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
