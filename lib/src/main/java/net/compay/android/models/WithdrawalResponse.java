package net.compay.android.models;

import com.google.gson.annotations.SerializedName;

public class WithdrawalResponse {
    private String amount;
    private String to;
    private String description;
    @SerializedName("external_reference")
    private String externalReference;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    @Override
    public String toString() {
        return "WithdrawalResponse{" +
                "amount='" + amount + '\'' +
                ", to='" + to + '\'' +
                ", description='" + description + '\'' +
                ", externalReference='" + externalReference + '\'' +
                '}';
    }
}
