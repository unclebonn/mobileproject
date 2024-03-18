package com.example.endproject.api.Cart;

import com.google.gson.annotations.SerializedName;

public class RequestCartModel {

    private String customer;


    public RequestCartModel(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "RequestCartModel{" +
                "customer='" + customer + '\'' +
                '}';
    }
}
