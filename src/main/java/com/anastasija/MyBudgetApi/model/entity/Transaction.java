package com.anastasija.MyBudgetApi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    private double amount;
    private String currency;
    @Column(
            insertable = false,
            updatable = false
    )
    private Integer account_id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
