package com.djordje.realtime_notifications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.djordje.realtime_notifications.model")
public class RealtimeNotificationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealtimeNotificationsApplication.class, args);
	}

}
