/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartclimatecontrolsystem.thermostat;

/**
 *
 * @author guilhermesilveira
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

            // Keep it running until terminated
            server.awaitTermination();

        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
