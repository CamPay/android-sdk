# [CamPay](https://www.campay.net/) Android SDK

One Paragraph of project description goes here


![Android CI](https://github.com/CamPay/android-sdk/workflows/Android%20CI/badge.svg)


## Summary

  - [Getting Started](#getting-started)
  - [Running the samples](#running-the-samples)
  - [Deployment](#deployment)
  - [Built With](#built-with)

## Getting Started

These instructions will get you a copy of the project up and running on
your local machine for development and testing purposes. See deployment
for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them
 - An account on [CamPay](https://www.campay.net/) platform
 - An application on the CamOay platform.
 - Credentials for connecting to the CamPay platform

### Installing

A step by step series of examples that tell you how to get a development
env running

```groovy
    implementation 'net.campay:android-sdk-debug:{latest_version}'
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
        ).delay(1, TimeUnit.MINUTES)
            .switchMap { collectResponse ->
                println(collectResponse)
                return@switchMap camPay.transactionStatus(collectResponse.reference);
            }.subscribe { transactionStatusResponse ->
                println(transactionStatusResponse)
            }
  ```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

  - [Retrofit](https://github.com/square/retrofit/) - A type-safe HTTP client for Android and Java.

## Acknowledgments

  - 