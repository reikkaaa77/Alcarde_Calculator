package com.example.alcarde_calculator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputText;

    private double firstNumber = 0;
    private String operator = "";
    private boolean isNewCalculation = true;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.input_text);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);

        Button buttonAdd = findViewById(R.id.button_add);
        Button buttonSubtract = findViewById(R.id.button_subtract);
        Button buttonMultiply = findViewById(R.id.button_multiply);
        Button buttonDivide = findViewById(R.id.button_divide);
        Button buttonEquals = findViewById(R.id.button_equals);
        Button buttonClear = findViewById(R.id.button_clear);

        @SuppressLint("SetTextI18n") View.OnClickListener numberClickListener = v -> {
            if (isNewCalculation) {
                inputText.setText("");
                isNewCalculation = false;
            }

            Button button = (Button) v;
            String currentInput = inputText.getText().toString();
            String digit = button.getText().toString();
            inputText.setText(currentInput + digit);
        };

        button0.setOnClickListener(numberClickListener);
        button1.setOnClickListener(numberClickListener);
        button2.setOnClickListener(numberClickListener);
        button3.setOnClickListener(numberClickListener);
        button4.setOnClickListener(numberClickListener);
        button5.setOnClickListener(numberClickListener);
        button6.setOnClickListener(numberClickListener);
        button7.setOnClickListener(numberClickListener);
        button8.setOnClickListener(numberClickListener);
        button9.setOnClickListener(numberClickListener);

        buttonAdd.setOnClickListener(v -> {
            performCalculation();
            operator = "+";
        });

        buttonSubtract.setOnClickListener(v -> {
            performCalculation();
            operator = "-";
        });

        buttonMultiply.setOnClickListener(v -> {
            performCalculation();
            operator = "*";
        });

        buttonDivide.setOnClickListener(v -> {
            performCalculation();
            operator = "/";
        });

        buttonEquals.setOnClickListener(v -> {
            performCalculation();
            operator = "";
            isNewCalculation = true;
        });

        buttonClear.setOnClickListener(v -> {
            inputText.setText("");
            firstNumber = 0;
            operator = "";
            isNewCalculation = true;
        });
    }

    private void performCalculation() {
        if (operator.isEmpty()) {
            firstNumber = Double.parseDouble(inputText.getText().toString());
        } else {
            double secondNumber = Double.parseDouble(inputText.getText().toString());
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    }  // Handle division by zero error
                    // You can display an error message or take appropriate action here

                    break;
            }

            inputText.setText(String.valueOf(result));
            firstNumber = result;
        }
    }
}