package com.mymusic.app.repositories;

import java.util.List;

import com.mymusic.app.model.NewsModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends MongoRepository<NewsModel, String>{
    List<NewsModel> findByBody(String body);
}
