package org.csye7374.utils;

import java.util.Calendar;

public class BasicCalculator implements CalculatorAPI {
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public String toString() {
        return "Calculator1{}";
    }
}
