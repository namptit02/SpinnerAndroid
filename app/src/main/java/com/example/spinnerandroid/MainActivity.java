package com.example.spinnerandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner shapeSpinner;
    private Spinner colorSpinner;
    private Button submitButton;

    private String selectedShape = "";
    private String selectedColor = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shapeSpinner = findViewById(R.id.shapeSpinner);
        colorSpinner = findViewById(R.id.colorSpinner);
        submitButton = findViewById(R.id.submitButton);


        shapeSpinner.setOnItemSelectedListener(this);
        colorSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> shapeAdapter = ArrayAdapter.createFromResource(
                this, R.array.shape_array, android.R.layout.simple_spinner_item);
        shapeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shapeSpinner.setAdapter(shapeAdapter);

        ArrayAdapter<CharSequence> colorAdapter = ArrayAdapter.createFromResource(
                this, R.array.color_array, android.R.layout.simple_spinner_item);
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(colorAdapter);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelectedShapeAndColor();
            }
        });
    }


    private void showSelectedShapeAndColor() {
        String shape = "";
        String color = "";

        if (!selectedShape.isEmpty() && !selectedColor.isEmpty()) {
            switch (selectedShape) {
                case "Triangle":
                    if (selectedColor.equals("Red") || selectedColor.equals("Blue")) {
                        shape = "Triangle";
                        color = selectedColor;
                    }
                    break;
                case "Circle":
                    if (selectedColor.equals("Blue") || selectedColor.equals("Green")) {
                        shape = "Circle";
                        color = selectedColor;
                    }
                    break;
                case "Square":
                    if (selectedColor.equals("Green") || selectedColor.equals("Pink")) {
                        shape = "Square";
                        color = selectedColor;
                    }
                    break;
                case "Rectangle":
                    if (selectedColor.equals("Pink") || selectedColor.equals("Yellow")) {
                        shape = "Rectangle";
                        color = selectedColor;
                    }
                    break;
                case "Oval":
                    if (selectedColor.equals("Yellow") || selectedColor.equals("Red")) {
                        shape = "Oval";
                        color = selectedColor;
                    }
                    break;
            }
        }

        Intent intent = new Intent(MainActivity.this, OutputActivity.class);
        intent.putExtra("shape", shape);
        intent.putExtra("color", color);
        startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent == shapeSpinner) {
            selectedShape = parent.getItemAtPosition(position).toString();
        } else if (parent == colorSpinner) {
            selectedColor = parent.getItemAtPosition(position).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }
}
//package com.example.spinnerandroid;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.Spinner;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
//
//    private Spinner shapeSpinner;
//    private Spinner colorSpinner;
//
//    private String selectedShape = "";
//    private String selectedColor = "";
//
//    private boolean isSelectionMade = false; // Biến kiểm tra đã chọn màu và hình dạng hay chưa
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        shapeSpinner = findViewById(R.id.shapeSpinner);
//        colorSpinner = findViewById(R.id.colorSpinner);
//
//        shapeSpinner.setOnItemSelectedListener(this);
//        colorSpinner.setOnItemSelectedListener(this);
//
//        ArrayAdapter<CharSequence> shapeAdapter = ArrayAdapter.createFromResource(
//                this, R.array.shape_array, android.R.layout.simple_spinner_item);
//        shapeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        shapeSpinner.setAdapter(shapeAdapter);
//
//        ArrayAdapter<CharSequence> colorAdapter = ArrayAdapter.createFromResource(
//                this, R.array.color_array, android.R.layout.simple_spinner_item);
//        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        colorSpinner.setAdapter(colorAdapter);
//    }
//
//    private void navigateToOutputActivity() {
//        if (isSelectionMade) {
//            String shape = "";
//            String color = "";
//
//            if (!selectedShape.isEmpty() && !selectedColor.isEmpty()) {
//                switch (selectedShape) {
//                    case "Triangle":
//                        if (selectedColor.equals("Red") || selectedColor.equals("Blue")) {
//                            shape = "Triangle";
//                            color = selectedColor;
//                        }
//                        break;
//                    case "Circle":
//                        if (selectedColor.equals("Blue") || selectedColor.equals("Green")) {
//                            shape = "Circle";
//                            color = selectedColor;
//                        }
//                        break;
//                    case "Square":
//                        if (selectedColor.equals("Green") || selectedColor.equals("Pink")) {
//                            shape = "Square";
//                            color = selectedColor;
//                        }
//                        break;
//                    case "Rectangle":
//                        if (selectedColor.equals("Pink") || selectedColor.equals("Yellow")) {
//                            shape = "Rectangle";
//                            color = selectedColor;
//                        }
//                        break;
//                    case "Oval":
//                        if (selectedColor.equals("Yellow") || selectedColor.equals("Red")) {
//                            shape = "Oval";
//                            color = selectedColor;
//                        }
//                        break;
//                }
//            }
//
//            Intent intent = new Intent(MainActivity.this, OutputActivity.class);
//            intent.putExtra("shape", shape);
//            intent.putExtra("color", color);
//            startActivity(intent);
//        }
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        if (parent == shapeSpinner) {
//            selectedShape = parent.getItemAtPosition(position).toString();
//        } else if (parent == colorSpinner) {
//            selectedColor = parent.getItemAtPosition(position).toString();
//        }
//
//
//        isSelectionMade = !selectedShape.isEmpty() && !selectedColor.isEmpty();
//
//
//        navigateToOutputActivity();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//        // Do nothing
//    }
//}
