package com.mymusic.app.repositories;

import java.util.List;

import com.mymusic.app.model.CommentReply;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentReplyRepository extends MongoRepository<CommentReply, String>{
    List<CommentReply> findBySongId(String songId);
}
