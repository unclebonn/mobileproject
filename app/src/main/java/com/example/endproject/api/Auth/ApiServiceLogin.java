package com.example.endproject.api.Auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServiceLogin {
    Gson gson = new GsonBuilder().setDateFormat("dd--MM-yyy").create();
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    ApiServiceLogin API_SERVICE_LOGIN = new Retrofit.Builder()
            .baseUrl("http://10.86.28.22:3000/")
            .addConverterFactory((GsonConverterFactory.create(gson)))
            .client(httpClient.build())
            .build()
            .create(ApiServiceLogin.class);


    // chỗ này truyền vào uid trên firebase
    @POST("api/login")
    Call<LoginResponseModel> login(@Body LoginRequestModel uid);
}
