package com.mymusic.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mymusic.app.model.CommentModel;
import com.mymusic.app.model.ResponseComment;
import com.mymusic.app.repositories.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentServices {

    @Autowired
    CommentRepository commentRepository;

    public ResponseEntity<String> createComment(CommentModel req){
        try {
            List<String> newList = new ArrayList<>();
            req.setIdLiked(newList);
            req.setLikeCount(0);
            commentRepository.insert(req);
            return ResponseEntity.status(HttpStatus.OK).body("created");
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseComment> getAllComment(){
        try {
            List<CommentModel> found = commentRepository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseComment(true, "message", found));
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseComment> getComment(String id){
        try {
            List<CommentModel> found = commentRepository.findBySongId(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseComment(true, "success", found));
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseComment> deleteComment(String id){
        try {
            commentRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseComment(true, "deleted", null));
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseComment> likeComment(CommentModel req){
        try {
            Optional<CommentModel> found = commentRepository.findById(req.getId());
            if(!found.isPresent()){
                return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(new ResponseComment(false, "fail request", null));
            }
            boolean check = found.get().getIdLiked().contains(req.getuserId());
            if(check){
                int likeCount = found.get().getLikeCount();
                found.get().setLikeCount(likeCount - 1);
                int index = found.get().getIdLiked().indexOf(req.getuserId());
                found.get().getIdLiked().remove(index);
                commentRepository.save(found.get());
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseComment(true, "updated", null));
            }
            int likeCount = found.get().getLikeCount();
            found.get().setLikeCount(likeCount + 1);
            List<String> newList = found.get().getIdLiked();
            newList.add(req.getuserId());
            found.get().setIdLiked(newList);
            commentRepository.save(found.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseComment(true, "updated", null));
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseComment> editComment(CommentModel req){
        try {
            Optional<CommentModel> found = commentRepository.findById(req.getId());
            if(!found.isPresent()){
                return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(new ResponseComment(false, "fail request", null));
            }
            found.get().setcontent(req.getcontent());
            commentRepository.save(found.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseComment(true, "updated", null));
        } catch (Exception e) {
            throw e;
        }
    }
}
