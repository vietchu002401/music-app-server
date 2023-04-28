package com.mymusic.app.controller;

import com.mymusic.app.model.NewsModel;
import com.mymusic.app.model.ResponseNews;
import com.mymusic.app.model.SearchModel;
import com.mymusic.app.services.NewsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "https://songandmore.herokuapp.com")
@CrossOrigin("*")
@RequestMapping(path = "/")
public class NewsController {
    @Autowired
    NewsServices newsServices;

    @PostMapping("/get-all-news")
    ResponseEntity<ResponseNews> getAllNews(@RequestBody SearchModel req){
        return newsServices.getAllNews(req);
    }

    @GetMapping("/get-news")
    ResponseEntity<ResponseNews> getNewest(){
        return newsServices.getNewest();
    }

    @GetMapping("/get-news-by-id/{id}")
    ResponseEntity<ResponseNews> getNewsById(@PathVariable String id){
        return newsServices.getNewsById(id);
    }

    @DeleteMapping("/delete-news/{id}")
    ResponseEntity<ResponseNews> deleteById(@PathVariable String id){
        return newsServices.deleteById(id);
    }

    @PostMapping("/update-news")
    ResponseEntity<ResponseNews> updateNews(@RequestBody NewsModel req){
        return newsServices.updateNews(req);
    }

    @PostMapping("/create-news")
    ResponseEntity<ResponseNews> createNews(@RequestBody NewsModel req){
        return newsServices.createNews(req);
    }
}
