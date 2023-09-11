package com.example.spinnerandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OutputActivity extends AppCompatActivity {
    private TextView shapeTextView;
    private TextView colorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);

        shapeTextView = findViewById(R.id.shapeTextView);
        colorTextView = findViewById(R.id.colorTextView);

        Intent intent = getIntent();
        String shape = intent.getStringExtra("shape");
        String color = intent.getStringExtra("color");

        shapeTextView.setText("Selected Shape: " + shape);
        colorTextView.setText("Selected Color: " + color);
    }
}