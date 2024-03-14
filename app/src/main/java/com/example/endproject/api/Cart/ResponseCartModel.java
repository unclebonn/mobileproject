package com.example.endproject.api.Cart;

public class ResponseCartModel {
    private Cart data;

    public ResponseCartModel(Cart data) {
        this.data = data;
    }

    public Cart getData() {
        return data;
    }

    public void setData(Cart data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseCartModel{" +
                "data=" + data +
                '}';
    }
}
