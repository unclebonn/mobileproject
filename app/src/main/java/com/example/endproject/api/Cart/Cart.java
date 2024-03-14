package com.example.endproject.api.Cart;

import com.example.endproject.api.Customer.Customer;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Cart {
    @SerializedName("_id")

    private String _id;
    @SerializedName("customer")
    private Customer customer;
    @SerializedName("createAt")
    private Date createAt;
    @SerializedName("__v")

    private int __v;

    public Cart(String _id, Customer customer, Date createAt, int __v) {
        this._id = _id;
        this.customer = customer;
        this.createAt = createAt;
        this.__v = __v;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "_id='" + _id + '\'' +
                ", customer=" + customer +
                ", createAt=" + createAt +
                ", __v=" + __v +
                '}';
    }
}
