package com.example.endproject.api.Controllers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.endproject.api.Auth.ApiServiceLogin;
import com.example.endproject.api.Auth.Login;
import com.example.endproject.api.Auth.LoginRequestModel;
import com.example.endproject.api.Auth.LoginResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginController {

    public interface LoginCallBack {
        void onLoginSuccess(String token );
    }


    //api này dùng để đăng nhập, chỗ này truyền uid trên firebase xuống nha
    public void callApiLogin(String uid, LoginCallBack callBack) {
        LoginRequestModel requestBody = new LoginRequestModel(uid);
        ApiServiceLogin.API_SERVICE_LOGIN.login(requestBody).enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                if (response.isSuccessful()) {
                    LoginResponseModel data = response.body();
                    Login loginData = data.getData();
                    if (loginData != null) {
                        callBack.onLoginSuccess(loginData.getToken());
                    }


                }

            }

            @Override
            public void onFailure(Call<LoginResponseModel> call, Throwable t) {
                Log.d("failed", "onFailure: " + t.getCause());
            }
        });
    }
}
