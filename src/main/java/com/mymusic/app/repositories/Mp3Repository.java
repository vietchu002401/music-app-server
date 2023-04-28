package com.mymusic.app.repositories;

import com.mymusic.app.model.Mp3Model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Mp3Repository extends MongoRepository<Mp3Model, String>{
    
}
