package com.anastasija.MyBudgetApi.model.dto;

public record AccountDTO(
        String name,
        double balance,
        String currency
) {
}
