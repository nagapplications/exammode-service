package com.techbeyondjava.exammode_service.util;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.performOperation(1,2,new SubtractOperation());
    }
}
