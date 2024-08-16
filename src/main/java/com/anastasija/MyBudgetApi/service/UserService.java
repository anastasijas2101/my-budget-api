package com.anastasija.MyBudgetApi.service;

import com.anastasija.MyBudgetApi.model.dto.LoginDto;
import com.anastasija.MyBudgetApi.model.entity.User;
import com.anastasija.MyBudgetApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByLogin(LoginDto loginDto) {
        return userRepository.findByEmailAndPassword(loginDto.email(), loginDto.password());
    }
}
