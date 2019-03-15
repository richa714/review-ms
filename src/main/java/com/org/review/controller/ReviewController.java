package com.org.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.review.exception.ReviewNotFoundException;
import com.org.review.model.Review;
import com.org.review.service.IReviewService;

@RestController
@RequestMapping("/api/{productId}/reviews")
public class ReviewController {

	@Autowired
	IReviewService reviewService;

	@GetMapping("/getReviews")
	public ResponseEntity<List<Review>> getReviews(@PathVariable int productId) {
		List<Review> reviewList = reviewService.getReviews(productId);
		//reviewList.forEach(System.out::println);
		return new ResponseEntity<List<Review>>(reviewList, HttpStatus.OK);

	}

//	@GetMapping("/getSpecificReview/{id}")
//	public ResponseEntity<Review> getSpecificReview(@PathVariable int id) throws ReviewNotFoundException {
//		Review review = reviewService.getSpecificReview(id);
//		return new ResponseEntity<Review>(review, HttpStatus.OK);
//	}

	@PostMapping("/addReview")
	public ResponseEntity<String> addReview(@PathVariable int productId,@RequestBody Review review) {
		reviewService.addReview(productId,review);
		return new ResponseEntity<String>("New Review Added Successfully", HttpStatus.OK);
	}

	@PutMapping("/updateReview/{reviewId}")
	public ResponseEntity<String> updateReview(@RequestBody Review review, @PathVariable int reviewId)
			throws ReviewNotFoundException {
		reviewService.updateReview(review, reviewId);
		return new ResponseEntity<String>("Review Updated Successfully", HttpStatus.OK);

	}

	@DeleteMapping("/deleteReview/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable int reviewId) throws ReviewNotFoundException {
		reviewService.deleteReview(reviewId);
		return new ResponseEntity<String>("Review Deleted Successfully", HttpStatus.OK);

	}

}
