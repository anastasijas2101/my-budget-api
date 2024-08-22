package com.anastasija.MyBudgetApi.model.dto;

import com.anastasija.MyBudgetApi.model.TransactionType;

public record TransactionDTO(
        String description,
        double amount,
        String currency,
        TransactionType type,
        Integer accountId
) {
}
