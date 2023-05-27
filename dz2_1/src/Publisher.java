import java.util.Scanner;
import java.lang.Thread;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
public class Publisher {

    static String broker = "broker.emqx.io";
    static int port = 1883;
    static String topic = "java/mqtt";
    static String clientId = "java-mqtt-iu9publisher";

    public static void main(String[] args) {
        try {
            MqttClient client = new MqttClient("tcp://" + broker + ":" + port, clientId, new MemoryPersistence());
            client.setCallback(new MqttCallback() {
                public void connectionLost(Throwable throwable) {
                    System.out.println("Connection to MQTT broker lost!");
                }

                public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                    System.out.println("Message received:\n\tTopic: " + s + "\n\tMessage: " + new String(mqttMessage.getPayload()));
                }

                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                }
            });

            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
            mqttConnectOptions.setCleanSession(true);

            System.out.println("Connecting to broker: " + broker);
            client.connect(mqttConnectOptions);
            System.out.println("Connected to MQTT broker!");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Enter the two centers of circles and their radii in plane:");
                String coordinates = scanner.nextLine();

                // Publish the coordinates as a message
                MqttMessage mqttMessage = new MqttMessage(coordinates.getBytes());
                mqttMessage.setQos(2);
                mqttMessage.setRetained(false);

                String topic = Publisher.topic;
                System.out.println("Publishing message: " + coordinates);
                client.publish(topic, mqttMessage);

                Thread.sleep(1000);
            }
        } catch (MqttException ex) {
            System.err.println("Exception while connecting to MQTT broker: " + ex.getMessage());
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            System.err.println("Interrupted while publishing messages: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
