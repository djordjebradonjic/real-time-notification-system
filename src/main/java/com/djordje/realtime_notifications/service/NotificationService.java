package com.djordje.realtime_notifications.service;


import com.djordje.realtime_notifications.dto.CreateNotificationRequestDTO;
import com.djordje.realtime_notifications.model.Notification;
import com.djordje.realtime_notifications.model.User;
import com.djordje.realtime_notifications.repository.NotificationRepository;
import com.djordje.realtime_notifications.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    UserRepository userRepository;

    public void createNotification(CreateNotificationRequestDTO request){
        User user =userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Notification notification = new Notification(request.getMessage(),user);
        notificationRepository.save(notification);

    }
}
