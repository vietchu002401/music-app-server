package com.mymusic.app.services;

import java.util.List;

import javax.mail.internet.InternetAddress;

import com.mymusic.app.model.AdminModel;
import com.mymusic.app.model.RecommendSongModel;
import com.mymusic.app.model.ResponseRecommendSongModel;
import com.mymusic.app.model.SearchModel;
import com.mymusic.app.repositories.AdminRepository;
import com.mymusic.app.repositories.RecommendRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.mail.MailException;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class RecommendSongServices {

    @Autowired
    RecommendRepository recommendRepository;
    // @Autowired
    // private JavaMailSender javaMailSender;
    @Autowired
    AdminRepository adminRepository;

    public ResponseEntity<ResponseRecommendSongModel> getAllRecommendSong(SearchModel req) {
        try {
            List<AdminModel> check = adminRepository.findAll();
            if (check.get(0).getCode().equals(req.getCode())) {
                List<RecommendSongModel> found = recommendRepository.findAll();
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new ResponseRecommendSongModel(true, "Success", found));
            }else{
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseRecommendSongModel(false, "auth error", null));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseRecommendSongModel(false, "SERVER ERROR", null));
        }
    }

    public ResponseEntity<ResponseRecommendSongModel> createRecommendSong(RecommendSongModel req) {
        try {
            recommendRepository.insert(req);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseRecommendSongModel(true, "Created", null));
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseRecommendSongModel(false, "SERVER ERROR", null));
        }
    }

    public ResponseEntity<ResponseRecommendSongModel> deleteRecommendSong(String id) {
        try {
            recommendRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseRecommendSongModel(true, "Deleted", null));
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseRecommendSongModel(false, "SERVER ERROR", null));
        }
    }

    // public void sendSimpleEmail(String toEmail, String body, String subject) {
    //     try {
    //         MimeMessagePreparator preparator = (mimeMessage) -> {
    //             MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
    //             helper.setFrom(new InternetAddress("cuocsongmoihm@gmail.com", "Song and more"));
    //             helper.setTo(toEmail);
    //             helper.setSubject(subject);
    //             helper.setText(body, false);
    //         };
    //         javaMailSender.send(preparator);
    //     } catch (MailException exception) {
    //         throw exception;
    //     }
    // }

}
