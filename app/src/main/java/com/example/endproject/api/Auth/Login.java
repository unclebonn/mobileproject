package com.example.endproject.api.Auth;

import com.google.gson.annotations.SerializedName;

public class Login {
    @SerializedName("success")
    Boolean success;
    @SerializedName("token")
    String token;
    @SerializedName("message")
    String message;

    public Login(Boolean success, String token, String message) {
        this.success = success;
        this.token = token;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Login{" +
                "success=" + success +
                ", token='" + token + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
