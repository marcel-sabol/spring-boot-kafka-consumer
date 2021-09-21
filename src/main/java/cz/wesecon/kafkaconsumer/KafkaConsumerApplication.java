package cz.wesecon.kafkaconsumer;

import cz.wesecon.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaConsumerApplication {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

	@KafkaListener(id = "b_consumer-group", topics = "a_messages")
	public void listen(Message message) {
		LOG.info("Received: Name={}, Type={}, Amount={}", message.getName(), message.getType(), message.getAmount());
	}

}
