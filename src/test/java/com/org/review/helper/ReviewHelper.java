package com.org.review.helper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.org.review.model.Review;

public class ReviewHelper {

	public List<Review> dummyAllReviews() {
		return Stream
				.of(new Review(501,101,3,"Good"),
						new Review(502,102,2,"Average"),
						new Review(503,102,1,"Bad"))
				.collect(Collectors.toList());
	}

	public Optional<Review> dummySpecificReview() {
		return Optional.of(new Review(501,101,3,"Good"));

	}

	public String dummyReviewList() {
		return "[{\"id\":501,\"productId\":101,\"rating\":3,\"comments\":\"Good\"},{\"id\":502,\"productId\":102,\"rating\":2,\"comments\":\"Average\"},{\"id\":503,\"productId\":102,\"rating\":1,\"comments\":\"Bad\"}]";

	}

	public ResponseEntity<Review> dummySpecificReviewResponse() {
		return new ResponseEntity<Review>(dummySpecificReview().get(), HttpStatus.OK);

	}

}
