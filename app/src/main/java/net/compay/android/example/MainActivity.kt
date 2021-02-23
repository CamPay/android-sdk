package net.compay.android.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.compay.android.CamPay
import net.compay.android.models.requests.CollectionRequest
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var camPay: CamPay
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CamPay.init(
            "fB3d9RAjievMcPpK7Mw5Fjwujq2LkX4nBYq8qfliEcjX5YvVdShM2dFVowA7C9tBgMpQ01NKHC3y5hT-i7mA5g",
            "Wl6xlplGQWOgBmh7GQNxYL2JQX5iX89_wGkf18edi5rY4PVMB6yLx7nUvM2z9JOVHLrzkrKFhhdazxWZGMtSZg",
            CamPay.Environment.DEV
        )

        camPay = CamPay.getInstance()

        camPay.collect(
            CollectionRequest.CollectionRequestBuilder
                .aCollectionRequest()
                .withAmount("100")
                .withFrom("237XXXXXXXXX")
                .withDescription("some reason")
                .withExternalReference(UUID.randomUUID().toString())
                .withCurrency("XAF")
                .build()
        ).delay(1, TimeUnit.MINUTES)
            .switchMap { collectResponse ->
                println(collectResponse)
                return@switchMap camPay.transactionStatus(collectResponse.reference)
            }.subscribe { transactionStatusResponse ->
                println(transactionStatusResponse)
            }
    }
}