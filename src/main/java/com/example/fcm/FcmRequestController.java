package com.example.fcm;

import com.google.firebase.messaging.FirebaseMessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FcmRequestController {

  private final FcmService fcmService;

  @PostMapping("/{deviceToken}")
  public String testCall(
      @RequestBody PushContentsDto pushContentsDto,
      @PathVariable String deviceToken
  ) throws FirebaseMessagingException {
    return fcmService.sendPushMessage(pushContentsDto, deviceToken);
  }
}
