package com.DEVLooping.cruddemo.entity;

public class ErrorResponse {
    private int http_status;
    private String status_description;
    private String message;

    public ErrorResponse(int http_status, String status_description, String message) {
        this.http_status = http_status;
        this.status_description = status_description;
        this.message = message;
    }

    public int getHttp_status() {
        return http_status;
    }

    public void setHttp_status(int http_status) {
        this.http_status = http_status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus_description() {
        return status_description;
    }

    public void setStatus_description(String status_description) {
        this.status_description = status_description;
    }
}
