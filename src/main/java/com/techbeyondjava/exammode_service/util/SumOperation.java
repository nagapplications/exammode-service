package com.techbeyondjava.exammode_service.util;

public class SumOperation implements Operation{
    @Override
    public int performOperation(int x, int y) {
        return x+y;
    }
}
