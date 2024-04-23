package com.DEVLooping.challengesAPI.entity;

public class ErrorResponse {
    private int http_status;
    private String status_description;
    private String message;
    private int error_case;

    public ErrorResponse(int http_status, String status_description, String message, int error_case) {
        this.http_status = http_status;
        this.status_description = status_description;
        this.message = message;
        this.error_case = error_case;
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

    public int getError_case() {
        return error_case;
    }

    public void setError_case(int error_case) {
        this.error_case = error_case;
    }
}
