package net.compay.android.models.requests;

import com.google.gson.annotations.SerializedName;

/**
 * The type Withdraw request.
 */
public class WithdrawRequest {
    private String amount;
    private String to;
    private String description;
    @SerializedName("external_reference")
    private String externalReference;

    /**
     * Instantiates a new Withdraw request.
     */
    public WithdrawRequest() {
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * Gets to.
     *
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets to.
     *
     * @param to the to
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets external reference.
     *
     * @return the external reference
     */
    public String getExternalReference() {
        return externalReference;
    }

    /**
     * Sets external reference.
     *
     * @param externalReference the external reference
     */
    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }


    /**
     * The type Withdraw request builder.
     */
    public static final class WithdrawRequestBuilder {
        private String amount;
        private String to;
        private String description;
        private String externalReference;

        private WithdrawRequestBuilder() {
        }

        /**
         * A withdraw request withdraw request builder.
         *
         * @return the withdraw request builder
         */
        public static WithdrawRequestBuilder aWithdrawRequest() {
            return new WithdrawRequestBuilder();
        }

        /**
         * With amount withdraw request builder.
         *
         * @param amount the amount
         * @return the withdraw request builder
         */
        public WithdrawRequestBuilder withAmount(String amount) {
            this.amount = amount;
            return this;
        }

        /**
         * With to withdraw request builder.
         *
         * @param to the to
         * @return the withdraw request builder
         */
        public WithdrawRequestBuilder withTo(String to) {
            this.to = to;
            return this;
        }

        /**
         * With description withdraw request builder.
         *
         * @param description the description
         * @return the withdraw request builder
         */
        public WithdrawRequestBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * With external reference withdraw request builder.
         *
         * @param externalReference the external reference
         * @return the withdraw request builder
         */
        public WithdrawRequestBuilder withExternalReference(String externalReference) {
            this.externalReference = externalReference;
            return this;
        }

        /**
         * Build withdraw request.
         *
         * @return the withdraw request
         */
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
