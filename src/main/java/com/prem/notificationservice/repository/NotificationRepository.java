package com.prem.notificationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prem.notificationservice.OrderPlacedEvent;

public interface NotificationRepository extends MongoRepository<OrderPlacedEvent, String> {

}
