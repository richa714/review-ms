package com.org.review.service;

import java.util.List;

import com.org.review.exception.ReviewNotFoundException;
import com.org.review.model.Review;

public interface IReviewService {
	public List<Review> getReviews(int productId);

	//public Review getSpecificReview(int id) throws ReviewNotFoundException;

	public void addReview(int productId,Review review);

	public void updateReview(Review review, int reviewId) throws ReviewNotFoundException;

	public void deleteReview(int reviewId) throws ReviewNotFoundException;

}
