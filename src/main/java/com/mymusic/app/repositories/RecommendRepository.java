package com.mymusic.app.repositories;

import com.mymusic.app.model.RecommendSongModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendRepository extends MongoRepository<RecommendSongModel, String>{
    
}
