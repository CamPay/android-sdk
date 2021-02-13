package net.compay.android.models;

import com.google.gson.annotations.SerializedName;

public class ApplicationBalanceResponse {
    @SerializedName("total_balance")
    private int totalBalance;
    @SerializedName("mtn_balance")
    private int mtnBalance;
    @SerializedName("orange_balance")
    private int orangeBalance;
    private String currency;

    public ApplicationBalanceResponse() {
    }

    public int getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(int totalBalance) {
        this.totalBalance = totalBalance;
    }

    public int getMtnBalance() {
        return mtnBalance;
    }

    public void setMtnBalance(int mtnBalance) {
        this.mtnBalance = mtnBalance;
    }

    public int getOrangeBalance() {
        return orangeBalance;
    }

    public void setOrangeBalance(int orangeBalance) {
        this.orangeBalance = orangeBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
