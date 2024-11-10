package com.example.kalkulatormodul2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2, resultView;
    private Button addButton, subtractButton, multiplyButton, divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        editText1 = findViewById(R.id.editTextText);
        editText2 = findViewById(R.id.editTextText2);
        resultView = findViewById(R.id.editTextText3);

        addButton = findViewById(R.id.button);
        subtractButton = findViewById(R.id.button2);
        multiplyButton = findViewById(R.id.button3);
        divideButton = findViewById(R.id.button4);

        // Set button click listeners
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
    }

    private void calculate(char operator) {
        String num1Str = editText1.getText().toString();
        String num2Str = editText2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Masukkan kedua angka!", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    Toast.makeText(this, "Pembagian dengan nol tidak diperbolehkan!", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }

        resultView.setText(String.valueOf(result));
    }
}
