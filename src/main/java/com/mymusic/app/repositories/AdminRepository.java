package com.mymusic.app.repositories;

import com.mymusic.app.model.AdminModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<AdminModel, String>{
    
}
