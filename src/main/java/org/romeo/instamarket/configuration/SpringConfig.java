package org.romeo.instamarket.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@Configuration
@EnableWebMvc
@ComponentScan("org.romeo.instamarket")
public class SpringConfig implements WebMvcConfigurer {
    private final ApplicationContext applicationContext;

    @Autowired
    public SpringConfig(ApplicationContext context) {
        this.applicationContext = context;
    }

    @Bean
    public FirebaseMessaging firebaseMessaging() throws IOException {
        GoogleCredentials credentials =
                GoogleCredentials.fromStream(
                        new ClassPathResource("instamarket-29ee8-firebase-adminsdk-m82jo-e79bcc70eb.json").getInputStream()
                );

        FirebaseOptions options = FirebaseOptions
                .builder()
                .setCredentials(credentials)
                .build();

        FirebaseApp app = FirebaseApp
                .initializeApp(options, "InstamarketApp");

        return FirebaseMessaging.getInstance(app);
    }
}
