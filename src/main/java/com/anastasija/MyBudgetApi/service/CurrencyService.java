package com.anastasija.MyBudgetApi.service;

import com.anastasija.MyBudgetApi.model.dto.CurrencyDTO;
import com.anastasija.MyBudgetApi.model.dto.CurrencyRateDTO;
import com.anastasija.MyBudgetApi.model.dto.CurrencyRateResponseDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CurrencyService {

    RestClient currencyClient = RestClient.create();

    public List<CurrencyDTO> getCurrencies() {
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

    public List<CurrencyRateDTO> getCurrencyRates() {
        CurrencyRateResponseDTO currencyRateResponseDTO = currencyClient.get()
                .uri("https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/currencies/eur.json")
                .retrieve()
                .body(new ParameterizedTypeReference<CurrencyRateResponseDTO>() {});

        List<CurrencyRateDTO> currencyRateList = new ArrayList<>();
        if ( currencyRateResponseDTO != null && currencyRateResponseDTO.eur() != null) {
            Map<String, Double> ratesMap = currencyRateResponseDTO.eur();
            for (Map.Entry<String, Double> entry : ratesMap.entrySet()) {
                currencyRateList.add(new CurrencyRateDTO(entry.getKey().toUpperCase(), entry.getValue()));
            }
        }
        return currencyRateList;
    }

    public double convert(String sourceCurrency, double sourceAmount, String targetCurrency) {
        CurrencyRateDTO targetCurrencyDTO = getCurrencyRates().stream().filter(c -> c.code().equals(targetCurrency)).findAny().get();
        CurrencyRateDTO sourceCurrencyDTO = getCurrencyRates().stream().filter(c -> c.code().equals(sourceCurrency)).findAny().get();
        double convertedSourceAmountEur = sourceAmount / sourceCurrencyDTO.rate();
        return convertedSourceAmountEur * targetCurrencyDTO.rate();
    }
}
