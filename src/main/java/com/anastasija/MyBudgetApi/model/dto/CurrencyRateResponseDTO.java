package com.anastasija.MyBudgetApi.model.dto;

import java.util.Map;

public record CurrencyRateResponseDTO(
        String date,
        Map<String, Double> eur
) {
}
