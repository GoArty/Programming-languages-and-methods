import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Subscriber {

    static String broker = "broker.emqx.io";
    static int port = 1883;
    static String topic = "java/mqtt";
    static String clientId = "java-mqtt-iu9reader";

    public static void main(String[] args) {
        try {
            MqttClient client = new MqttClient("tcp://" + broker + ":" + port, clientId, new MemoryPersistence());
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Connection lost because: " + cause);
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println("Received message from topic: " + topic + ", message: " + message.toString());

                    String[] coordinates = message.toString().split(", ");
                    double x1 = Double.parseDouble(coordinates[0]);
                    double y1 = Double.parseDouble(coordinates[1]);
                    double x2 = Double.parseDouble(coordinates[2]);
                    double y2 = Double.parseDouble(coordinates[3]);
                    double r1 = Double.parseDouble(coordinates[4]);
                    double r2 = Double.parseDouble(coordinates[5]);

                    int k = 0;
                    double sq = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
                    if(sq < r1 && sq + r2 > r1){
                        k=1;
                    }else if(sq > r1 && sq - r2 < r1){
                        k=1;
                    }
                    if(sq == 0 && r1 != r2){
                        k=0;
                    }else{
                        k=1;
                    }

                    System.out.println("Is the second circle nested inside the first?:" + k);
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                }
            });

            MqttConnectOptions connOpts = new MqttConnectOptions();
            System.out.println("Connecting to broker: " + broker);
            client.connect(connOpts);
            System.out.println("Connected to broker");

            client.subscribe(topic);

            while (true) {
                Thread.sleep(1000);
            }

        } catch (MqttException | InterruptedException me) {
            System.out.println("Msg: " + me.getMessage());
            System.out.println("Loc: " + me.getLocalizedMessage());
            System.out.println("Cause: " + me.getCause());
            System.out.println("Exception: " + me);
            me.printStackTrace();
        }
    }
}