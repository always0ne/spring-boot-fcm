package com.example.fcm;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

@Service
public class FcmService {

  public String sendPushMessage(PushContentsDto pushContentsDto, String token)
      throws FirebaseMessagingException {
    Message message = Message.builder()
        .setNotification(new Notification(pushContentsDto.getTitle(), pushContentsDto.getBody()))
        .putData("test title", "Test Content")
        .putData("body", "Test Content body")
        .setToken(token)
        .build();

    return FirebaseMessaging.getInstance().send(message);
  }
}
