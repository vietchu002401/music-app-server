package com.mymusic.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "news")
public class NewsModel {
    @Id
    private String id;
    @Field("header")
    private String header;
    @Field("body")
    private String body;
    @Field("image")
    private String image;
    @Field("code")
    private String code;

    private String authCode;



    public NewsModel() {
    }

    public NewsModel(String id, String header, String body, String image, String code, String authCode) {
        this.id = id;
        this.header = header;
        this.body = body;
        this.image = image;
        this.code = code;
        this.authCode = authCode;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public NewsModel id(String id) {
        setId(id);
        return this;
    }

    public NewsModel header(String header) {
        setHeader(header);
        return this;
    }

    public NewsModel body(String body) {
        setBody(body);
        return this;
    }

    public NewsModel image(String image) {
        setImage(image);
        return this;
    }

    public NewsModel code(String code) {
        setCode(code);
        return this;
    }

    public NewsModel authCode(String authCode) {
        setAuthCode(authCode);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", header='" + getHeader() + "'" +
            ", body='" + getBody() + "'" +
            ", image='" + getImage() + "'" +
            ", code='" + getCode() + "'" +
            ", authCode='" + getAuthCode() + "'" +
            "}";
    }
   

}
