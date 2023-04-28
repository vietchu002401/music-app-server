package com.mymusic.app.model;

import java.util.List;

public class ResponseTrendModel {
    private boolean status;
    private String message;
    private List<TrendModel> data;


    public ResponseTrendModel() {
    }

    public ResponseTrendModel(boolean status, String message, List<TrendModel> data) {
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

    public List<TrendModel> getData() {
        return this.data;
    }

    public void setData(List<TrendModel> data) {
        this.data = data;
    }

    public ResponseTrendModel status(boolean status) {
        setStatus(status);
        return this;
    }

    public ResponseTrendModel message(String message) {
        setMessage(message);
        return this;
    }

    public ResponseTrendModel data(List<TrendModel> data) {
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
