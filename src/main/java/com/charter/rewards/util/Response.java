package com.charter.rewards.util;

public enum Response {

    //short name to identify error code and full message
    SUCCESSFUL("00",  "Approved or completed successfully");



    String code;
    String message;

    Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}