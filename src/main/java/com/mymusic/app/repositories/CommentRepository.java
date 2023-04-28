package com.mymusic.app.repositories;

import java.util.List;

import com.mymusic.app.model.CommentModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository <CommentModel, String>{
    List<CommentModel> findBySongId(String songId);
}
