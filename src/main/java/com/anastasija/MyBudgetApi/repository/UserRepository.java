package com.anastasija.MyBudgetApi.repository;

import com.anastasija.MyBudgetApi.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmailAndPassword(String email, String password);
}
