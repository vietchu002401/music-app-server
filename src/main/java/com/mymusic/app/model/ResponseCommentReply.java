package com.mymusic.app.model;

import java.util.List;

public class ResponseCommentReply {
    
    private boolean status;
    private String message;
    List<CommentReply> data;


    public ResponseCommentReply() {
    }

    public ResponseCommentReply(boolean status, String message, List<CommentReply> data) {
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

    public List<CommentReply> getData() {
        return this.data;
    }

    public void setData(List<CommentReply> data) {
        this.data = data;
    }

    public ResponseCommentReply status(boolean status) {
        setStatus(status);
        return this;
    }

    public ResponseCommentReply message(String message) {
        setMessage(message);
        return this;
    }

    public ResponseCommentReply data(List<CommentReply> data) {
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
