package com.djordje.realtime_notifications.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Getter
@Setter
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String message;
    private boolean read = false;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnoreProperties({"notifications"})
    private User user;

    public Notification(){}
    public Notification(String message , User user){
        this.message=message;
        this.user=user;

    }

}
