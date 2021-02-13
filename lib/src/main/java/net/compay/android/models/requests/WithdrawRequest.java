package net.compay.android.models.requests;

import com.google.gson.annotations.SerializedName;

public class WithdrawRequest {
    private String amount;
    private String to;
    private String description;
    @SerializedName("external_reference")
    private String externalReference;

    public WithdrawRequest() {
    }

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


    public static final class WithdrawRequestBuilder {
        private String amount;
        private String to;
        private String description;
        private String externalReference;

        private WithdrawRequestBuilder() {
        }

        public static WithdrawRequestBuilder aWithdrawRequest() {
            return new WithdrawRequestBuilder();
        }

        public WithdrawRequestBuilder withAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public WithdrawRequestBuilder withTo(String to) {
            this.to = to;
            return this;
        }

        public WithdrawRequestBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public WithdrawRequestBuilder withExternalReference(String externalReference) {
            this.externalReference = externalReference;
            return this;
        }

        public WithdrawRequest build() {
            WithdrawRequest withdrawRequest = new WithdrawRequest();
            withdrawRequest.setAmount(amount);
            withdrawRequest.setTo(to);
            withdrawRequest.setDescription(description);
            withdrawRequest.setExternalReference(externalReference);
            return withdrawRequest;
        }
    }
}
