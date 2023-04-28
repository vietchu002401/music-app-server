package com.mymusic.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mymusic.app.model.CommentReply;
import com.mymusic.app.model.ResponseCommentReply;
import com.mymusic.app.repositories.CommentReplyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentReplyServices {
    @Autowired
    CommentReplyRepository commentReplyRepository;

    public ResponseEntity<String> createCommentReply(CommentReply req){
        try {
            List<String> newList = new ArrayList<>();
            req.setIdLiked(newList);
            req.setLikeCount(0);
            commentReplyRepository.insert(req);
            return ResponseEntity.status(HttpStatus.OK).body("created");
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseCommentReply> getCommentReply(String id){
        try {
            List<CommentReply> found = commentReplyRepository.findBySongId(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseCommentReply(true, "success", found));
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseCommentReply> deleteCommentReply(String id){
        try {
            commentReplyRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseCommentReply(true, "deleted", null));
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseCommentReply> likeCommentReply(CommentReply req){
        try {
            Optional<CommentReply> found = commentReplyRepository.findById(req.getId());
            if(!found.isPresent()){
                return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(new ResponseCommentReply(false, "fail request", null));
            }
            boolean check = found.get().getIdLiked().contains(req.getUserId());
            if(check){
                int likeCount = found.get().getLikeCount();
                found.get().setLikeCount(likeCount - 1);
                int index = found.get().getIdLiked().indexOf(req.getUserId());
                found.get().getIdLiked().remove(index);
                commentReplyRepository.save(found.get());
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseCommentReply(true, "updated", null));
            }
            int likeCount = found.get().getLikeCount();
            found.get().setLikeCount(likeCount + 1);
            List<String> newList = found.get().getIdLiked();
            newList.add(req.getUserId());
            found.get().setIdLiked(newList);
            commentReplyRepository.save(found.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseCommentReply(true, "updated", null));
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseCommentReply> editCommentReply(CommentReply req){
        try {
            Optional<CommentReply> found = commentReplyRepository.findById(req.getId());
            if(!found.isPresent()){
                return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(new ResponseCommentReply(false, "fail request", null));
            }
            found.get().setContent(req.getContent());
            commentReplyRepository.save(found.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseCommentReply(true, "updated", null));
        } catch (Exception e) {
            throw e;
        }
    }
}
