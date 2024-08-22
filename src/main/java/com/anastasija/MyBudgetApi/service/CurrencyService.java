package com.anastasija.MyBudgetApi.service;

import com.anastasija.MyBudgetApi.model.dto.CurrencyDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CurrencyService {

    RestClient currencyClient = RestClient.create();

    public List<CurrencyDTO> getCurrency() {
        Map<String, String> currencyMap = currencyClient.get()
                .uri("https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/currencies.json")
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String, String>>() {});

        List<CurrencyDTO> currencyList = new ArrayList<>();
        for (Map.Entry<String, String> entry : currencyMap.entrySet()) {
            currencyList.add(new CurrencyDTO(entry.getKey().toUpperCase(), entry.getValue()));
        }

        return currencyList;
    }
}
