package net.compay.android;

import net.compay.android.models.ApplicationBalanceResponse;
import net.compay.android.models.PaymentRequestResponse;
import net.compay.android.models.Token;
import net.compay.android.models.TransactionStatusResponse;
import net.compay.android.models.WithdrawalResponse;
import net.compay.android.models.requests.CollectionRequest;
import net.compay.android.models.requests.TokenRequest;
import net.compay.android.models.requests.WithdrawRequest;
import net.compay.android.services.RestServices;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CamPay {

    private static CamPay camPayInstance;
    private final String username;
    private final String password;
    private RestServices restService;


    private CamPay(String username, String password, Environment environment) {
        this.username = username;
        this.password = password;
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(environment == Environment.PROD ? "https://campay.net/" : "https://demo.campay.net/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        this.restService = retrofit.create(RestServices.class);
    }

    public static CamPay init(String username, String password, Environment environment) {
        if (camPayInstance == null) {
            camPayInstance = new CamPay(username, password, environment);
        }
        return camPayInstance;
    }

    public static CamPay getInstance() {
        return camPayInstance;
    }

    public @NonNull Observable<PaymentRequestResponse> collect(@NonNull CollectionRequest request) {
        return this.getToken()
                .switchMap(token -> restService.collect(
                        request, "Token " + token.getToken()));
    }

    public @NonNull Observable<TransactionStatusResponse> transactionStatus(@NonNull String transactionId) {
        return this.getToken()
                .switchMap(token -> restService.transactionStatus(
                        transactionId, "Token " + token.getToken()));
    }

    public @NonNull Observable<WithdrawalResponse> withdraw(@NonNull WithdrawRequest withdrawRequest) {
        return this.getToken()
                .switchMap(token -> restService.withdraw(
                        withdrawRequest, "Token " + token.getToken()));
    }

    public @NonNull Observable<ApplicationBalanceResponse> applicationBalance() {
        return this.getToken()
                .switchMap(token -> restService.applicationBalance(
                        "Token " + token.getToken()));
    }

    private Observable<Token> getToken() {
        return restService.retrieveToken(
                TokenRequest.TokenRequestBuilder
                        .aTokenRequest()
                        .withPassword(password)
                        .withUsername(username)
                        .build()
        );
    }

    public enum Environment {
        DEV, PROD
    }
}