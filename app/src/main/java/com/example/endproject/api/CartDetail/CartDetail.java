package com.example.endproject.api.CartDetail;

import com.example.endproject.api.Product.Product;
import com.google.gson.annotations.SerializedName;

public class CartDetail {

    @SerializedName("_id")
    private String _id;
    @SerializedName("product")

    private Product product;
    @SerializedName("quantity")

    private int quantity;
    @SerializedName("cart")

    private String cart;
    @SerializedName("__v")

    private int __v;


    public CartDetail(String _id, Product product, int quantity, String cart, int __v) {
        this._id = _id;
        this.product = product;
        this.quantity = quantity;
        this.cart = cart;
        this.__v = __v;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    @Override
    public String toString() {
        return "CartDetail{" +
                "_id='" + _id + '\'' +
                ", product=" + product +
                ", quantity=" + quantity +
                ", cart='" + cart + '\'' +
                ", __v=" + __v +
                '}';
    }
}
