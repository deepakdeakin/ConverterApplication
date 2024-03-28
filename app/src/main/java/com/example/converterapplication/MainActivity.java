package com.example.converterapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerFromUnit, spinnerToUnit;
    private EditText editTextInputValue;
    private Button buttonConvert;
    private TextView textViewConvertedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFromUnit = findViewById(R.id.spinnerFromUnit);
        spinnerToUnit = findViewById(R.id.spinnerToUnit);
        editTextInputValue = findViewById(R.id.editTextInputValue);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewConvertedValue = findViewById(R.id.textViewConvertedValue);

        // Set up spinner adapters
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFromUnit.setAdapter(adapter);
        spinnerToUnit.setAdapter(adapter);

        // Set up button click listener
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertValue();
            }
        });
    }

    private void convertValue() {
        String inputValueStr = editTextInputValue.getText().toString().trim();
        if (inputValueStr.isEmpty()) {
            Toast.makeText(this, "Please enter a value to convert", Toast.LENGTH_SHORT).show();
            return;
        }

        double inputValue;
        try {
            inputValue = Double.parseDouble(inputValueStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input value", Toast.LENGTH_SHORT).show();
            return;
        }

        String fromUnit = spinnerFromUnit.getSelectedItem().toString();
        String toUnit = spinnerToUnit.getSelectedItem().toString();

        if (fromUnit.equals(toUnit)) {
            Toast.makeText(this, "Source and destination units are the same", Toast.LENGTH_SHORT).show();
            return;
        }

        double convertedValue;
        switch (fromUnit) {
            case "Inch":
            case "Foot":
            case "Yard":
            case "Mile":
                convertedValue = Converter.convertLength(this,inputValue, fromUnit, toUnit);
                break;
            case "Pound":
            case "Ounce":
            case "Ton":
            case "Kilogram":
            case "Gram":
                convertedValue = Converter.convertWeight(this,inputValue, fromUnit, toUnit);
                break;
            case "Celsius":
            case "Fahrenheit":
            case "Kelvin":
                convertedValue = Converter.convertTemperature(this, inputValue, fromUnit, toUnit);
               // convertedValue = Converter.convertTemperature(inputValue, fromUnit, toUnit);
                break;
            default:
                convertedValue = inputValue; // No conversion for unsupported units
        }

        textViewConvertedValue.setText(String.valueOf(convertedValue));
    }

}
