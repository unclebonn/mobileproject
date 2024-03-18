package com.example.endproject.paypal;

import android.app.Application;

import com.paypal.checkout.PayPalCheckout;
import com.paypal.checkout.config.CheckoutConfig;
import com.paypal.checkout.config.Environment;
import com.paypal.checkout.createorder.CurrencyCode;
import com.paypal.checkout.createorder.UserAction;
import com.paypal.pyplcheckout.BuildConfig;

public class AppPaypal extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PayPalCheckout.setConfig(new CheckoutConfig(
                this,
                "AVDRF3pRHq-B5ZNvcnP6rI6DPheNbEsMx3_cH64UA_a4CX5GCgHjfc7QngkkSkX6GLaEE9NRzbe4paKg",
                Environment.SANDBOX,
                CurrencyCode.USD,
                UserAction.PAY_NOW,
                "com.devkhoi.paypaltest://paypalpay"
        ));
    }
}
