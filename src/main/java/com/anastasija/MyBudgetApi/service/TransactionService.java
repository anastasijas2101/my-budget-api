package com.anastasija.MyBudgetApi.service;

import com.anastasija.MyBudgetApi.model.TransactionType;
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

    @Autowired
    private CurrencyService currencyService;

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

        public List<Transaction> findTransactionByAccountId(Integer accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    public Transaction createTransaction(TransactionDTO transactionDTO) {

        Account account = accountRepository.findById(transactionDTO.accountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        double amount = transactionDTO.amount();
        String currency = transactionDTO.currency();
        Transaction transaction = new Transaction();
        transaction.setDescription(transactionDTO.description());
        transaction.setCurrency(currency);
        transaction.setType(transactionDTO.type());
        transaction.setAmount(transactionDTO.amount());
        transaction.setConvertedAmount(currencyService.convert(currency, amount, "EUR"));
        transaction.setConvertedCurrency("EUR");
        transactionRepository.save(transaction);

        double newBalance;
        double formerCurrencyBalance;
        double formerCurrencyAmount = currencyService.convert(currency, amount, account.getCurrency());
        if (transactionDTO.type().equals(TransactionType.EXPENSE)) {
            newBalance = account.getConvertedBalance() - transaction.getConvertedAmount();
            formerCurrencyBalance = account.getBalance() - formerCurrencyAmount;
            if (newBalance < 0) {
                throw new RuntimeException("Insufficient funds");
            }
        } else {
            newBalance = account.getConvertedBalance() + transaction.getConvertedAmount();
            formerCurrencyBalance = account.getBalance() + formerCurrencyAmount;
        }

        account.setBalance(formerCurrencyBalance);
        account.setConvertedBalance(newBalance);
        accountRepository.save(account);

        transaction.setAccount(account);

        return transactionRepository.save(transaction);
    }

    public void deleteAllTransactions() {
        transactionRepository.deleteAll();
    }

}
