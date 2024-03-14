package com.example.endproject.api.CartDetail;

import com.example.endproject.api.Customer.Customer;

import java.util.List;

public class ResponseCartDetailModel {
    private Customer customer;
    private List<CartDetail> data;

    public Customer getCustomer() {
        return customer;
    }

    public List<CartDetail> getData() {
        return data;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setData(List<CartDetail> data) {
        this.data = data;
    }
}
