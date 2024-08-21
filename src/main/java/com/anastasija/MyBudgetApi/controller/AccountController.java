package com.anastasija.MyBudgetApi.controller;

import com.anastasija.MyBudgetApi.model.dto.AccountDTO;
import com.anastasija.MyBudgetApi.model.entity.Account;
import com.anastasija.MyBudgetApi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> findAccounts(){
            return accountService.findAccounts();
    }

    @PostMapping
    public Account createAccount(
            @RequestBody AccountDTO accountDTO
            ) {
        return accountService.createAccount(accountDTO);
    }

    @GetMapping(params = "balance")
    public double findTotalBalance() {
        return accountService.findTotalBalance();
    }
}
