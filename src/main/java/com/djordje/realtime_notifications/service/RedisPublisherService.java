package com.djordje.realtime_notifications.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class RedisPublisherService {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    ChannelTopic channelTopic;

    public void publish(Object message){
            redisTemplate.convertAndSend(channelTopic.getTopic(),message);

    }}
