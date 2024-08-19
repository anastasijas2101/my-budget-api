package com.anastasija.MyBudgetApi.controller;

import com.anastasija.MyBudgetApi.model.entity.Account;
import com.anastasija.MyBudgetApi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAccounts(){
            return accountService.findAccounts();
    }
}
