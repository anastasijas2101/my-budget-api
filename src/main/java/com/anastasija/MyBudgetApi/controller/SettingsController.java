package com.anastasija.MyBudgetApi.controller;

import com.anastasija.MyBudgetApi.service.AccountService;
import com.anastasija.MyBudgetApi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/settings")
public class SettingsController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;

    @DeleteMapping(params = "delete")
    public ResponseEntity<Void> deleteAllData() {
        transactionService.deleteAllTransactions();
        accountService.deleteAllAccounts();
        return ResponseEntity.noContent().build();
    }
}
