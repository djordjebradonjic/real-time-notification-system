package com.djordje.realtime_notifications.repository;

import com.djordje.realtime_notifications.model.Notification;
import com.djordje.realtime_notifications.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository  extends JpaRepository<Notification,Long> {
    List<Notification> findByUser(User user);
}
