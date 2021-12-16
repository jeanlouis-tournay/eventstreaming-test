package com.cegeka.dplt.streaming.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class EventstreamingProducerApplication {




	public static void main(String[] args) {
		SpringApplication.run(EventstreamingProducerApplication.class, args);
	}

}
