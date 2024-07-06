package com.techbeyondjava.exammode_service.util;

public class Util {
    public static String passNullIfAll(String param) {
        return (param.equalsIgnoreCase("all")) ? null : param;
    }
}
