package com.djordje.realtime_notifications.service;


import com.djordje.realtime_notifications.dto.CreateNotificationRequestDTO;
import com.djordje.realtime_notifications.model.Notification;
import com.djordje.realtime_notifications.model.User;
import com.djordje.realtime_notifications.repository.NotificationRepository;
import com.djordje.realtime_notifications.repository.UserRepository;
import com.djordje.realtime_notifications.websocket.NotificationWebSocketHandler;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RedisPublisherService redisPublisherService;

    @Autowired
    NotificationWebSocketHandler webSocketHandler;

    public void createNotification(CreateNotificationRequestDTO request){
        User user =userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Notification notification = new Notification(request.getMessage(),user);
        notificationRepository.save(notification);
        redisPublisherService.publish(notification);

    }

    public void sendNotificationRealTime(Notification notification){
        try {
            String message = notification.getMessage();
            Long userId = notification.getUser().getId();
            webSocketHandler.sendNotificationToUser(userId, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

