package com.mymusic.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "songs")
public class SongModel {
    @Id
    private String id;
    @Field("name")
    private String name;
    @Field("singer")
    private String singer;
    @Field("composer")
    private String composer;
    @Field("code")
    private String code;
    @Field("lyric")
    private String lyric;
    @Field("isSoundTrack")
    private boolean isSoundTrack;
    @Field("isSong")
    private boolean isSong;
    @Field("movie")
    private String movie;
    @Field("image")
    private String image;

    private String authCode;



    public SongModel() {
    }

    public SongModel(String id, String name, String singer, String composer, String code, String lyric, boolean isSoundTrack, boolean isSong, String movie, String image, String authCode) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.composer = composer;
        this.code = code;
        this.lyric = lyric;
        this.isSoundTrack = isSoundTrack;
        this.isSong = isSong;
        this.movie = movie;
        this.image = image;
        this.authCode = authCode;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLyric() {
        return this.lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public boolean isIsSoundTrack() {
        return this.isSoundTrack;
    }

    public boolean getIsSoundTrack() {
        return this.isSoundTrack;
    }

    public void setIsSoundTrack(boolean isSoundTrack) {
        this.isSoundTrack = isSoundTrack;
    }

    public boolean isIsSong() {
        return this.isSong;
    }

    public boolean getIsSong() {
        return this.isSong;
    }

    public void setIsSong(boolean isSong) {
        this.isSong = isSong;
    }

    public String getMovie() {
        return this.movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public SongModel id(String id) {
        setId(id);
        return this;
    }

    public SongModel name(String name) {
        setName(name);
        return this;
    }

    public SongModel singer(String singer) {
        setSinger(singer);
        return this;
    }

    public SongModel composer(String composer) {
        setComposer(composer);
        return this;
    }

    public SongModel code(String code) {
        setCode(code);
        return this;
    }

    public SongModel lyric(String lyric) {
        setLyric(lyric);
        return this;
    }

    public SongModel isSoundTrack(boolean isSoundTrack) {
        setIsSoundTrack(isSoundTrack);
        return this;
    }

    public SongModel isSong(boolean isSong) {
        setIsSong(isSong);
        return this;
    }

    public SongModel movie(String movie) {
        setMovie(movie);
        return this;
    }

    public SongModel image(String image) {
        setImage(image);
        return this;
    }

    public SongModel authCode(String authCode) {
        setAuthCode(authCode);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", singer='" + getSinger() + "'" +
            ", composer='" + getComposer() + "'" +
            ", code='" + getCode() + "'" +
            ", lyric='" + getLyric() + "'" +
            ", isSoundTrack='" + isIsSoundTrack() + "'" +
            ", isSong='" + isIsSong() + "'" +
            ", movie='" + getMovie() + "'" +
            ", image='" + getImage() + "'" +
            ", authCode='" + getAuthCode() + "'" +
            "}";
    }
    
}
