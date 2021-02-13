package net.compay.android.models.requests;

import com.google.gson.annotations.SerializedName;

public class CollectionRequest {
    private String amount;
    private String from;
    private String description;
    private String currency;
    @SerializedName("external_reference")
    private String externalReference;

    private CollectionRequest() {
    }


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public static final class CollectionRequestBuilder {
        private String amount;
        private String from;
        private String description;
        private String currency;
        private String externalReference;

        private CollectionRequestBuilder() {
        }

        public static CollectionRequestBuilder aCollectionRequest() {
            return new CollectionRequestBuilder();
        }

        public CollectionRequestBuilder withAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public CollectionRequestBuilder withFrom(String from) {
            this.from = from;
            return this;
        }

        public CollectionRequestBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public CollectionRequestBuilder withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public CollectionRequestBuilder withExternalReference(String externalReference) {
            this.externalReference = externalReference;
            return this;
        }

        public CollectionRequest build() {
            CollectionRequest collectionRequest = new CollectionRequest();
            collectionRequest.setAmount(amount);
            collectionRequest.setFrom(from);
            collectionRequest.setDescription(description);
            collectionRequest.setCurrency(currency);
            collectionRequest.setExternalReference(externalReference);
            return collectionRequest;
        }
    }
}
