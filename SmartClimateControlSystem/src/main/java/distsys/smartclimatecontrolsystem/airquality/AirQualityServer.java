package distsys.smartclimatecontrolsystem.airquality;

/**
 * 
 * @author guilhermesilveira
 */

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class AirQualityServer {
    public static void main(String[] args) {
        final int PORT = 50053; // Use a different port than thermostat (50051)

        
        try {
            // Build and start the gRPC server on port 50053
            Server server = ServerBuilder.forPort(PORT)
                .addService(new AirQualityServiceImpl()) // Register the service implementation
                .build()
                .start();

            System.out.println("Air Quality Server started on port " + PORT);
            
            // Shutdown hook to cleanly shut down the server on termination
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
