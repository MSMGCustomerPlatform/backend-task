package com.moneysupermarket.interview.cec.service;

import com.moneysupermarket.interview.cec.api.blockchain.api.BlockchainFeignClient;
import com.moneysupermarket.interview.cec.api.blockchain.dto.BlockchainPriceDto;
import com.moneysupermarket.interview.cec.api.exmo.api.ExmoFeignClient;
import com.moneysupermarket.interview.cec.api.exmo.dto.ExmoPriceDto;
import com.moneysupermarket.interview.cec.model.HighestPriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class BitcoinExchangeServiceImpl implements BitcoinExchangeService {

    @Autowired
    private BlockchainFeignClient blockchainFeignClient;

    @Autowired
    private ExmoFeignClient exmoFeignClient;

    @Override
    public HighestPriceResponse getHighestPrice() {
        Optional<BlockchainPriceDto> blockchainUsdPrice = getBlockchainUsdPrice();
        Optional<ExmoPriceDto> exmoUsdPrice = getExmoUsdPrice();

        if (blockchainUsdPrice.isPresent() && exmoUsdPrice.isPresent()) {

            if (blockchainUsdPrice.get().getSellPrice().compareTo(exmoUsdPrice.get().getSellPrice()) > 0) {
                return HighestPriceResponse.builder().apiName("Blockchain").price(blockchainUsdPrice.get().getSellPrice()).build();
            }

            return HighestPriceResponse.builder().apiName("Exmo").price(exmoUsdPrice.get().getSellPrice()).build();
        }

        throw new IllegalStateException("USD currency not be found.");
    }

    private Optional<BlockchainPriceDto> getBlockchainUsdPrice() {
        Map<String, BlockchainPriceDto> blockchainCurrencies = blockchainFeignClient.getCurrencies();
        return Optional.ofNullable(blockchainCurrencies.get("USD"));
    }

    private Optional<ExmoPriceDto> getExmoUsdPrice() {
        Map<String, ExmoPriceDto> exmoCurrencies = exmoFeignClient.getCurrencies();
        return Optional.ofNullable(exmoCurrencies.get("BTC_USD"));
    }

}
