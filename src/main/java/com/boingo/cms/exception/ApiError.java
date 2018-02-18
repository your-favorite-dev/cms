package com.boingo.cms.exception;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class ApiError {
    private long timestamp = Calendar.getInstance().getTimeInMillis();
    private int code;
    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.code = status.value();
        this.message = message;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String message, String... error) {
        super();
        this.status = status;
        this.code = status.value();
        this.message = message;
        errors = Arrays.asList(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
