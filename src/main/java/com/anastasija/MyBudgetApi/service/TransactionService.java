package com.anastasija.MyBudgetApi.service;

import com.anastasija.MyBudgetApi.model.dto.TransactionDTO;
import com.anastasija.MyBudgetApi.model.entity.Transaction;
import com.anastasija.MyBudgetApi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

        public List<Transaction> findTransactionByAccountId(Integer accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    public Transaction createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setDescription(transactionDTO.description());
        transaction.setAmount(transactionDTO.amount());
        transaction.setCurrency(transactionDTO.currency());
        transaction.setAccount_id(transactionDTO.accountId());

        return transactionRepository.save(transaction);
    }

}
