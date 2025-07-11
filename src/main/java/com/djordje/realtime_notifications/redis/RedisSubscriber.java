package com.djordje.realtime_notifications.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisSubscriber implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel());
        String message_body = new String(message.getBody());

        System.out.println("Received message from channel '" + channel + "': " + message_body);
    }
}
