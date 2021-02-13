package net.compay.android.models;

public class Token {
    private String token;
    private int expiresIn;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "Token [ " +
                "token : '" + token + '\'' +
                ", expiresIn : " + expiresIn +
                ']';
    }
}
