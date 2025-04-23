package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerOperation;
    private EditText etNumber, etRange;
    private Button btnGenerate;
    private TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        spinnerOperation = findViewById(R.id.spinnerOperation);
        etNumber = findViewById(R.id.etNumber);
        etRange = findViewById(R.id.etRange);
        btnGenerate = findViewById(R.id.btnGenerate);
        tvResults = findViewById(R.id.tvResults);

        // Dropdown Options
        String[] operations = {"Square", "Cube", "Multiplication Table"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOperation.setAdapter(adapter);

        // Generate Button Click
        btnGenerate.setOnClickListener(v -> {
            try {
                String numberText = etNumber.getText().toString();
                String rangeText = etRange.getText().toString();
                String operation = spinnerOperation.getSelectedItem().toString();

                if (numberText.isEmpty()) {
                    Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }

                int startNumber = Integer.parseInt(numberText);
                StringBuilder result = new StringBuilder();

                switch (operation) {
                    case "Square":
                        if (rangeText.isEmpty()) {
                            // Single square
                            result.append("Square of ").append(startNumber).append(": ")
                                    .append(startNumber * startNumber);
                        } else {
                            // Square from startNumber to (startNumber + range - 1)
                            int range = Integer.parseInt(rangeText);
                            int endNumber = startNumber + range - 1;
                            for (int i = startNumber; i <= endNumber; i++) {
                                result.append("Square of ").append(i).append(": ")
                                        .append(i * i).append("\n");
                            }
                        }
                        break;

                    case "Cube":
                        if (rangeText.isEmpty()) {
                            // Single cube
                            result.append("Cube of ").append(startNumber).append(": ")
                                    .append(startNumber * startNumber * startNumber);
                        } else {
                            // Cube from startNumber to (startNumber + range - 1)
                            int range = Integer.parseInt(rangeText);
                            int endNumber = startNumber + range - 1;
                            for (int i = startNumber; i <= endNumber; i++) {
                                result.append("Cube of ").append(i).append(": ")
                                        .append(i * i * i).append("\n");
                            }
                        }
                        break;

                    case "Multiplication Table":
                        if (rangeText.isEmpty()) {
                            Toast.makeText(this, "Please enter range", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        int range = Integer.parseInt(rangeText);
                        for (int i = 1; i <= range; i++) {
                            result.append(startNumber).append(" × ").append(i).append(" = ")
                                    .append(startNumber * i).append("\n");
                        }
                        break;
                }

                tvResults.setText(result.toString());

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid number/range", Toast.LENGTH_SHORT).show();
            }
        });
    }
}