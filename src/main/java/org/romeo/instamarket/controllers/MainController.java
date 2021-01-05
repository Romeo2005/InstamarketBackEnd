package org.romeo.instamarket.controllers;

import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;
import org.romeo.instamarket.data_working.MainDataWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @Autowired
    MainDataWorker dataWorker;


    //I know that transporting passwords in url is not good practice, it's just for test
    @GetMapping("getInstagramUser")
    @ResponseBody
    InstagramUser getInstagramUser(String username, String password) {
        return dataWorker.getInstagramUserFor(username, password);
    }
}
