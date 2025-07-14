package com.djordje.realtime_notifications.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateNotificationRequestDTO {

    private String message;
    private String username;

    public  CreateNotificationRequestDTO(){}
}
