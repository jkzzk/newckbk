package com.imust.newckbk.exception;

/**
 * �Զ����쳣��
 */
public class CustomException extends RuntimeException {

    // �쳣��Ϣ
    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}



