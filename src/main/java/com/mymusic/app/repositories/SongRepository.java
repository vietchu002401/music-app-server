package com.mymusic.app.repositories;

import java.util.List;
import java.util.Optional;

import com.mymusic.app.model.SongModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends MongoRepository<SongModel, String> {
    Optional<SongModel> findByCode(String code);
    List<SongModel> findByIdIn(List<String> id);
    List<SongModel> findByComposerOrSingerOrMovie(String composer, String singer, String movie);
    List<SongModel> findByComposerOrSinger(String composer, String singer);
}
