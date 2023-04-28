package com.mymusic.app.controller;

import com.mymusic.app.model.CommentModel;
import com.mymusic.app.model.ResponseComment;
import com.mymusic.app.services.CommentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class CommentController {

    @Autowired
    CommentServices commentServices;

    @PostMapping("/create-comment")
    ResponseEntity<String> createComment(@RequestBody CommentModel req){
        return commentServices.createComment(req);
    }

    @GetMapping("/get-all-comment")
    ResponseEntity<ResponseComment> getAllComment(){
        return commentServices.getAllComment();
    }

    @GetMapping("/get-comment")
    ResponseEntity<ResponseComment> getComment(@RequestParam(name = "id") String id){
        return commentServices.getComment(id);
    }


    @DeleteMapping("/delete-comment")
    ResponseEntity<ResponseComment> deleteComment(@RequestParam(name = "id") String id){
        return commentServices.deleteComment(id);
    }

    @PostMapping("/like-comment")
    ResponseEntity<ResponseComment> likeComment(@RequestBody CommentModel req){
        return commentServices.likeComment(req);
    }

    @PostMapping("/edit-comment")
    ResponseEntity<ResponseComment> editComment(@RequestBody CommentModel req){
        return commentServices.editComment(req);
    }
}
