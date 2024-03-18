package com.example.endproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.endproject.api.Cart.Cart;
import com.example.endproject.api.CartDetail.ApiServiceCartDetail;
import com.example.endproject.api.CartDetail.CartDetail;
import com.example.endproject.api.CartDetail.RequestCartDetailModel;
import com.example.endproject.api.Controllers.CartController;
import com.example.endproject.api.Controllers.CartDetailController;
import com.example.endproject.api.Controllers.CustomerController;
import com.example.endproject.api.Controllers.LoginController;
import com.example.endproject.api.Customer.Customer;
import com.example.endproject.api.Customer.RequestCustomerModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.endproject.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_shop, R.id.navigation_more)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);



    }


}