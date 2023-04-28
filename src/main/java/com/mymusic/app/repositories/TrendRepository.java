package com.mymusic.app.repositories;

import java.util.Optional;

import com.mymusic.app.model.TrendModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendRepository extends MongoRepository<TrendModel, String> {
    Optional<TrendModel> findByIsSongTrue();
    Optional<TrendModel> findByIsSongFalse();
}
