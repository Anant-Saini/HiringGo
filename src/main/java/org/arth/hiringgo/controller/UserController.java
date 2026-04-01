package org.arth.hiringgo.controller;

import lombok.RequiredArgsConstructor;
import org.arth.hiringgo.model.User;

import org.arth.hiringgo.service.MyUserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final MyUserDetailsService userDetailsService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return userDetailsService.register(user);

    }
}
