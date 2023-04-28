package com.mymusic.app.controller;

import com.mymusic.app.model.ResponseMp3Model;
import com.mymusic.app.services.Mp3Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "https://songandmore.herokuapp.com")
@CrossOrigin("*")
@RequestMapping("/mp3")
public class Mp3Controller {
    
    @Autowired
    Mp3Services mp3Services;

    @GetMapping("/get-all-list")
    ResponseEntity<ResponseMp3Model> getAllList(){
        return mp3Services.getAllList();
    }

    @GetMapping("/get-mp3-by-id")
    ResponseEntity<ResponseMp3Model> getById(@RequestParam(name = "id") String id){
        return mp3Services.getById(id);
    }

    @PostMapping("/update-mp3")
    ResponseEntity<ResponseMp3Model> updateMp3(@RequestBody Object req, @RequestParam String id, @RequestParam String location, @RequestParam String auth){
        return mp3Services.updateContent(req, id, location, auth);
    }
}
