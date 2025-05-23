package distsys.smartclimatecontrolsystem.humidity;

/**
 * Implementation of the HumidityControl gRPC service.
 * Handles the single operation defined in HumidityControl.proto:
 *
 * - SetHumidityLevel: receives a stream of humidity values from the client (Client Streaming)
 *   and returns a status message once the stream is complete.
 *
 * This service simulates a smart home humidity controller. Clients can send
 * multiple humidity readings in a single session, and the server processes
 * them to update the internal state or apply logic accordingly.
 *
 * Author: guilhermesilveira
 */

// Import the generated gRPC service and message types
import generated.grpc.humidity.HumidityControlGrpc;
import generated.grpc.humidity.HumidityControlOuterClass.*;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

// This service class extends the generated abstract class (base template)
public class HumidityServiceImpl extends HumidityControlGrpc.HumidityControlImplBase {

    /**
     * This method handles the client streaming RPC: SetHumidityLevel.
     * The client will send multiple HumidityRequest messages, and this method
     * will respond with a single StatusResponse after all messages are received.
     */
    @Override
    public StreamObserver<HumidityRequest> setHumidityLevel(StreamObserver<StatusResponse> responseObserver) {
        // Return a new StreamObserver that listens to incoming messages from the client
        return new StreamObserver<HumidityRequest>() {

            // Store all received humidity values in a list
            List<Float> humidityReadings = new ArrayList<>();

            /**
             * This method is called every time the client sends a new HumidityRequest message.
             */
            @Override
            public void onNext(HumidityRequest value) {
                float humidity = value.getHumidity();
                
                // Validate the humidity range
                if (humidity < 0 || humidity > 100) {
                    System.out.println("Ignored invalid humidity value: " + humidity);
                    return;
                }
                
                humidityReadings.add(humidity); // Save the reading
                System.out.println("Received humidity: " + humidity);
            }

            /**
             * This method is called if the client aborts the connection or an error occurs.
             */
            @Override
            public void onError(Throwable t) {
                System.err.println("Error receiving humidity stream: " + t.getMessage());
            }

            /**
             * This method is called when the client has finished sending all messages.
             * At this point, we process all collected humidity readings and send back a response.
             */
            @Override
            public void onCompleted() {
                // Calculate the average humidity (or 0.0 if none received)
                float average = 0f;

                if (!humidityReadings.isEmpty()) {
                    float sum = 0f;
                    for (float h : humidityReadings) {
                        sum += h;
                    }
                    average = sum / humidityReadings.size();
                }

                // Create a status message
                String message = humidityReadings.isEmpty()
                    ? "No valid humidity readings were received."
                    : "Received " + humidityReadings.size() + " readings. Average: " + average;

                // Build the response message
                StatusResponse response = StatusResponse.newBuilder()
                    .setMessage(message)
                    .build();

                // Send the response to the client
                responseObserver.onNext(response);

                // Close the stream
                responseObserver.onCompleted();
            }
        };
    }
}
