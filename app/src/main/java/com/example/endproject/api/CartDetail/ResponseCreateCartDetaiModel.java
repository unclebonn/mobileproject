package com.example.endproject.api.CartDetail;

public class ResponseCreateCartDetaiModel {
    private CartDetail data;

    public ResponseCreateCartDetaiModel(CartDetail data) {
        this.data = data;
    }

    public CartDetail getData() {
        return data;
    }

    public void setData(CartDetail data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseCreateCartDetaiModel{" +
                "data=" + data +
                '}';
    }
}


