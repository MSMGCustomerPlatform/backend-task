# MoneySuperMarket.com 
## Java Developer Technical Test

## Overview

MoneySuperMarket have gone Bitcoin crazy and decided to allow their customers to keep an 
eye on the best exchanges with the highest selling price.

This application calls the below bitcoin exchanges to retrieve selling price information:

 * https://blockchain.info/ticker
 * https://api.exmo.com/v1/ticker

It finds the exchange with the best (highest) price and returns the price and the exchange name.

The application responds on http://localhost:8080/exchangeapp/highestprice/

## Exercise

We've done a deal with a new exchange and would like to include their prices in the application.

The new Api is:
https://api.bitfinex.com/v1/pubticker/btcusd

(hint - you'll need the ask price)

## Stetch

Finished early? We'd also like to look at including a parameter to expand beyond just USD selling prices.

You'll need to extend the application to include bitfinex within the highest price calculation.

## Technologies

 * Java 1.8
 * Gradle
 * JUnit
 * Mockito
 * Hamcrest/AssertJ
