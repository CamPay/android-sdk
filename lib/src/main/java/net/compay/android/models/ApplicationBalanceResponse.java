package net.compay.android.models;

import com.google.gson.annotations.SerializedName;

/**
 * The type Application balance response.
 */
public class ApplicationBalanceResponse {
    @SerializedName("total_balance")
    private int totalBalance;

    @SerializedName("mtn_balance")
    private int mtnBalance;

    @SerializedName("orange_balance")
    private int orangeBalance;

    private String currency;

    /**
     * Gets total balance.
     *
     * @return the total balance
     */
    public int getTotalBalance() {
        return totalBalance;
    }

    /**
     * Sets total balance.
     *
     * @param totalBalance the total balance
     */
    public void setTotalBalance(int totalBalance) {
        this.totalBalance = totalBalance;
    }

    /**
     * Gets mtn balance.
     *
     * @return the mtn balance
     */
    public int getMtnBalance() {
        return mtnBalance;
    }

    /**
     * Sets mtn balance.
     *
     * @param mtnBalance the mtn balance
     */
    public void setMtnBalance(int mtnBalance) {
        this.mtnBalance = mtnBalance;
    }

    /**
     * Gets orange balance.
     *
     * @return the orange balance
     */
    public int getOrangeBalance() {
        return orangeBalance;
    }

    /**
     * Sets orange balance.
     *
     * @param orangeBalance the orange balance
     */
    public void setOrangeBalance(int orangeBalance) {
        this.orangeBalance = orangeBalance;
    }

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets currency.
     *
     * @param currency the currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
