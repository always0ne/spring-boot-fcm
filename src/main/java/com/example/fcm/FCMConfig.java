package com.example.fcm;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class FCMConfig {

  @PostConstruct
  public void initFCM() throws IOException {
    InputStream serviceAccount =
        new ClassPathResource("firebase/firebase-adminSdk-key.json").getInputStream();

    FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .setDatabaseUrl("https://push-test-46f0c.firebaseio.com")
        .build();

    FirebaseApp.initializeApp(options);
  }
}
