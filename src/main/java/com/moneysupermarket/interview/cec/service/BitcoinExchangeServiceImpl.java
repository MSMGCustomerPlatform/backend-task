package com.moneysupermarket.interview.cec.service;

import com.moneysupermarket.interview.cec.model.HighestPriceResponse;
import com.moneysupermarket.interview.cec.api.blockchain.api.BlockchainFeignClient;
import com.moneysupermarket.interview.cec.api.blockchain.dto.BlockchainPriceDto;
import com.moneysupermarket.interview.cec.api.exmo.api.ExmoFeignClient;
import com.moneysupermarket.interview.cec.api.exmo.dto.ExmoPriceDto;
import com.moneysupermarket.interview.cec.util.BitcoinExchangeConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

import static com.moneysupermarket.interview.cec.util.BitcoinExchangeConstants.BLOCKCHAIN_API_NAME;
import static com.moneysupermarket.interview.cec.util.BitcoinExchangeConstants.EXMO_API_NAME;

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
                return HighestPriceResponse.builder().apiName(BLOCKCHAIN_API_NAME).price(blockchainUsdPrice.get().getSellPrice()).build();
            }

            return HighestPriceResponse.builder().apiName(EXMO_API_NAME).price(exmoUsdPrice.get().getSellPrice()).build();
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
