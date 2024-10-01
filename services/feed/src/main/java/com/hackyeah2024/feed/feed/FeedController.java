package com.hackyeah2024.feed.feed;


import com.hackyeah2024.feed.recommender.RecommenderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/feed")
@AllArgsConstructor
public class FeedController {

    private final RecommenderService recommenderService;
    private final RequesterMapper mapper;

    @GetMapping
    public ResponseEntity<?> getDefaultFeed(
            @RequestParam(name = "user-id") String userId,
            @RequestParam(name = "requesterType") String requesterType,
            @RequestParam(name = "requestedType") String requestedType
    ){
        var recommendation = recommenderService.getRecommendation(
                userId,
                mapper.toRequesterType(requesterType),
                mapper.toRequestedType(requestedType)
        );
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/for-ngo")
    public ResponseEntity<?> getNGOFeed(
            @RequestParam(name = "user-id") String userId,
            @RequestParam(name = "requestedType") String requestedType
    ){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/for-corporate")
    public ResponseEntity<?> getCorporateFeed(
            @RequestParam(name = "user-id") String userId,
            @RequestParam(name = "requestedType") String requestedType
    ){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/for-small-business")
    public ResponseEntity<?> getSmallBusinessFeed() {
        return ResponseEntity.ok().build();
    }

}
