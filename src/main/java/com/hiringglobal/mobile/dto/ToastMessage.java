package com.hiringglobal.mobile.dto;

public class ToastMessage {
    private String message;
    private int status;

    public ToastMessage() {
    }

    public ToastMessage(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
