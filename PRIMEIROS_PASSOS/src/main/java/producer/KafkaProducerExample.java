package producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;

public class KafkaProducerExample {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Define Kafka producer properties
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "0.0.0.0:9092"); // Replace with your Kafka broker(s)
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        // Create a Kafka producer instance
        Producer<String, String> producer = new KafkaProducer<>(properties);

        // Define the Kafka topic to which you want to send messages
        String topic = "my-topic";

        String mensagem = "Mensagem a ser passada para o consumer";

        // Produce a message to the topic000
        producer.send(new ProducerRecord<>(topic, "key2", mensagem));

        // Close the producer
        producer.close();
    }
}
