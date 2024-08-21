package com.anastasija.MyBudgetApi.service;

import com.anastasija.MyBudgetApi.model.dto.TransactionDTO;
import com.anastasija.MyBudgetApi.model.entity.Account;
import com.anastasija.MyBudgetApi.model.entity.Transaction;
import com.anastasija.MyBudgetApi.repository.AccountRepository;
import com.anastasija.MyBudgetApi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

        public List<Transaction> findTransactionByAccountId(Integer accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    public Transaction createTransaction(TransactionDTO transactionDTO) {

        Account account = accountRepository.findById(transactionDTO.accountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        double newBalance;
        if (transactionDTO.type().equals("Expense")) {
            newBalance = account.getBalance() - transactionDTO.amount();
            if (newBalance < 0) {
                throw new RuntimeException("Insufficient funds");
            }
        } else {
            newBalance = account.getBalance() + transactionDTO.amount();
        }

        account.setBalance(newBalance);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setDescription(transactionDTO.description());
        transaction.setAmount(transactionDTO.amount());
        transaction.setCurrency(transactionDTO.currency());
        transaction.setAccount(account);

        return transactionRepository.save(transaction);
    }

    public void deleteAllTransactions() {
        transactionRepository.deleteAll();
    }

}
