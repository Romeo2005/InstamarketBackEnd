package org.romeo.instamarket.data_working;

import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;
import org.romeo.instamarket.instagram_working.MainInstagramWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MainDataWorker {
    MainInstagramWorker instagramWorker;

    @Autowired
    public MainDataWorker(MainInstagramWorker instagramWorker) {
        this.instagramWorker = instagramWorker;
    }

    public InstagramUser getInstagramUserFor(String username, String password) {
        try {
            return instagramWorker.getInstagramUserFor(username, password);
        } catch (IOException e) {
            return null;
        }
    }
}
