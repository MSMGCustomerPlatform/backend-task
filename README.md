# MoneySuperMarket.com 
## Java Developer Technical Test

## Overview

MoneySuperMarket have gone Bitcoin crazy and decided to allow their customers to keep an 
eye on the best exchanges with the highest selling price.

This application calls the below Bitcoin exchanges to retrieve selling price information:

 * https://blockchain.info/ticker
 * https://api.exmo.com/v1/ticker

It finds the exchange with the best (highest) price and returns the price and the exchange name.

## Prerequisites
1.	Download community edition of IntelliJ for [Windows](https://www.jetbrains.com/idea/download/#section=windows) or [MacOs](https://www.jetbrains.com/idea/download/#section=windows) and open the application when the installation has completed.
2. 	Download the MSM technical test project files [HERE](https://github.com/MSMGCustomerPlatform/backend-task/archive/refs/heads/main.zip) and save locally.
3. 	Unzip to a folder of your choice.
4.	Open IntelliJ
5.	Select File > New > Project from Existing Sources...
    ![img.png](readme_files/img.png)
      
6. When the file navigator opens select build.gradle from the route of the downloaded code folder
7. Open a terminal navigate to the ./backend-task folder
8. Execute: `./gradlew bootRun` and ensure the project builds, tests and runs successfully 
9.	Open http://localhost:8080/exchangeapp/highestprice/ in a browser and view the response from the application e.g.:
![img_1.png](readme_files/img_1.png)
      
## Exercise

We've done a deal with a new exchange and would like to include their prices in the application.

The new Api is:
https://api.bitfinex.com/v1/pubticker/btcusd

(hint - you'll need the ask price)

The application responds on http://localhost:8080/exchangeapp/highestprice/

## Stetch Goal

Finished early? We'd also like to look at including a parameter to expand beyond just USD selling prices.

You'll need to extend the application to include bitfinex within the highest price calculation.

## Technologies

 * Java 1.8
 * Gradle
 * JUnit
 * Mockito
 * Hamcrest/AssertJ
