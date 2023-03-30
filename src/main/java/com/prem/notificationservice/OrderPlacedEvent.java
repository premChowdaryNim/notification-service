package com.prem.notificationservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "notification")
@Builder
public class OrderPlacedEvent {

	@Id
	private String id;
	private String orderNumber;
}
