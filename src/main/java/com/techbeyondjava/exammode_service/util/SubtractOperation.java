package com.techbeyondjava.exammode_service.util;

public class SubtractOperation implements Operation{
    @Override
    public int performOperation(int x, int y) {
        return x-y;
    }
}
