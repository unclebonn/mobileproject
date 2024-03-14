package com.example.endproject.api.Transaction;

import java.util.Date;

public class Transaction {
    private String _id;
    private Date createAt;

    private String customer;
    private String cart;
    private double totalAmount;


    public Transaction(String _id, Date createAt, String customer, String cart, double totalAmount) {
        this._id = _id;
        this.createAt = createAt;
        this.customer = customer;
        this.cart = cart;
        this.totalAmount = totalAmount;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "_id='" + _id + '\'' +
                ", createAt=" + createAt +
                ", customer='" + customer + '\'' +
                ", cart='" + cart + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}


