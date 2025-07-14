package com.djordje.realtime_notifications.redis;

import com.djordje.realtime_notifications.model.Notification;
import com.djordje.realtime_notifications.service.NotificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RedisSubscriber implements MessageListener {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel());
        String message_body = new String(message.getBody());
        try {
            String json = new String(message.getBody());
            Notification notification = objectMapper.readValue(json,Notification.class);
            notificationService.sendNotificationRealTime(notification);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("Received message from channel '" + channel + "': " + message_body);
    }
}
