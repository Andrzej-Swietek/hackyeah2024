package com.hackyeah2024.feed;

import com.hackyeah2024.feed.config.RecommenderClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import recommender.RecommenderOuterClass.RequesterType;
import recommender.RecommenderOuterClass.RequesterType;
import recommender.RecommenderOuterClass.RequestedType;

@SpringBootTest
class FeedApplicationTests {

	@Test
	void contextLoads() {
		var recommenderClient = new RecommenderClient(
				"dfdfdfd",
				RequesterType.REQUESTER_NGO,
				RequestedType.REQUESTED_VOLUNTEER
		);
		recommenderClient.getRecommendations()
				.forEach(System.out::println);

		assert(!recommenderClient.getRecommendations().isEmpty());
	}

}
