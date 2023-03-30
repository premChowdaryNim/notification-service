package com.prem.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.KafkaListener;

import com.prem.notificationservice.repository.NotificationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@EnableDiscoveryClient
public class NotificationServiceApplication {

	private final NotificationRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@KafkaListener(topics="notificationTopic")
	public void handleNotification(OrderPlacedEvent orderPlacedEvent) {
		log.info("Recieved Notification for Order -{}",orderPlacedEvent.getOrderNumber());
		repository.save(orderPlacedEvent);
	}
}
