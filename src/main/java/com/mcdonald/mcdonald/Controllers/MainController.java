package com.mcdonald.mcdonald.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcdonald.mcdonald.Models.UserModel;
import com.mcdonald.mcdonald.Services.UserService;

@RestController
@RequestMapping("api/mcdonald")
public class MainController {

    @Autowired
    private UserService userService;

    @PostMapping("user")
    public String addUser(@RequestHeader String userName, @RequestHeader String password) {
        UserModel user = new UserModel();
        user.setUserName(userName);
        user.setPassword(password);
        return userService.addUserService(user);
    }

    @GetMapping("login/{username}")
    public String login(@PathVariable("username") String userName, @RequestHeader String password) {
        UserModel user = new UserModel();
        user.setUserName(userName);
        user.setPassword(password);
        return userService.loginService(user);
    }

}
