package com.mymusic.app.controller;

import com.mymusic.app.model.RecommendSongModel;
import com.mymusic.app.model.ResponseRecommendSongModel;
import com.mymusic.app.model.SearchModel;
import com.mymusic.app.services.RecommendSongServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "https://songandmore.herokuapp.com")
@CrossOrigin("*")
@RequestMapping(path = "/")
public class RecommendSongController {
    

    @Autowired
    RecommendSongServices recommendSongServices;

    @PostMapping("/get-all-recommend")
    ResponseEntity<ResponseRecommendSongModel> getAllRecommendSong(@RequestBody SearchModel req){
        return recommendSongServices.getAllRecommendSong(req);
    }

    @PostMapping("/create-recommend")
    ResponseEntity<ResponseRecommendSongModel> createRecommendSong(@RequestBody RecommendSongModel req){
        // if(req.getEmail().contains("@gmail.com")){
        //     recommendSongServices.sendSimpleEmail(req.getEmail(), "Hi "+ req.getUser()+ "," +"\n\nThank you for leaving us a suggestion.\nWe will cherish and consider it.\nPlease continue to support and follow our collection.\n\nSincerely,\nDarkmouse", "Thanks for your suggestion");
        // }
        return recommendSongServices.createRecommendSong(req);
    }

    @DeleteMapping("/delete-recommend/{id}")
    ResponseEntity<ResponseRecommendSongModel> deleteRecommendSong(@PathVariable String id){
        return recommendSongServices.deleteRecommendSong(id);
    }
}
