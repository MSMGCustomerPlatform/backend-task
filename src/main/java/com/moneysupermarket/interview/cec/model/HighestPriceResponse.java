package com.moneysupermarket.interview.cec.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class HighestPriceResponse {

    private String apiName;

    private BigDecimal price;
}
