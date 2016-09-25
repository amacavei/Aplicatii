package com.dissertation.project.model;

/**
 * Created by cmarineata on 9/25/2016.
 */
public class Error {

    private String reason;

    private String message;

    public Error(String reason, String message) {
        this.reason = reason;
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
