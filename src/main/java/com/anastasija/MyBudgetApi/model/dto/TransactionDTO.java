package com.anastasija.MyBudgetApi.model.dto;

public record TransactionDTO(
        String description,
        double amount,
        String currency,
        String type,
        Integer accountId
) {
}
