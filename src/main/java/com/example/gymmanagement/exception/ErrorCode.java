package com.example.gymmanagement.exception;





public enum ErrorCode {


    RESOURCE_NOT_FOUND("RESOURCE_NOT_FOUND"),
    INVALID_INPUT("INVALID_INPUT"),
    DUPLICATE_RESOURCE("DUPLICATE_RESOURCE"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR");

    private final String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
