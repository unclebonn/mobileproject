package com.example.endproject.api.Auth;

import com.example.endproject.api.Product.Product;

import java.util.List;

public class LoginResponseModel {
    private Login data;

    public LoginResponseModel(Login data) {
        this.data = data;
    }

    public Login getData() {
        return data;
    }

    public void setData(Login data) {
        this.data = data;
    }
}
