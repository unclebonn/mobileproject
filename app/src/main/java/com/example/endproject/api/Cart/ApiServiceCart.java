package com.example.endproject.api.Cart;

import com.example.endproject.api.Auth.ApiServiceLogin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface ApiServiceCart {

    Gson gson = new GsonBuilder().setDateFormat("dd--MM-yyy").create();
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    ApiServiceCart API_SERVICE_CART = new Retrofit.Builder()
            .baseUrl("http://192.168.102.4:3000/")
            .addConverterFactory((GsonConverterFactory.create(gson)))
            .client(httpClient.build())
            .build()
            .create(ApiServiceCart.class);


    @GET("api/cart/{cartId}")
    Call<ResponseCartModel> getCart (@Header("x-access-token")String token,  @Path("cartId") String customerId);
}
