package com.mymusic.app.controller;

import com.mymusic.app.model.CommentReply;
import com.mymusic.app.model.ResponseCommentReply;
import com.mymusic.app.services.CommentReplyServices;

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
public class CommentReplyController {
    
    @Autowired
    CommentReplyServices commentReplyServices;

    @PostMapping("/create-comment-reply")
    ResponseEntity<String> createCommentReply(@RequestBody CommentReply req){
        return commentReplyServices.createCommentReply(req);
    }

    @GetMapping("/get-comment-reply")
    ResponseEntity<ResponseCommentReply> getCommentReply(@RequestParam(name = "id") String id){
        return commentReplyServices.getCommentReply(id);
    }

    @DeleteMapping("/delete-comment-reply")
    ResponseEntity<ResponseCommentReply> deleteCommentReply(@RequestParam(name = "id") String id){
        return commentReplyServices.deleteCommentReply(id);
    }

    @PostMapping("/like-comment-reply")
    ResponseEntity<ResponseCommentReply> likeComment(@RequestBody CommentReply req){
        return commentReplyServices.likeCommentReply(req);
    }

    @PostMapping("/edit-comment-reply")
    ResponseEntity<ResponseCommentReply> editComment(@RequestBody CommentReply req){
        return commentReplyServices.editCommentReply(req);
    }
}
