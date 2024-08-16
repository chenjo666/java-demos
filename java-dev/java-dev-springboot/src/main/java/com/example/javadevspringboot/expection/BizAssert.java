package com.example.javadevspringboot.expection;

/**
 * @author chenjian
 * @datetime 2024-08-16 20:30
 */
public class BizAssert {


    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BizException(message);
        }
    }
    public static void isTrue(boolean expression, String retCode, String message) {
        if (!expression) {
            throw new BizException(retCode,message);
        }
    }
}
