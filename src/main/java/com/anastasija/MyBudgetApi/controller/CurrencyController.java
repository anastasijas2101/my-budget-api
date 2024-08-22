package com.anastasija.MyBudgetApi.controller;

import com.anastasija.MyBudgetApi.model.dto.CurrencyDTO;
import com.anastasija.MyBudgetApi.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public List<CurrencyDTO> getCurrency() {
        return currencyService.getCurrency();
    }
}
