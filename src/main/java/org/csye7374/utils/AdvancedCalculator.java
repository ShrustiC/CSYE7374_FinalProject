package org.csye7374.utils;

public class AdvancedCalculator implements AdvancedCalculatorAPI {
    @Override
    public double sub(double a, double b) {
        return a - b;
    }

    @Override
    public double mult(double a, double b) {
        return a * b;
    }

    @Override
    public double div(double a, double b) {
        if (b == 0.0) {
            return b;
        }
        return a / b;
    }

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public String toString() {
        return "Calculator2{}";
    }
}
