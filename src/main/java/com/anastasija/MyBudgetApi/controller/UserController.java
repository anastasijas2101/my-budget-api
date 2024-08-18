package com.anastasija.MyBudgetApi.controller;

import com.anastasija.MyBudgetApi.model.dto.LoginDto;
import com.anastasija.MyBudgetApi.model.entity.User;
import com.anastasija.MyBudgetApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/login")
    public User login(
        @RequestBody LoginDto loginDto
    ) {
        return userService.findByLogin(loginDto);
    }

}
