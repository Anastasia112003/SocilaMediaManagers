package com.example.socilamediamanager.controller;

import com.example.socilamediamanager.model.Influencer;
import com.example.socilamediamanager.service.MediaManagerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MediaController {
    private final MediaManagerService managerService;

    public MediaController(MediaManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/create")
    public void send(@RequestBody Influencer influencer) {
        managerService.sendTo(influencer);
    }

}


