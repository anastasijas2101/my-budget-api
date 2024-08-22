package com.anastasija.MyBudgetApi.repository;

import com.anastasija.MyBudgetApi.model.entity.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
     List<Account> findAll();

     @Query("SELECT SUM(a.convertedBalance) FROM Account a")
     Double findTotalBalance();
}
