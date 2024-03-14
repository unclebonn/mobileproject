package com.example.endproject.api.Controllers;

import com.example.endproject.api.Cart.ApiServiceCart;
import com.example.endproject.api.Cart.Cart;
import com.example.endproject.api.Cart.ResponseCartModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartController {

    public interface CartDetailCallBack {
        void onSuccessGetCart(Cart cart);

        void onFailedGetCart(String msgFailed);
    }


    // api dùng để lấy id giỏ hàng của người dùng
    public void callApiGetCart(String token, String customerId, CartDetailCallBack cartDetailCallBack) {
        ApiServiceCart.API_SERVICE_CART.getCart(token, customerId).enqueue(new Callback<ResponseCartModel>() {
            @Override
            public void onResponse(Call<ResponseCartModel> call, Response<ResponseCartModel> response) {
                if(response.isSuccessful()){
                    ResponseCartModel cartModel = response.body();
                    Cart cart = cartModel.getData();
                    if(cart != null){
                        cartDetailCallBack.onSuccessGetCart(cart);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseCartModel> call, Throwable t) {

            }
        });
    }
}
