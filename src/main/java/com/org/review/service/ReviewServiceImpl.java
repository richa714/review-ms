package com.org.review.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.review.exception.ReviewNotFoundException;
import com.org.review.model.Review;
import com.org.review.repository.IReviewRepository;

@Component
public class ReviewServiceImpl implements IReviewService {

	@Autowired
	IReviewRepository reviewRepository;

	@Override
	public List<Review> getReviews(int productId) {
		return reviewRepository.findByProductId(productId);
	}

	@Override
	public void addReview(int productId, Review review) {
		review.setProductId(productId);
		reviewRepository.save(review);

	}

	@Override
	@Transactional
	public void updateReview(Review review, int reviewId) throws ReviewNotFoundException {
		Optional<Review> reviewInDb = reviewRepository.findById(reviewId);
		if (!reviewInDb.isPresent())
			throw new ReviewNotFoundException(reviewId);
		review.setId(reviewId);
		reviewRepository.updateReview(review.getId(), review.getRating(), review.getComments());

	}

	@Override
	public void deleteReview(int reviewId) throws ReviewNotFoundException {
		Optional<Review> reviewInDb = reviewRepository.findById(reviewId);

		if (!reviewInDb.isPresent())
			throw new ReviewNotFoundException(reviewId);

		reviewRepository.deleteById(reviewId);

	}

//	@Override
//	public Review getSpecificReview(int id) throws ReviewNotFoundException {
//		Optional<Review> reviewInDb = reviewRepository.findById(id);
//		if (!reviewInDb.isPresent())
//			throw new ReviewNotFoundException(id);
//		System.out.println(reviewInDb.get());
//		return reviewInDb.get();
//	}

}
