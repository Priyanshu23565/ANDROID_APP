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

    private Spinner spinnerTableRange;
    private EditText etNumber;
    private Button btnGenerate;
    private TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        spinnerTableRange = findViewById(R.id.spinnerTableRange);
        etNumber = findViewById(R.id.etNumber);
        btnGenerate = findViewById(R.id.btnGenerate);
        tvResults = findViewById(R.id.tvResults);

        // Setup dropdown options
        String[] ranges = {"10", "15", "20", "25", "30"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                ranges
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTableRange.setAdapter(adapter);

        // Generate table on button click
        btnGenerate.setOnClickListener(v -> {
            try {
                String numberStr = etNumber.getText().toString();
                if (numberStr.isEmpty()) {
                    Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }

                int number = Integer.parseInt(numberStr);
                int range = Integer.parseInt(spinnerTableRange.getSelectedItem().toString());

                StringBuilder table = new StringBuilder();
                for (int i = 1; i <= range; i++) {
                    table.append(number)
                            .append(" × ")
                            .append(i)
                            .append(" = ")
                            .append(number * i)
                            .append("\n");
                }

                tvResults.setText(table.toString());
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();
            }
        });
    }
}