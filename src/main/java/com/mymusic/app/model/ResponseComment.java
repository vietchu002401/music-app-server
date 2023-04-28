package com.mymusic.app.model;

import java.util.List;


public class ResponseComment {
    
    private boolean status;
    private String message;
    List<CommentModel> data;


    public ResponseComment() {
    }

    public ResponseComment(boolean status, String message, List<CommentModel> data) {
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

    public List<CommentModel> getData() {
        return this.data;
    }

    public void setData(List<CommentModel> data) {
        this.data = data;
    }

    public ResponseComment status(boolean status) {
        setStatus(status);
        return this;
    }

    public ResponseComment message(String message) {
        setMessage(message);
        return this;
    }

    public ResponseComment data(List<CommentModel> data) {
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
