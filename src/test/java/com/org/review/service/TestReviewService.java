package com.org.review.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.org.review.exception.ReviewNotFoundException;
import com.org.review.helper.ReviewHelper;
import com.org.review.model.Review;
import com.org.review.repository.IReviewRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TestReviewService {

	@Mock
	IReviewRepository mockReviewRepository;

	@InjectMocks
	IReviewService mockReviewService = new ReviewServiceImpl();

	@Test
	public void testGetReviews() {
		ReviewHelper helper = new ReviewHelper();
		List<Review> expectedReviewList = helper.dummyAllReviews();
		when(mockReviewRepository.findAll()).thenReturn(expectedReviewList);
		List<Review> actualReviewList = mockReviewService.getReviews(101);
		assertEquals("Actual matches expected", expectedReviewList.size(), actualReviewList.size());

	}

//	@Test
//	public void testGetSpecificReview() throws ReviewNotFoundException {
//		ReviewHelper helper = new ReviewHelper();
//		Optional<Review> expectedReview = helper.dummySpecificReview();
//		when(mockReviewRepository.findById(1)).thenReturn(expectedReview);
//		Review actualReview = mockReviewService.getSpecificReview(1);
//		assertEquals("Actual matches expected", expectedReview.get().getComments(), actualReview.getComments());
//
//	}

//	@Test(expected = ReviewNotFoundException.class)
//	public void testExceptionForGetSpecificReview() throws ReviewNotFoundException {
//		mockReviewService.getSpecificReview(5);
//	}

	@Test
	public void testUpdateReview() throws ReviewNotFoundException {
		ReviewHelper helper = new ReviewHelper();
		Optional<Review> reviewToUpdate = helper.dummySpecificReview();
		when(mockReviewRepository.findById(0)).thenReturn(reviewToUpdate);
		mockReviewService.updateReview(reviewToUpdate.get(), 0);
		verify(mockReviewRepository, times(1)).save(reviewToUpdate.get());

	}

	@Test
	public void testAddReview() throws ReviewNotFoundException {
		ReviewHelper helper = new ReviewHelper();
		Optional<Review> reviewToAdd = helper.dummySpecificReview();
		mockReviewService.addReview(101,reviewToAdd.get());
		verify(mockReviewRepository, times(1)).save(reviewToAdd.get());

	}

}
