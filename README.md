# [CamPay](https://www.campay.net/) Android SDK

![Campay Art](./art/campay.png)

![Android CI](https://github.com/CamPay/android-sdk/workflows/Android%20CI/badge.svg)
[![](https://jitpack.io/v/CamPay/android-sdk.svg)](https://jitpack.io/#CamPay/android-sdk)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=CamPay_android-sdk&metric=security_rating)](https://sonarcloud.io/dashboard?id=CamPay_android-sdk)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=CamPay_android-sdk&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=CamPay_android-sdk)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=CamPay_android-sdk&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=CamPay_android-sdk)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=CamPay_android-sdk&metric=bugs)](https://sonarcloud.io/dashboard?id=CamPay_android-sdk)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=CamPay_android-sdk&metric=alert_status)](https://sonarcloud.io/dashboard?id=CamPay_android-sdk)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=CamPay_android-sdk&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=CamPay_android-sdk)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=CamPay_android-sdk&metric=ncloc)](https://sonarcloud.io/dashboard?id=CamPay_android-sdk)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=CamPay_android-sdk&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=CamPay_android-sdk)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=CamPay_android-sdk&metric=coverage)](https://sonarcloud.io/dashboard?id=CamPay_android-sdk)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=CamPay_android-sdk&metric=code_smells)](https://sonarcloud.io/dashboard?id=CamPay_android-sdk)

## Summary

  - [Getting Started](#getting-started)
  - [Running the samples](#running-the-samples)
  - [Deployment](#deployment)
  - [Built With](#built-with)

## Getting Started

These instructions will get you started with the CamPay SDK for development and testing purposes. See deployment
for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them
 - An account on [CamPay](https://www.campay.net/) platform
 - An application on the [CamPay platform](https://demo.campay.net/en/users/signup/).
 - Credentials for connecting to the CamPay platform

### Installing

A step by step series of examples that tell you how to get a development
env running

- Check out the available versions on [Jitpack](https://jitpack.io/#CamPay/android-sdk/)

-  Add the JitPack repository to your build file
   ```groovy
       allprojects {
        repositories {
          ...
          maven { url 'https://jitpack.io' }
        }
      }
   ```
- Add the dependency
```groovy
    implementation 'com.github.CamPay.android-sdk:android-sdk:latest.release'
    // Peer dependency
    implementation 'io.reactivex.rxjava3:rxjava:3.0.0'
```
- Add the internet permission to your application
```xml
    <uses-permission android:name="android.permission.INTERNET" />
```

## Running the samples

To view an extensive list of samples, clone this project and run the app module. 

  - Initialize the library with credentials. 
  ```kotlin
        CamPay.init(
            "<username>",
            "<password>",
            CamPay.Environment.DEV // environment
        )
  ```

  - Get an instance of the library from anywhere in your application and run the various operations. 
  ```kotlin
       val camPay = CamPay.getInstance()

        camPay.collect(
            CollectionRequest.CollectionRequestBuilder
                .aCollectionRequest()
                .withAmount("amount")
                .withFrom("237XXXXXXXXX")
                .withDescription("some reason")
                .withExternalReference(UUID.randomUUID().toString())
                .withCurrency("XAF")
                .build()
        ).delay(1, TimeUnit.MINUTES) // delay for a minute before checking the transaction status
            .switchMap { collectResponse ->
                println(collectResponse)
                return@switchMap camPay.transactionStatus(collectResponse.reference) //  check the transaction status
            }.subscribe { transactionStatusResponse ->
                println(transactionStatusResponse)
            }
  ```


  - Get application balance. 
  ```kotlin
        val camPay = CamPay.getInstance()

        camPay.applicationBalance()
            .subscribe { applicationBalanceResponse ->
                println(applicationBalanceResponse)
            }
  ```


  - Place a withdrawal request

  > Please enable API withdrawal under app settings before trying this request
  
  ```kotlin
        val camPay = CamPay.getInstance()

        camPay.withdraw(
            WithdrawRequest.WithdrawRequestBuilder
                .aWithdrawRequest()
                .withTo("237XXXXXXXXX")
                .withExternalReference(UUID.randomUUID().toString())
                .withDescription("some reason")
                .withAmount("100")
                .build()
        )
            .subscribe { withdrawalResponse ->
                println(withdrawalResponse)
            }
  ```

## Deployment

Add additional notes about how to deploy this on a live system
Change the environment of the library introduction to PROD

  ```kotlin
        CamPay.init(
            "<username>",
            "<password>",
            CamPay.Environment.PROD // environment
        )
  ```

## Built With

  - [Retrofit](https://github.com/square/retrofit/) - A type-safe HTTP client for Android and Java.
  - [RxJava3](https://github.com/ReactiveX/RxJava/tree/3.x) - Reactive Extensions for the JVM

