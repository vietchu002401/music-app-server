package com.mymusic.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mymusic.app.model.ResponseUser;
import com.mymusic.app.model.UserModel;
import com.mymusic.app.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<ResponseUser> getUser(UserModel req) {
        try {
            List<UserModel> found = userRepository.findByGoogleId(req.getGoogleId());
            if (found.size() == 0) {
                UserModel newUser = new UserModel();
                List<String> liked = new ArrayList<>();
                newUser.setGoogleId(req.getGoogleId());
                newUser.setImageUrl(req.getImageUrl());
                newUser.setLiked(liked);
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new ResponseUser(true, "success", userRepository.insert(newUser)));
            } else {
                found.get(0).setImageUrl(req.getImageUrl());
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseUser(true, "success", userRepository.save(found.get(0))));
            }
        } catch (Exception e) {
            throw e;
        }

    }

    public void addToLikeList(UserModel req) {
        try {
            Optional<UserModel> found = userRepository.findById(req.getId());
            found.ifPresent(item -> {
                item.setLiked(req.getLiked());
                userRepository.save(item);
            });
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseUser> getUserAvatar(String id){
        try {
            Optional<UserModel> found = userRepository.findById(id);
            if(!found.isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseUser(true, "success", null));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseUser(true, found.get().getImageUrl(), null));
        } catch (Exception e) {
            throw e;
        }
    }
}
