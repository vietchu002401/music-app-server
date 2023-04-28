package com.mymusic.app.controller;

import com.mymusic.app.model.ResponseUser;
import com.mymusic.app.model.UserModel;
import com.mymusic.app.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "https://songandmore.herokuapp.com")
@CrossOrigin("*")
@RequestMapping(path = "/")
public class UserController {
    
    @Autowired
    UserServices userServices;

    @PostMapping("/get-user-data")
    ResponseEntity<ResponseUser> getUser(@RequestBody UserModel req){
        return userServices.getUser(req);
    }

    @PostMapping("/update-like-list")
    void addToLikeList(@RequestBody UserModel req){
        userServices.addToLikeList(req);
    }

    @GetMapping("/get-user-avatar")
    ResponseEntity<ResponseUser> getUserAvatar(@RequestParam(name = "id") String id){
        return userServices.getUserAvatar(id);
    }
}
