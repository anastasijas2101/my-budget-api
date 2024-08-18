package com.anastasija.MyBudgetApi.service;

import com.anastasija.MyBudgetApi.model.entity.Transaction;
import com.anastasija.MyBudgetApi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findByAccountId(Integer accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}
