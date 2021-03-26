package com.moneysupermarket.interview.cec.controller;

import com.moneysupermarket.interview.cec.model.HighestPriceResponse;
import com.moneysupermarket.interview.cec.service.BitcoinExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BitcoinExchangeController {

    @Autowired
    private BitcoinExchangeService bitcoinExchangeService;

    @RequestMapping(value = "/highestprice/", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public HighestPriceResponse getCurrencies() {
        return bitcoinExchangeService.getHighestPrice();
    }
}
