package com.mymusic.app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "comments")
public class CommentModel {
    
    @Id
    private String id;
    @Field("userId")
    private String userId;
    @Field("songId")
    private String songId;
    @Field("content")
    private String content;
    @Field("likeCount")
    private int likeCount;
    @Field("time")
    private long time;
    @Field("idLiked")
    private List<String> idLiked;



    public CommentModel() {
    }

    public CommentModel(String id, String userId, String songId, String content, int likeCount, long time, List<String> idLiked) {
        this.id = id;
        this.userId = userId;
        this.songId = songId;
        this.content = content;
        this.likeCount = likeCount;
        this.time = time;
        this.idLiked = idLiked;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuserId() {
        return this.userId;
    }

    public void setuserId(String userId) {
        this.userId = userId;
    }

    public String getsongId() {
        return this.songId;
    }

    public void setsongId(String songId) {
        this.songId = songId;
    }

    public String getcontent() {
        return this.content;
    }

    public void setcontent(String content) {
        this.content = content;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public long gettime() {
        return this.time;
    }

    public void settime(long time) {
        this.time = time;
    }

    public List<String> getIdLiked() {
        return this.idLiked;
    }

    public void setIdLiked(List<String> idLiked) {
        this.idLiked = idLiked;
    }

    public CommentModel id(String id) {
        setId(id);
        return this;
    }

    public CommentModel userId(String userId) {
        setuserId(userId);
        return this;
    }

    public CommentModel songId(String songId) {
        setsongId(songId);
        return this;
    }

    public CommentModel content(String content) {
        setcontent(content);
        return this;
    }

    public CommentModel likeCount(int likeCount) {
        setLikeCount(likeCount);
        return this;
    }

    public CommentModel time(long time) {
        settime(time);
        return this;
    }

    public CommentModel idLiked(List<String> idLiked) {
        setIdLiked(idLiked);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userId='" + getuserId() + "'" +
            ", songId='" + getsongId() + "'" +
            ", content='" + getcontent() + "'" +
            ", likeCount='" + getLikeCount() + "'" +
            ", time='" + gettime() + "'" +
            ", idLiked='" + getIdLiked() + "'" +
            "}";
    }
    


}
