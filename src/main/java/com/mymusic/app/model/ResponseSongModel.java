package com.mymusic.app.model;

import java.util.List;

public class ResponseSongModel {
    private boolean status;
    private String message;
    private List<SongModel> data;


    public ResponseSongModel() {
    }

    public ResponseSongModel(boolean status, String message, List<SongModel> data) {
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

    public List<SongModel> getData() {
        return this.data;
    }

    public void setData(List<SongModel> data) {
        this.data = data;
    }

    public ResponseSongModel status(boolean status) {
        setStatus(status);
        return this;
    }

    public ResponseSongModel message(String message) {
        setMessage(message);
        return this;
    }

    public ResponseSongModel data(List<SongModel> data) {
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
