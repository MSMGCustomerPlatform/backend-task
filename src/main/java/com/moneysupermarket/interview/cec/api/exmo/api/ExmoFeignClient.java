package com.moneysupermarket.interview.cec.api.exmo.api;

import com.moneysupermarket.interview.cec.api.exmo.dto.ExmoPriceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(
        name = "exmo-currency-service",
        url = "${exmo.url}")
public interface ExmoFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/ticker")
    Map<String, ExmoPriceDto> getCurrencies();
}
