package com.hackyeah2024.feed.feed;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/feed")
@AllArgsConstructor
public class FeedController {

    public ResponseEntity<?> getDefaultFeed(){
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getNGOFeed(){
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getCorporateFeed(){
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getSmallBusinessFeed() {
        return ResponseEntity.ok().build();
    }

}
