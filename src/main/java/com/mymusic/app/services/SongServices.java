package com.mymusic.app.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mymusic.app.model.AdminModel;
import com.mymusic.app.model.ResponseSongModel;
import com.mymusic.app.model.SearchModel;
import com.mymusic.app.model.SongModel;
import com.mymusic.app.model.TopLoved;
import com.mymusic.app.model.UserModel;
import com.mymusic.app.repositories.AdminRepository;
import com.mymusic.app.repositories.SongRepository;
import com.mymusic.app.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SongServices {

    @Autowired
    SongRepository songRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<ResponseSongModel> getAllSong(String slice) {
        try {
            int sliceNumber = Integer.parseInt(slice);
            List<SongModel> found = songRepository.findAll();
            Collections.reverse(found);
            if (sliceNumber > found.size()) {
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseSongModel(true, "request success", found));
            } else {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new ResponseSongModel(true, "request success", found.subList(0, sliceNumber)));
            }
        } catch (Exception e) {
            System.out.println("SERVER ERROR");
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseSongModel(false, "SERVER ERROR", null));
        }
    }

    public ResponseEntity<ResponseSongModel> addSong(SongModel req) {
        try {
            Optional<SongModel> found = songRepository.findByCode(req.getCode());
            if (found.isPresent()) {
                return ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
                        .body(new ResponseSongModel(false, "The song is already added", null));
            } else {
                List<AdminModel> check = adminRepository.findAll();
                if (check.get(0).getCode().equals(req.getAuthCode())) {
                    req.setAuthCode("");
                    songRepository.insert(req);
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(new ResponseSongModel(true, "Added", null));
                } else {
                    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                            .body(new ResponseSongModel(false, "Auth error", null));
                }
            }
        } catch (Exception e) {
            System.out.println("SERVER ERROR");
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseSongModel(false, "SERVER ERROR", null));
        }
    }

    public ResponseEntity<ResponseSongModel> updateSong(SongModel req) {
        try {
            songRepository.findById(req.getId()).map(item -> {
                item.setImage(req.getImage());
                item.setName(req.getName());
                item.setSinger(req.getSinger());
                item.setComposer(req.getComposer());
                item.setCode(req.getCode());
                item.setLyric(req.getLyric());
                item.setIsSoundTrack(req.getIsSoundTrack());
                item.setIsSong(req.getIsSong());
                item.setMovie(req.getMovie());
                return songRepository.save(item);
            }).orElseGet(() -> {
                return songRepository.insert(req);
            });
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseSongModel(true, "updated", null));
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseSongModel(false, "SERVER ERROR", null));
        }
    }

    public ResponseEntity<ResponseSongModel> getSong(String id) {
        try {
            Optional<SongModel> found = songRepository.findById(id);
            if (found.isPresent()) {
                SongModel getSongModel = found.get();
                List<SongModel> list = getSongModel.getMovie().equals("No-result")
                        ? songRepository.findByComposerOrSinger(getSongModel.getComposer(), getSongModel.getSinger())
                        : songRepository.findByComposerOrSingerOrMovie(getSongModel.getComposer(),
                                getSongModel.getSinger(), getSongModel.getMovie());
                list.add(getSongModel);
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseSongModel(true, "get success", list));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseSongModel(false, "NOT FOUND", null));
            }
        } catch (Exception e) {
            System.out.println("SERVER ERROR");
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseSongModel(false, "SERVER ERROR", null));
        }
    }

    public ResponseEntity<ResponseSongModel> deleteSong(String id) {
        try {
            songRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseSongModel(true, "deleted", null));
        } catch (Exception e) {
            System.out.println("SERVER ERROR");
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseSongModel(false, "SERVER ERROR", null));
        }
    }

    public ResponseEntity<ResponseSongModel> getSearchSong(SearchModel req) {
        try {
            if (req.getIsSong() == req.getIsSoundTrack() == true) {
                List<SongModel> found = songRepository.findAll().stream()
                        .filter(item -> item.getName().toLowerCase().contains(req.getKey())
                                || item.getMovie().toLowerCase().contains(req.getKey())
                                || item.getSinger().toLowerCase().contains(req.getKey())
                                || item.getComposer().toLowerCase().contains(req.getKey()))
                        .collect(Collectors.toList());
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseSongModel(true, "success", found));
            } else {
                List<SongModel> found = songRepository.findAll().stream()
                        .filter(item -> (item.getName().toLowerCase().contains(req.getKey())
                                || item.getMovie().toLowerCase().contains(req.getKey())
                                || item.getSinger().toLowerCase().contains(req.getKey())
                                || item.getComposer().toLowerCase().contains(req.getKey()))
                                && (item.getIsSong() == req.getIsSong()
                                        && item.getIsSoundTrack() == req.getIsSoundTrack()))
                        .collect(Collectors.toList());
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseSongModel(true, "success", found));
            }
        } catch (Exception e) {
            System.out.println("SERVER ERROR");
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseSongModel(false, "SERVER ERROR", null));
        }
    }

    public ResponseEntity<ResponseSongModel> getFavorites(UserModel req) {
        try {
            List<SongModel> found = songRepository.findByIdIn(req.getLiked());
            if (found.size() > 0) {
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseSongModel(true, "success", found));
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseSongModel(false, "empty", null));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseSongModel> adminSearchSong(SearchModel req) {
        try {
            List<AdminModel> check = adminRepository.findAll();
            if (check.get(0).getCode().equals(req.getCode())) {
                List<SongModel> found = songRepository.findAll().stream()
                        .filter(item -> (item.getName().toLowerCase().contains(req.getKey())
                                || item.getMovie().toLowerCase().contains(req.getKey())
                                || item.getSinger().toLowerCase().contains(req.getKey()))
                                || item.getComposer().toLowerCase().contains(req.getKey()))
                        .collect(Collectors.toList());
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseSongModel(true, "success", found));
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseSongModel(false, "wrong auth", null));
            }
        } catch (Exception e) {
            throw e;
        }
    }


    private static List<String> removeLoop(List<String> list){
		List<String> newList = new ArrayList<>();
		list.forEach(item->{
			if(!newList.contains(item)){
				newList.add(item);
			}
		});
		return newList;
	}

    private static List<SongModel> afterSort(List<SongModel> topLoved, List<String> newList){
        List<SongModel> newTopLoved = new ArrayList<>();
        for(int i=0;i<newList.size();i++){
            for(int j=0;j<topLoved.size();j++){
                if(topLoved.get(j).getId().equals(newList.get(i))){
                    newTopLoved.add(topLoved.get(j));
                }
            }
        }

        return newTopLoved;
    }
    public ResponseEntity<ResponseSongModel> getTopLoved(String slice) {
        try {
            int sliceNumber = Integer.parseInt(slice);
            List<UserModel> allUsers = userRepository.findAll();
            List<String> allLoved = new ArrayList<>();
            for (int i = 0; i < allUsers.size(); i++) {
                allLoved = Stream.of(allLoved, allUsers.get(i).getLiked()).flatMap(List::stream)
                        .collect(Collectors.toList());
            }
            List<TopLoved> info = new ArrayList<>();
            for (int j = 0; j < allLoved.size(); j++) {
                int count = 0;
                for (int i = 0; i < allLoved.size(); i++) {
                    if (allLoved.get(j).equals(allLoved.get(i))) {
                        count++;
                    }
                }
                TopLoved element = new TopLoved(allLoved.get(j), count);
                info.add(element);
            }

            Collections.sort(info, (o1, o2) -> -o1.getCount() + o2.getCount());
            List<String> newIdList = info.stream().map(item->{
                return item.getId();
            }).collect(Collectors.toList());
            List<String> newList = removeLoop(newIdList);
            List<SongModel> topLoved = songRepository.findByIdIn(newList);
            List<SongModel> newTopLoved = afterSort(topLoved, newList);


            return sliceNumber > topLoved.size()
                    ? ResponseEntity.status(HttpStatus.OK).body(new ResponseSongModel(true, "success", newTopLoved))
                    : ResponseEntity.status(HttpStatus.OK)
                            .body(new ResponseSongModel(true, "success", newTopLoved.subList(0, sliceNumber)));
        } catch (Exception e) {
            throw e;
        }
    }
}
