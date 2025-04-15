package distsys.smartclimatecontrolsystem.airquality;

/**
 * Implementation of the AirQualityMonitor gRPC service.
 * Handles the single operation defined in AirQualityMonitor.proto:
 *
 * - MonitorAirQuality: establishes a bi-directional stream where the client sends
 *   room names (AirQualityCheck), and the server responds asynchronously with
 *   corresponding air quality alerts (AirQualityAlert).
 *
 * This service simulates a smart air quality monitoring system for a home environment.
 * It allows clients to request monitoring for multiple rooms and receive live alerts
 * based on simulated environmental data.
 *
 * Author: guilhermesilveira
 */

import generated.grpc.airquality.AirQualityMonitorGrpc;
import generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityAlert;
import generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityCheck;
import io.grpc.stub.StreamObserver;

public class AirQualityServiceImpl extends AirQualityMonitorGrpc.AirQualityMonitorImplBase {

    @Override
    public StreamObserver<AirQualityCheck> monitorAirQuality(StreamObserver<AirQualityAlert> responseObserver) {
        return new StreamObserver<AirQualityCheck>() {
            
            //Called whenever the client sends a room location
            @Override
            public void onNext(AirQualityCheck check) {
                String room = check.getLocation().toLowerCase();
                
                switch (room) {
                    case "kitchen":
                        responseObserver.onNext(alert("Kitchen: Air quality is GOOD"));
                        delayedAlert(responseObserver, "Kitchen: Moderate smoke levels detected", 5000);
                        delayedAlert(responseObserver, "Kitchen: High smoke levels detected", 10000);
                        delayedAlert(responseObserver, "Kitchen: Call the fire brigade!", 15000);
                        break;

                    case "living room":
                        responseObserver.onNext(alert("Living Room: Air quality is EXCELLENT"));
                        delayedAlert(responseObserver, "Living Room: Slight CO2 increase detected", 5000);
                        delayedAlert(responseObserver, "Living Room: Consider opening a window", 10000);
                        break;

                    case "bedroom":
                        responseObserver.onNext(alert("Bedroom: Air quality is FAIR"));
                        delayedAlert(responseObserver, "Bedroom: This room needs ventilation", 5000);
                        break;

                    case "bathroom":
                        responseObserver.onNext(alert("Bathroom: High humidity detected"));
                        delayedAlert(responseObserver, "Bathroom: Ventilation recommended", 5000);
                        break;

                    case "garage":
                        responseObserver.onNext(alert("Garage: Slight exhaust fume levels detected"));
                        delayedAlert(responseObserver, "Garage: Air quality dropped – caution advised", 5000);
                        delayedAlert(responseObserver, "Garage: Air pollution levels have arised", 10000);
                        break;

                    default:
                        // Handle unknown room input
                        responseObserver.onNext(alert("Unknown room: " + check.getLocation()));
                        break;
                }
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Air quality stream error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // Signal that the server is done sending messages
                responseObserver.onCompleted();
            }
            
            // Sends a delayed air quality alert back to the client using a background thread
            private void delayedAlert(StreamObserver<AirQualityAlert> responseObserver, String message, int delayMillis) {
                // Start a new background thread to simulate a delayed server response
                new Thread(() -> {
                    try {
                        // Wait for the specified delay (in milliseconds)
                        Thread.sleep(delayMillis);

                        // Create the AirQualityAlert message to send
                        AirQualityAlert alert = AirQualityAlert.newBuilder()
                            .setAlertMessage(message)
                            .build();

                        // Send the alert to the client through the open gRPC stream
                        responseObserver.onNext(alert);

                    } catch (InterruptedException e) {
                        // If something goes wrong during the delay, notify the client
                        responseObserver.onError(e);
                    }
                }).start(); // Start the thread
            }
            
            // Helper method to create an AirQualityAlert
            private AirQualityAlert alert(String message) {
                return AirQualityAlert.newBuilder()
                    .setAlertMessage(message)
                    .build();
            }
        };
    }
} 
