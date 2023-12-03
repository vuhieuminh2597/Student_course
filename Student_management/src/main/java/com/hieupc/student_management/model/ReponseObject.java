package com.hieupc.student_management.model;

public class ReponseObject {
    private String Status;
    private String message;
    public ReponseObject() {
    }

    public ReponseObject(String status, String message) {
        Status = status;
        this.message = message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
