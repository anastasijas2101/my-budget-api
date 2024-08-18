package com.anastasija.MyBudgetApi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private double balance;
    private String currency;
    @Column(
            insertable = false,
            updatable = false
    )
    private Integer user_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private List<Transaction> transactions;
}
