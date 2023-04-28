package com.mymusic.app.model;

import java.util.List;

public class ResponseNews {
    private boolean status;
    private String message;
    private List<NewsModel> data;


    public ResponseNews() {
    }

    public ResponseNews(boolean status, String message, List<NewsModel> data) {
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

    public List<NewsModel> getData() {
        return this.data;
    }

    public void setData(List<NewsModel> data) {
        this.data = data;
    }

    public ResponseNews status(boolean status) {
        setStatus(status);
        return this;
    }

    public ResponseNews message(String message) {
        setMessage(message);
        return this;
    }

    public ResponseNews data(List<NewsModel> data) {
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
