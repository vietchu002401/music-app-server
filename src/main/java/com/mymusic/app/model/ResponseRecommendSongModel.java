package com.mymusic.app.model;

import java.util.List;

public class ResponseRecommendSongModel {
    private boolean status;
    private String message;
    private List<RecommendSongModel> data;


    public ResponseRecommendSongModel() {
    }

    public ResponseRecommendSongModel(boolean status, String message, List<RecommendSongModel> data) {
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

    public List<RecommendSongModel> getData() {
        return this.data;
    }

    public void setData(List<RecommendSongModel> data) {
        this.data = data;
    }

    public ResponseRecommendSongModel status(boolean status) {
        setStatus(status);
        return this;
    }

    public ResponseRecommendSongModel message(String message) {
        setMessage(message);
        return this;
    }

    public ResponseRecommendSongModel data(List<RecommendSongModel> data) {
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
