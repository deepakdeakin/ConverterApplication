package com.example.converterapplication;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Converter {



    // Length Conversions
    public static double convertLength(Context context,double value, String sourceUnit, String destUnit) {
        if (value <= 0) {
            throw new IllegalArgumentException("Input value must be positive");
        }

        switch (sourceUnit) {
            case "Inch":
                switch (destUnit) {
                    case "Centimeter":
                        return value * 2.54;
                    case "Foot":
                        return value / 12.0;
                    case "Yard":
                        return value / 36.0;
                    case "Mile":
                        return value / 63360.0;
                    default:
                        return unsupportedConversion(context, value, sourceUnit, destUnit);
                }
            case "Foot":
                switch (destUnit) {
                    case "Inch":
                        return value * 12.0;
                    case "Centimeter":
                        return value * 30.48;
                    case "Yard":
                        return value / 3.0;
                    case "Mile":
                        return value / 5280.0;
                    default:
                        return unsupportedConversion(context, value, sourceUnit, destUnit);
                }
            case "Yard":
                switch (destUnit) {
                    case "Inch":
                        return value * 36.0;
                    case "Foot":
                        return value * 3.0;
                    case "Centimeter":
                        return value * 91.44;
                    case "Mile":
                        return value / 1760.0;
                    default:
                        return unsupportedConversion(context, value, sourceUnit, destUnit);
                }
            case "Mile":
                switch (destUnit) {
                    case "Inch":
                        return value * 63360.0;
                    case "Foot":
                        return value * 5280.0;
                    case "Yard":
                        return value * 1760.0;
                    case "Centimeter":
                        return value * 160934.0;
                    default:
                        return unsupportedConversion(context, value, sourceUnit, destUnit);
                }
            default:
                return unsupportedConversion(context, value, sourceUnit, destUnit);
        }
    }


    // Weight Conversions
    public static double convertWeight(Context context,double value, String sourceUnit, String destUnit) {
        if (value <= 0) {
            throw new IllegalArgumentException("Input value must be positive");
        }

        switch (sourceUnit) {
            case "Pound":
                switch (destUnit) {
                    case "Kilogram":
                        return value * 0.453592;
                    case "Ounce":
                        return value * 16.0;
                    case "Ton":
                        return value * 0.000453592;
                    case "Gram":
                        return value * 453.592;
                    default:
                        return unsupportedConversion(context, value, sourceUnit, destUnit);
                }
            case "Ounce":
                switch (destUnit) {
                    case "Pound":
                        return value / 16.0;
                    case "Kilogram":
                        return value * 0.0283495;
                    case "Ton":
                        return value * 2.835e-5;
                    case "Gram":
                        return value * 28.3495;
                    default:
                        return unsupportedConversion(context, value, sourceUnit, destUnit);
                }
            case "Ton":
                switch (destUnit) {
                    case "Pound":
                        return value * 2204.62;
                    case "Ounce":
                        return value * 35274.0;
                    case "Kilogram":
                        return value * 907.185;
                    case "Gram":
                        return value * 907185.0;
                    default:
                        return unsupportedConversion(context, value, sourceUnit, destUnit);
                }
            case "Kilogram":
                switch (destUnit) {
                    case "Pound":
                        return value * 2.20462;
                    case "Ounce":
                        return value * 35.274;
                    case "Ton":
                        return value * 0.00110231;
                    case "Gram":
                        return value * 1000.0;
                    default:
                        return unsupportedConversion(context, value, sourceUnit, destUnit);
                }
            case "Gram":
                switch (destUnit) {
                    case "Pound":
                        return value * 0.00220462;
                    case "Ounce":
                        return value * 0.035274;
                    case "Ton":
                        return value * 1.1023e-6;
                    case "Kilogram":
                        return value * 0.001;
                    default:
                        return unsupportedConversion(context, value, sourceUnit, destUnit);
                }
            default:
                return unsupportedConversion(context, value, sourceUnit, destUnit);
        }
    }
    // Temperature Conversions

    public static double convertTemperature(Context context, double value, String sourceUnit, String destUnit) {
        switch (sourceUnit) {
            case "Celsius":
                switch (destUnit) {
                    case "Fahrenheit":
                        return (value * 1.8) + 32;
                    case "Kelvin":
                        return value + 273.15;
                    default:
                        return unsupportedConversion(context, value, sourceUnit, destUnit);
                }
            case "Fahrenheit":
                switch (destUnit) {
                    case "Celsius":
                        return (value - 32) / 1.8;
                    case "Kelvin":
                        return (value - 32) / 1.8 + 273.15;
                    default:
                        return unsupportedConversion(context, value, sourceUnit, destUnit);
                }
            case "Kelvin":
                switch (destUnit) {
                    case "Celsius":
                        return value - 273.15;
                    case "Fahrenheit":
                        return (value - 273.15) * 1.8 + 32;
                    default:
                        return unsupportedConversion(context, value, sourceUnit, destUnit);
                }
            default:
                return unsupportedConversion(context, value, sourceUnit, destUnit);
        }
    }


   private static double unsupportedConversion(Context context, double value, String sourceUnit, String destUnit) {
        // Display a toast message indicating that the conversion is not supported
        String message = "Conversion from " + sourceUnit + " to " + destUnit + " is not supported";
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        return 0; // Set 0 as converted value
    }


}
