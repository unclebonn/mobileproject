package com.example.endproject.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.endproject.R;

public class DetailActivity extends AppCompatActivity {
    Button buttonPlus, buttonMinus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        buttonPlus = findViewById(R.id.plus);
        buttonMinus = findViewById(R.id.minus);
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

    public void plus(View view) {
        TextView textView = findViewById(R.id.text_view_number);
        int currentValue = Integer.parseInt(textView.getText().toString());
        currentValue++;
        textView.setText(String.valueOf(currentValue));
    }

    public void minus(View view) {
        TextView textView = findViewById(R.id.text_view_number);
        int currentValue = Integer.parseInt(textView.getText().toString());
        if (currentValue > 0) {
            currentValue--;
            textView.setText(String.valueOf(currentValue));
        }
    }
}
