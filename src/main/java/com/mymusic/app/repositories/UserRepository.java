package com.mymusic.app.repositories;


import java.util.List;

import com.mymusic.app.model.UserModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String>{
    List<UserModel> findByGoogleId(String googleId);
}
