package com.mymusic.app.services;

import java.util.List;

import com.mymusic.app.model.AdminModel;
import com.mymusic.app.model.ResponseSongModel;
import com.mymusic.app.repositories.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminServices {
    
    @Autowired
    AdminRepository adminRepository;
    public ResponseEntity<ResponseSongModel> login(AdminModel req){
        List<AdminModel> found = adminRepository.findAll();
        if(req.getUsername().equals(found.get(0).getUsername()) && req.getPassword().equals(found.get(0).getPassword())){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseSongModel(true, found.get(0).getCode(), null));
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseSongModel(true, "", null));
        }
    }
}
