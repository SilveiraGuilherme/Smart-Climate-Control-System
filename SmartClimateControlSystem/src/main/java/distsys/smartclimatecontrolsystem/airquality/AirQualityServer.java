/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartclimatecontrolsystem.airquality;

/**
 *
 * @author guilhermesilveira
 */

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class AirQualityServer {

    public static void main(String[] args) {
        final int PORT = 50053;

        try {
            Server server = ServerBuilder
                .forPort(PORT)
                .addService(new AirQualityServiceImpl())
                .build();

            server.start();
            System.out.println("Air Quality Server started on port " + PORT);
            server.awaitTermination();

        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
