package com.mymusic.app.controller;

import com.mymusic.app.model.ResponseTrendModel;
import com.mymusic.app.services.TrendServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "https://songandmore.herokuapp.com")
@CrossOrigin("*")
@RequestMapping(path = "/")
public class TrendController {
    @Autowired
    TrendServices trendServices;

    @GetMapping("/get-all-trend/{code}")
    ResponseEntity<ResponseTrendModel> getAllTrend(@PathVariable String code){
        return trendServices.getAllTrend(code);
    }

    @PutMapping("/access-song")
    void accessSong(){
        trendServices.accessSong();
    }

    @PutMapping("/access-soundtrack")
    void accessSoundTrack(){
        trendServices.accessSoundTrack();
    }
}
