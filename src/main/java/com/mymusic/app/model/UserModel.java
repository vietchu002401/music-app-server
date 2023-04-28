package com.mymusic.app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
public class UserModel {
    
    @Id
    private String id;
    @Field("googleId")
    private String googleId;
    @Field("liked")
    private List<String> liked;
    @Field("imageUrl")
    private String imageUrl;


    public UserModel() {
    }

    public UserModel(String id, String googleId, List<String> liked, String imageUrl) {
        this.id = id;
        this.googleId = googleId;
        this.liked = liked;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoogleId() {
        return this.googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public List<String> getLiked() {
        return this.liked;
    }

    public void setLiked(List<String> liked) {
        this.liked = liked;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public UserModel id(String id) {
        setId(id);
        return this;
    }

    public UserModel googleId(String googleId) {
        setGoogleId(googleId);
        return this;
    }

    public UserModel liked(List<String> liked) {
        setLiked(liked);
        return this;
    }

    public UserModel imageUrl(String imageUrl) {
        setImageUrl(imageUrl);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", googleId='" + getGoogleId() + "'" +
            ", liked='" + getLiked() + "'" +
            ", imageUrl='" + getImageUrl() + "'" +
            "}";
    }

}
