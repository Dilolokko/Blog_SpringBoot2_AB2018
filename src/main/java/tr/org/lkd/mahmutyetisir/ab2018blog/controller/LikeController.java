package tr.org.lkd.mahmutyetisir.ab2018blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tr.org.lkd.mahmutyetisir.ab2018blog.Repository.LikeRepository;
import tr.org.lkd.mahmutyetisir.ab2018blog.model.Like;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    LikeRepository likeRepository;

    @GetMapping("")
    public ResponseEntity<List<Like>> getAllLike(){
        List<Like> likes = likeRepository.findAllLike();
        return ResponseEntity.ok(likes);
    }

    @PostMapping("")
    public ResponseEntity<Like> createNewLike(@Validated @RequestBody Like like){
        likeRepository.save(like);
        return ResponseEntity.ok(like);
    }
}
