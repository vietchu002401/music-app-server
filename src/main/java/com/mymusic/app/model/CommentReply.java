package com.mymusic.app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "commentReplies")
public class CommentReply {
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

    public CommentReply() {
    }

    public CommentReply(String id, String userId, String songId, String content, int likeCount, long time, List<String> idLiked) {
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

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSongId() {
        return this.songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<String> getIdLiked() {
        return this.idLiked;
    }

    public void setIdLiked(List<String> idLiked) {
        this.idLiked = idLiked;
    }

    public CommentReply id(String id) {
        setId(id);
        return this;
    }

    public CommentReply userId(String userId) {
        setUserId(userId);
        return this;
    }

    public CommentReply songId(String songId) {
        setSongId(songId);
        return this;
    }

    public CommentReply content(String content) {
        setContent(content);
        return this;
    }

    public CommentReply likeCount(int likeCount) {
        setLikeCount(likeCount);
        return this;
    }

    public CommentReply time(long time) {
        setTime(time);
        return this;
    }

    public CommentReply idLiked(List<String> idLiked) {
        setIdLiked(idLiked);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", songId='" + getSongId() + "'" +
            ", content='" + getContent() + "'" +
            ", likeCount='" + getLikeCount() + "'" +
            ", time='" + getTime() + "'" +
            ", idLiked='" + getIdLiked() + "'" +
            "}";
    }


}
