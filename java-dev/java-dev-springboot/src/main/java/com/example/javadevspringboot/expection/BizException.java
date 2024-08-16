package com.example.javadevspringboot.expection;

/**
 * @author chenjian
 * @datetime 2024-08-16 20:30
 */
public class BizException extends RuntimeException{
    private String retCode;
    private String retMsg;
    public BizException(String message) {
        super(message);
    }


    public BizException(String message, Throwable cause) {
        super(message, cause);
    }



    public BizException(Throwable cause) {
        super(cause);
    }

    // retCode, retMsg
    public BizException(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }
}
