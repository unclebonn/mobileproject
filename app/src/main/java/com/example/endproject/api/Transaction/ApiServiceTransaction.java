package com.example.endproject.api.Transaction;

import com.example.endproject.api.Product.ApiServiceProduct;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiServiceTransaction {

    Gson gson = new GsonBuilder().setDateFormat("dd--MM-yyy").create();
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    ApiServiceProduct API_SERVICE_PRODUCT = new Retrofit.Builder()
            .baseUrl("http://192.168.102.4:3000/")
            .addConverterFactory((GsonConverterFactory.create(gson)))
            .client(httpClient.build())
            .build()
            .create(ApiServiceProduct.class);


    @POST("api/transaction")
    Call<TransactionResponseModel> BoughtItems(@Header("x-access-token") String token , @Body TransactionRequestModel TransactionRequestModel);
}
