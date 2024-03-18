package com.example.endproject.ui.detail;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.endproject.R;
import com.example.endproject.api.Product.Product;

public class DetailActivity extends AppCompatActivity {
    Button buttonPlus, buttonMinus;
    TextView textViewNumber;
    Product product;
    int imageId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Initialize views
        buttonPlus = findViewById(R.id.plus);
        buttonMinus = findViewById(R.id.minus);
        textViewNumber = findViewById(R.id.text_view_number);

        // Get the product data from the intent
        product = (Product) getIntent().getSerializableExtra("product");
        imageId = getIntent().getIntExtra("imageId", 0);

        // Display product details
        if (product != null) {
            displayProductDetails();
        }

        // Set onClickListeners for buttons
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plus(v);
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minus(v);
            }
        });
    }

    private void displayProductDetails() {
        TextView title,price,description;
        ImageView imageView;

        imageView = findViewById(R.id.detail_image);
        title = findViewById(R.id.detail_title);
        price = findViewById(R.id.detail_price);
        description = findViewById(R.id.detail_description);

        title.setText(product.getName());
        price.setText("Price: $" + product.getPrice());
        description.setText(product.getDescription());
        if (imageId != 0) {
            imageView.setImageResource(imageId);
        } else {
            Log.d("DetailActivity", "Image ID is 0");
        }
    }

    public void plus(View view) {
        int currentValue = Integer.parseInt(textViewNumber.getText().toString());
        currentValue++;
        textViewNumber.setText(String.valueOf(currentValue));
    }

    public void minus(View view) {
        int currentValue = Integer.parseInt(textViewNumber.getText().toString());
        if (currentValue > 0) {
            currentValue--;
            textViewNumber.setText(String.valueOf(currentValue));
        }
    }
}
