package com.mymusic.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "trend")
public class TrendModel {
    @Id
    private String id;
    @Field("isSong")
    private Boolean isSong;
    @Field("accessCount")
    private long accessCount;


    public TrendModel() {
    }

    public TrendModel(String id, Boolean isSong, long accessCount) {
        this.id = id;
        this.isSong = isSong;
        this.accessCount = accessCount;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean isIsSong() {
        return this.isSong;
    }

    public Boolean getIsSong() {
        return this.isSong;
    }

    public void setIsSong(Boolean isSong) {
        this.isSong = isSong;
    }

    public long getAccessCount() {
        return this.accessCount;
    }

    public void setAccessCount(long accessCount) {
        this.accessCount = accessCount;
    }

    public TrendModel id(String id) {
        setId(id);
        return this;
    }

    public TrendModel isSong(Boolean isSong) {
        setIsSong(isSong);
        return this;
    }

    public TrendModel accessCount(long accessCount) {
        setAccessCount(accessCount);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", isSong='" + isIsSong() + "'" +
            ", accessCount='" + getAccessCount() + "'" +
            "}";
    }

}
