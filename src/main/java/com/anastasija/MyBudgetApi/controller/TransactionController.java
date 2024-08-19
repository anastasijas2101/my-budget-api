package com.anastasija.MyBudgetApi.controller;

import com.anastasija.MyBudgetApi.model.entity.Transaction;
import com.anastasija.MyBudgetApi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }

    @GetMapping(params = "accountId")
    public List<Transaction> getTransactionByAccount(
            @RequestParam Integer accountId
    ) {
        return transactionService.findTransactionByAccountId(accountId);
    }
}
