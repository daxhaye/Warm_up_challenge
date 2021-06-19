package com.challengewarmup.controllers;

import com.challengewarmup.models.entity.User;
import com.challengewarmup.models.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserRestController {

    @Autowired
    private IUserService userService;
}
