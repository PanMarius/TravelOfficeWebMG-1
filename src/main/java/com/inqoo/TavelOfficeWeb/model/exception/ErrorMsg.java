package com.inqoo.TavelOfficeWeb.model.exception;

public class ErrorMsg {
    private final String message;
    private final Integer httpResponseCode;

    public ErrorMsg(String message, Integer httpResponseCode) {
        this.message = message;
        this.httpResponseCode = httpResponseCode;
    }

    public String getMessage() {
        return message;
    }

    public Integer getHttpResponseCode() {
        return httpResponseCode;
    }
}
