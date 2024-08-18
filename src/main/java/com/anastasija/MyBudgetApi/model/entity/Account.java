package com.anastasija.MyBudgetApi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
