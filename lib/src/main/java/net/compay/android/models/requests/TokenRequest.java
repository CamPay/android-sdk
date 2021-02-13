package net.compay.android.models.requests;

public class TokenRequest {
    private String username;
    private String password;

    public TokenRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static final class TokenRequestBuilder {
        private String username;
        private String password;

        private TokenRequestBuilder() {
        }

        public static TokenRequestBuilder aTokenRequest() {
            return new TokenRequestBuilder();
        }

        public TokenRequestBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public TokenRequestBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public TokenRequest build() {
            TokenRequest tokenRequest = new TokenRequest();
            tokenRequest.setUsername(username);
            tokenRequest.setPassword(password);
            return tokenRequest;
        }
    }
}
