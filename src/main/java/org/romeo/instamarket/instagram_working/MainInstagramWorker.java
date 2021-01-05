package org.romeo.instamarket.instagram_working;

import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MainInstagramWorker {
    public InstagramUser getInstagramUserFor(String username, String password) throws IOException {
        Instagram4j instagram = Instagram4j
                .builder()
                .username(username)
                .password(password)
                .build();

        instagram.setup();
        instagram.login();

        try {
            return instagram.sendRequest(new InstagramSearchUsernameRequest(username)).getUser();
        } catch (NullPointerException e) {
            return null;
        }
    }
}
