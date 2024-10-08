package com.anastasija.MyBudgetApi.repository;

import com.anastasija.MyBudgetApi.model.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    List<Transaction> findAll();
    List<Transaction> findByAccountId(Integer accountId);
}
