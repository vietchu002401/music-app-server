package com.mymusic.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "recommends")
public class RecommendSongModel {
    
    @Id
    private String id;
    @Field("user")
    private String user;
    @Field("email")
    private String email;
    @Field("songName")
    private String songName;
    @Field("singer")
    private String singer;
    @Field("composer")
    private String composer;
    @Field("movie")
    private String movie;
    @Field("info")
    private String info;
    @Field("kind")
    private String kind;


    public RecommendSongModel() {
    }

    public RecommendSongModel(String id, String user, String email, String songName, String singer, String composer, String movie, String info, String kind) {
        this.id = id;
        this.user = user;
        this.email = email;
        this.songName = songName;
        this.singer = singer;
        this.composer = composer;
        this.movie = movie;
        this.info = info;
        this.kind = kind;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSongName() {
        return this.songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return this.singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getComposer() {
        return this.composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getMovie() {
        return this.movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getKind() {
        return this.kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public RecommendSongModel id(String id) {
        setId(id);
        return this;
    }

    public RecommendSongModel user(String user) {
        setUser(user);
        return this;
    }

    public RecommendSongModel email(String email) {
        setEmail(email);
        return this;
    }

    public RecommendSongModel songName(String songName) {
        setSongName(songName);
        return this;
    }

    public RecommendSongModel singer(String singer) {
        setSinger(singer);
        return this;
    }

    public RecommendSongModel composer(String composer) {
        setComposer(composer);
        return this;
    }

    public RecommendSongModel movie(String movie) {
        setMovie(movie);
        return this;
    }

    public RecommendSongModel info(String info) {
        setInfo(info);
        return this;
    }

    public RecommendSongModel kind(String kind) {
        setKind(kind);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", user='" + getUser() + "'" +
            ", email='" + getEmail() + "'" +
            ", songName='" + getSongName() + "'" +
            ", singer='" + getSinger() + "'" +
            ", composer='" + getComposer() + "'" +
            ", movie='" + getMovie() + "'" +
            ", info='" + getInfo() + "'" +
            ", kind='" + getKind() + "'" +
            "}";
    }

}
