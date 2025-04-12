package distsys.smartclimatecontrolsystem.airquality;

/**
 * AirQualityServiceImpl: Implements the bi-directional gRPC communication for air quality monitoring.
 * Clients send room names and receive immediate and delayed air quality alerts.
 * 
 * @author guilhermesilveira
 */

import generated.grpc.airquality.AirQualityMonitorGrpc;
import generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityAlert;
import generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityCheck;
import io.grpc.stub.StreamObserver;

public class AirQualityServiceImpl extends AirQualityMonitorGrpc.AirQualityMonitorImplBase {

    // Entry point for bi-directional streaming
    @Override
    public StreamObserver<AirQualityCheck> monitorAirQuality(StreamObserver<AirQualityAlert> responseObserver) {
        return new StreamObserver<AirQualityCheck>() {
            
            //Called whenever the client sends a room location
            @Override
            public void onNext(AirQualityCheck check) {
                String room = check.getLocation().toLowerCase();
                
                switch (room) {
                    case "kitchen":
                        responseObserver.onNext(AirQualityAlert.newBuilder()
                                .setAlertMessage("Kitchen: Air quality is GOOD")
                                .build());
                        delayedAlert(responseObserver, "Kitchen: Moderate smoke levels detected", 5000);
                        delayedAlert(responseObserver, "Kitchen: High smoke levels detected", 10000);
                        delayedAlert(responseObserver, "Kitchen: Call the fire brigade!", 15000);
                        break;

                    case "living room":
                        responseObserver.onNext(AirQualityAlert.newBuilder()
                                .setAlertMessage("Living Room: Air quality is EXCELLENT")
                                .build());
                        delayedAlert(responseObserver, "Living Room: Slight CO2 increase detected", 5000);
                        delayedAlert(responseObserver, "Living Room: Consider opening a window", 10000);
                        break;

                    case "bedroom":
                        responseObserver.onNext(AirQualityAlert.newBuilder()
                                .setAlertMessage("Bedroom: Air quality is FAIR")
                                .build());
                        delayedAlert(responseObserver, "Bedroom: This room needs ventilation", 5000);
                        break;

                    case "bathroom":
                        responseObserver.onNext(AirQualityAlert.newBuilder()
                                .setAlertMessage("Bathroom: High humidity detected")
                                .build());
                        delayedAlert(responseObserver, "Bathroom: Ventilation recommended", 5000);
                        break;

                    case "garage":
                        responseObserver.onNext(AirQualityAlert.newBuilder()
                                .setAlertMessage("Garage: Slight exhaust fume levels detected")
                                .build());
                        delayedAlert(responseObserver, "Garage: Air quality dropped – caution advised", 5000);
                        delayedAlert(responseObserver, "Garage: Air pollution levels have arised", 10000);
                        break;

                    default:
                        // Handle unknown room input
                        responseObserver.onNext(AirQualityAlert.newBuilder()
                                .setAlertMessage("Unknown room: " + check.getLocation())
                                .build());
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
        };
    }
} 
