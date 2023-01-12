package software.dev.backend.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import software.dev.backend.model.Posting;
import software.dev.backend.service.PostingService;



@RestController
@RequestMapping("/api")
public class PostingController {

    @Autowired
    PostingService postingService;

    @CrossOrigin
    @PostMapping("/posting")
    public ResponseEntity<String> createPost(@RequestBody String payload){
        Posting p;

        try {
            p = Posting.create(payload);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        postingService.createPost(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    
    }

    
}
