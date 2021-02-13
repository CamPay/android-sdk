package net.compay.android.models;

import com.google.gson.annotations.SerializedName;

public class TransactionStatusResponse {
    private String reference;
    private String status;
    private int amount;
    private String currency;
    private String operator;
    private String code;
    @SerializedName("operator_reference")
    private String operatorReference;

    public TransactionStatusResponse() {
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperatorReference() {
        return operatorReference;
    }

    public void setOperatorReference(String operatorReference) {
        this.operatorReference = operatorReference;
    }

    @Override
    public String toString() {
        return "TransactionStatusResponse{" +
                "reference='" + reference + '\'' +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", operator='" + operator + '\'' +
                ", code='" + code + '\'' +
                ", operatorReference='" + operatorReference + '\'' +
                '}';
    }
}
