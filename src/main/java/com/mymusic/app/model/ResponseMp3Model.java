package com.mymusic.app.model;

import java.util.List;

public class ResponseMp3Model {
    private boolean status;
    private String message;
    private List<Mp3Model> data;


    public ResponseMp3Model() {
    }

    public ResponseMp3Model(boolean status, String message, List<Mp3Model> data) {
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

    public List<Mp3Model> getData() {
        return this.data;
    }

    public void setData(List<Mp3Model> data) {
        this.data = data;
    }

    public ResponseMp3Model status(boolean status) {
        setStatus(status);
        return this;
    }

    public ResponseMp3Model message(String message) {
        setMessage(message);
        return this;
    }

    public ResponseMp3Model data(List<Mp3Model> data) {
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
