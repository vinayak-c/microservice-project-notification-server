package com.vinayak.microservice.notificationmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@SpringBootApplication
public class NotificationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationMicroserviceApplication.class, args);
	}

	@Bean
	public Consumer<Message<String>> notificationEventSupplier() {
		return message -> new EmailSender().sendEmail(message.getPayload());
	}

}
