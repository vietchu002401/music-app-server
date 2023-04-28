package com.mymusic.app.controller;



import com.mymusic.app.model.ResponseSongModel;
import com.mymusic.app.model.SearchModel;
import com.mymusic.app.model.SongModel;
import com.mymusic.app.model.UserModel;
import com.mymusic.app.services.SongServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "https://songandmore.herokuapp.com")
@CrossOrigin("*")
@RequestMapping(path = "/")
public class SongController {
    
    @Autowired
    SongServices songServices;

    @GetMapping("/get-all-song/{slice}")
    ResponseEntity<ResponseSongModel> getAllSong(@PathVariable String slice){
        return songServices.getAllSong(slice);
    }

    @PostMapping("/add-song")
    ResponseEntity<ResponseSongModel> addSong(@RequestBody SongModel req){
        return songServices.addSong(req);
    }

    @PostMapping("/update-song")
    ResponseEntity<ResponseSongModel> updateSong(@RequestBody SongModel req){
        return songServices.updateSong(req);
    }

    @GetMapping("/get-song-by-id/{id}")
    ResponseEntity<ResponseSongModel> getSong(@PathVariable String id){
        return songServices.getSong(id);
    }

    @DeleteMapping("/delete-song/{id}")
    ResponseEntity<ResponseSongModel> deleteSong(@PathVariable String id){
        return songServices.deleteSong(id);
    }

    @PostMapping("/search-song")
    ResponseEntity<ResponseSongModel> getSearchSong(@RequestBody SearchModel req){
        return songServices.getSearchSong(req);
    }

    @PostMapping("/get-favorites")
    ResponseEntity<ResponseSongModel> getFavorites(@RequestBody UserModel req){
        return songServices.getFavorites(req);
    }

    @PostMapping("/admin-search-song")
    ResponseEntity<ResponseSongModel> adminSearchSong(@RequestBody SearchModel req){
        return songServices.adminSearchSong(req);
    }


    @GetMapping("/get-top-loved")
    ResponseEntity<ResponseSongModel> getTopLoved(@RequestParam(name = "slice") String slice){
        return songServices.getTopLoved(slice);
    }
}
