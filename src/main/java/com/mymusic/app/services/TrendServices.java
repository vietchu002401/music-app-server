package com.mymusic.app.services;

import java.util.List;
import java.util.Optional;

import com.mymusic.app.model.AdminModel;
import com.mymusic.app.model.ResponseTrendModel;
import com.mymusic.app.model.TrendModel;
import com.mymusic.app.repositories.AdminRepository;
import com.mymusic.app.repositories.TrendRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TrendServices {
    @Autowired
    TrendRepository trendRepository;
    @Autowired
    AdminRepository adminRepository;

    public ResponseEntity<ResponseTrendModel> getAllTrend(String code) {
        try {
            List<AdminModel> check = adminRepository.findAll();
            if (check.get(0).getCode().equals(code)) {
                List<TrendModel> found = trendRepository.findAll();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseTrendModel(true, "success", found));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseTrendModel(false, "You are not admin", null));
        } catch (Exception e) {
            throw e;
        }
    }

    public void accessSong() {
        try {
            Optional<TrendModel> found = trendRepository.findByIsSongTrue();
            long newCount = found.get().getAccessCount() + 1;
            found.get().setAccessCount(newCount);
            trendRepository.save(found.get());
        } catch (Exception e) {
            throw e;
        }
    }

    public void accessSoundTrack() {
        try {
            Optional<TrendModel> found = trendRepository.findByIsSongFalse();
            long newCount = found.get().getAccessCount() + 1;
            found.get().setAccessCount(newCount);
            trendRepository.save(found.get());
        } catch (Exception e) {
            throw e;
        }
    }
}
