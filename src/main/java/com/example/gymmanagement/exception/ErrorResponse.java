package com.example.gymmanagement.exception;


import lombok.Data;

@Data
public class ErrorResponse {

    private String errorCode;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
