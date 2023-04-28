package com.mymusic.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import com.mymusic.app.model.AdminModel;
import com.mymusic.app.model.NewsModel;
import com.mymusic.app.model.ResponseNews;
import com.mymusic.app.model.SearchModel;
import com.mymusic.app.repositories.AdminRepository;
import com.mymusic.app.repositories.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NewsServices {
    @Autowired
    NewsRepository newsRepository;
    @Autowired
    AdminRepository adminRepository;

    public ResponseEntity<ResponseNews> getNewest() {
        try {
            List<NewsModel> found = newsRepository.findAll();
            return found.size() > 3
                    ? ResponseEntity.status(HttpStatus.OK)
                            .body(new ResponseNews(true, "success", found.subList(found.size() - 3, found.size())))
                    : ResponseEntity.status(HttpStatus.OK).body(new ResponseNews(true, "success", found));
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseNews> getNewsById(String id) {
        try {
            Optional<NewsModel> found = newsRepository.findById(id);
            List<NewsModel> allList = newsRepository.findAll();
            List<NewsModel> data = new ArrayList<>();
            data.add(found.get());

            int index = IntStream.range(0, allList.size())
                    .filter(i -> allList.get(i).getId().equals(id))
                    .findFirst()
                    .orElse(-1);
            if((index == allList.size() - 1) && (index != 0)){
                data.add(allList.get(index - 1));
            }else if(index == 0 && index != allList.size() - 1){
                data.add(allList.get(index + 1));
            }else if((index > 0) && (index < allList.size() - 1)){
                data.add(allList.get(index - 1));
                data.add(allList.get(index + 1));
            }

            return found.isPresent()
                    ? ResponseEntity.status(HttpStatus.OK).body(new ResponseNews(true, "success", data))
                    : ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseNews> getAllNews(SearchModel req) {
        try {
            List<AdminModel> check = adminRepository.findAll();
            if (check.get(0).getCode().equals(req.getCode())) {
                List<NewsModel> found = newsRepository.findAll();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseNews(true, "success", found));
            } else {
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                        .body(new ResponseNews(false, "auth error", null));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseNews> deleteById(String id) {
        try {
            newsRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseNews(true, "deleted", null));
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseNews> updateNews(NewsModel req) {
        try {
            newsRepository.findById(req.getId()).map(item -> {
                item.setBody(req.getBody());
                item.setHeader(req.getHeader());
                item.setCode(req.getCode());
                item.setImage(req.getImage());
                return newsRepository.save(item);
            });
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseNews(true, "updated", null));
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseNews> createNews(NewsModel req) {
        try {
            List<NewsModel> found = newsRepository.findByBody(req.getBody());
            if (found.size() > 0) {
                return ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
                        .body(new ResponseNews(false, "already inserted", null));
            } else {
                List<AdminModel> check = adminRepository.findAll();
                if (check.get(0).getCode().equals(req.getAuthCode())) {
                    req.setAuthCode("");
                    newsRepository.insert(req);
                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseNews(true, "create", null));
                } else {
                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseNews(false, "You are cheat", null));
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
