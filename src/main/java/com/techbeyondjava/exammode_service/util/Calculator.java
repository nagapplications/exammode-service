package com.techbeyondjava.exammode_service.util;

public class Calculator {

    public int performOperation(int x,int y,Operation operation){
        int result = operation.performOperation(x,y);
            System.out.println(result);
            return result;
    }
}
