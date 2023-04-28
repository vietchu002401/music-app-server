package com.mymusic.app.model;


public class ResponseUser {
    
    private boolean status;
    private String message;
    private UserModel data;


    public ResponseUser() {
    }

    public ResponseUser(boolean status, String message, UserModel data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserModel getData() {
        return this.data;
    }

    public void setData(UserModel data) {
        this.data = data;
    }

    public ResponseUser status(boolean status) {
        setStatus(status);
        return this;
    }

    public ResponseUser message(String message) {
        setMessage(message);
        return this;
    }

    public ResponseUser data(UserModel data) {
        setData(data);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " status='" + isStatus() + "'" +
            ", message='" + getMessage() + "'" +
            ", data='" + getData() + "'" +
            "}";
    }

}
