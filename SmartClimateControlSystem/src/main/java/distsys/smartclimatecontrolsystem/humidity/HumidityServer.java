/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartclimatecontrolsystem.humidity;

/**
 *
 * @author guilhermesilveira
 */

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class HumidityServer {

    public static void main(String[] args) {
        final int PORT = 50052; // Use a different port than thermostat (50051)

        try {
            // Create the gRPC server and register the service
            Server server = ServerBuilder
                .forPort(PORT)
                .addService(new HumidityServiceImpl())
                .build();

            // Start the server
            server.start();
            System.out.println("Humidity Server started on port " + PORT);

            // Keep it running
            server.awaitTermination();

        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
