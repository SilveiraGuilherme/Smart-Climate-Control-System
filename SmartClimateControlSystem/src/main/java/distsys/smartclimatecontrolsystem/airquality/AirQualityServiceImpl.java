/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartclimatecontrolsystem.airquality;

/**
 *
 * @author guilhermesilveira
 */

import generated.grpc.airquality.AirQualityMonitorGrpc;
import generated.grpc.airquality.AirQualityMonitorOuterClass.*;
import io.grpc.stub.StreamObserver;

/**
 * Implements the AirQualityMonitor gRPC service.
 * This method handles a bi-directional streaming call where:
 * - Client sends a stream of AirQualityCheck messages (locations).
 * - Server replies with a stream of AirQualityAlert messages.
 */
public class AirQualityServiceImpl extends AirQualityMonitorGrpc.AirQualityMonitorImplBase {

    @Override
    public StreamObserver<AirQualityCheck> monitorAirQuality(StreamObserver<AirQualityAlert> responseObserver) {

        // Return an observer to receive messages from the client
        return new StreamObserver<AirQualityCheck>() {

            /**
             * Called every time the client sends a new message (location).
             */
            @Override
            public void onNext(AirQualityCheck request) {
                String location = request.getLocation();
                String message;

                // Simulated air quality logic for different locations
                switch (location.toLowerCase()) {
                    case "kitchen":
                        message = "Smoke detected in Kitchen!";
                        break;
                    case "living room":
                        message = "Air quality normal in Living Room.";
                        break;
                    case "bedroom":
                        message = "CO2 levels high in Bedroom!";
                        break;
                    case "bathroom":
                        message = "No unusual activity in Bathroom.";
                        break;
                    default:
                        message = "No data for location: " + location;
                }

                // Send alert back to the client
                AirQualityAlert alert = AirQualityAlert.newBuilder()
                    .setAlertMessage(message)
                    .build();

                responseObserver.onNext(alert); // stream the response
                System.out.println("Checked " + location + " → Sent: " + message);
            }

            /**
             * Called if the client sends an error or disconnects unexpectedly.
             */
            @Override
            public void onError(Throwable t) {
                System.err.println("Error in air quality stream: " + t.getMessage());
            }

            /**
             * Called once the client has finished sending all its messages.
             */
            @Override
            public void onCompleted() {
                System.out.println("Client finished sending locations.");
                responseObserver.onCompleted();
            }
        };
    }
}