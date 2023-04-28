package com.mymusic.app.model;

public class SearchModel {
    
    private String key;
    private boolean isSong;
    private boolean isSoundTrack;
    private String code;



    public SearchModel() {
    }

    public SearchModel(String key, boolean isSong, boolean isSoundTrack, String code) {
        this.key = key;
        this.isSong = isSong;
        this.isSoundTrack = isSoundTrack;
        this.code = code;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public boolean isIsSoundTrack() {
        return this.isSoundTrack;
    }

    public boolean getIsSoundTrack() {
        return this.isSoundTrack;
    }

    public void setIsSoundTrack(boolean isSoundTrack) {
        this.isSoundTrack = isSoundTrack;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SearchModel key(String key) {
        setKey(key);
        return this;
    }

    public SearchModel isSong(boolean isSong) {
        setIsSong(isSong);
        return this;
    }

    public SearchModel isSoundTrack(boolean isSoundTrack) {
        setIsSoundTrack(isSoundTrack);
        return this;
    }

    public SearchModel code(String code) {
        setCode(code);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " key='" + getKey() + "'" +
            ", isSong='" + isIsSong() + "'" +
            ", isSoundTrack='" + isIsSoundTrack() + "'" +
            ", code='" + getCode() + "'" +
            "}";
    }
    

}
