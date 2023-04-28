package com.mymusic.app.controller;

import com.mymusic.app.model.AdminModel;
import com.mymusic.app.model.ResponseSongModel;
import com.mymusic.app.services.AdminServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "https://songandmore.herokuapp.com")
@CrossOrigin("*")
@RequestMapping(path = "/")
public class AdminController {

    @Autowired
    AdminServices adminServices;
    
    @PostMapping("/admin/login")
    ResponseEntity<ResponseSongModel> login(@RequestBody AdminModel req){
        return adminServices.login(req);
    }
}
