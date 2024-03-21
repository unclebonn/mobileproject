package com.example.endproject.ui.cartDetail;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.endproject.R;
import com.example.endproject.api.CartDetail.CartDetail;
import com.example.endproject.api.Controllers.CartDetailController;
import com.paypal.checkout.approve.Approval;
import com.paypal.checkout.approve.OnApprove;
import com.paypal.checkout.createorder.CreateOrder;
import com.paypal.checkout.createorder.CreateOrderActions;
import com.paypal.checkout.createorder.CurrencyCode;
import com.paypal.checkout.createorder.OrderIntent;
import com.paypal.checkout.createorder.UserAction;
import com.paypal.checkout.order.Amount;
import com.paypal.checkout.order.AppContext;
import com.paypal.checkout.order.CaptureOrderResult;
import com.paypal.checkout.order.OnCaptureComplete;
import com.paypal.checkout.order.OrderRequest;
import com.paypal.checkout.order.PurchaseUnit;
import com.paypal.checkout.paymentbutton.PaymentButtonContainer;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class CartDetailActivity extends AppCompatActivity {

    ListView cartDetailLv;

    CartDetailAdapter adapter;

    ArrayList<CartDetail> cartDetailArrayList;

    String token;
    String customerId;
    PaymentButtonContainer paymentButtonContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartdetail);


        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        token = sharedPreferences.getString("token", "");
        customerId = sharedPreferences.getString("customerId", "");


        //////////////////////////////
        paymentButtonContainer = findViewById(R.id.payment_button_container);




///////////////////////////////
        cartDetailLv = (ListView) findViewById(R.id.horizontal_recycler_view_cart_detail);
        cartDetailArrayList = new ArrayList<>();
        adapter = new CartDetailAdapter(CartDetailActivity.this, R.layout.rvcart_item, cartDetailArrayList);
        cartDetailLv.setAdapter(adapter);
//
        getCartDetailFromCustomer();

        paymentButtonContainer.setup(
                new CreateOrder() {
                    @Override
                    public void create(@NotNull CreateOrderActions createOrderActions) {
                        ArrayList<PurchaseUnit> purchaseUnits = new ArrayList<>();
                        int totalAmount = sharedPreferences.getInt("totalAmount",0);
                        purchaseUnits.add(
                                new PurchaseUnit.Builder()
                                        .amount(
                                                new Amount.Builder()
                                                        .currencyCode(CurrencyCode.USD)
                                                        .value("23.23")
                                                        .build()
                                        )
                                        .build()
                        );
                        OrderRequest order = new OrderRequest(
                                OrderIntent.CAPTURE,
                                new AppContext.Builder()
                                        .userAction(UserAction.PAY_NOW)
                                        .build(),
                                purchaseUnits
                        );
                        createOrderActions.create(order, (CreateOrderActions.OnOrderCreated) null);
                    }
                },
                new OnApprove() {
                    @Override
                    public void onApprove(@NotNull Approval approval) {
                        approval.getOrderActions().capture(new OnCaptureComplete() {
                            @Override
                            public void onCaptureComplete(@NotNull CaptureOrderResult result) {
                                Log.i("CaptureOrder", String.format("CaptureOrderResult: %s", result));
                            }
                        });
                    }
                }
        );

    }


    public void getCartDetailFromCustomer() {
        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);

        final int[] totalAmount = {0};
        CartDetailController cartDetailController = new CartDetailController();
        cartDetailController.callApiGetCartDetailById(token, customerId, new CartDetailController.CartDetailCallBack() {
            @Override
            public void onGetCartDetailSuccess(List<CartDetail> cartDetail) {
                Toast.makeText(CartDetailActivity.this, "Get cart detail", Toast.LENGTH_SHORT).show();
                for (CartDetail detail : cartDetail) {
                    Log.d("priceeeeeee", "onGetCartDetailSuccess: " + detail.getProduct().getPrice());
                    totalAmount[0] += detail.getProduct().getPrice();
                    cartDetailArrayList.add(detail);
                }

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("totalAmount", totalAmount[0]);
                editor.apply();


                Log.d("totalAmount", "onCreate: " + totalAmount[0]);

                adapter.notifyDataSetChanged();


            }

            @Override
            public void onGetCartDetailFailed(String msgFailed) {

            }
        });



    }


}
