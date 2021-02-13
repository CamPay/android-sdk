package net.compay.android.models;

import com.google.gson.annotations.SerializedName;

public class PaymentRequestResponse {
    private String reference;
    @SerializedName("ussd_code")
    private String ussdCode;
    private String operator;

    public PaymentRequestResponse() {
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getUssdCode() {
        return ussdCode;
    }

    public void setUssdCode(String ussdCode) {
        this.ussdCode = ussdCode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "PaymentRequestResponse{" +
                "reference='" + reference + '\'' +
                ", ussdCode='" + ussdCode + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
