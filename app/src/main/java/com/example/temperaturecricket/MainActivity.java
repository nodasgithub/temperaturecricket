package com.example.temperaturecricket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber;
    private Button btnCalculate;
    private TextView tvResults;
    private DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResults = findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);

        formatter = new DecimalFormat("#0.0");

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etNumber.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.caution, Toast.LENGTH_SHORT).show();
                } else {
                    int number = Integer.parseInt(etNumber.getText().toString().trim());

                    double degree = number / 3.0 + 4;

                    String text =
                            getString(R.string.explanation_first_half) + "\n" +
                                    formatter.format(degree) + " " +
                                    getString(R.string.explanation_second_half);

                    tvResults.setText(text);

                    tvResults.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}