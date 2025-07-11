package com.djordje.realtime_notifications.controller;

import com.djordje.realtime_notifications.dto.CreateNotificationRequestDTO;
import com.djordje.realtime_notifications.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@CrossOrigin(origins = "*")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping
    public String createNotification(@RequestBody CreateNotificationRequestDTO request){
            notificationService.createNotification(request);
            return "Notification created successfully";
    }
}
