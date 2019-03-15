package com.org.review.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.org.review.helper.ReviewHelper;
import com.org.review.model.Review;
import com.org.review.service.IReviewService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ReviewController.class)
public class TestReviewController {

	@MockBean
	IReviewService mockReviewService;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testGetReviews() throws Exception {
		ReviewHelper helper = new ReviewHelper();
		String expectedReviewListResponse = helper.dummyReviewList();
		List<Review> expectedReviewList = helper.dummyAllReviews();
		when(mockReviewService.getReviews(1)).thenReturn(expectedReviewList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/101/reviews/getReviews")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals("Expected matches actual", expectedReviewListResponse, result.getResponse().getContentAsString());

	}

//	@Test
//	public void testGetSpecificReview() throws Exception {
//		ReviewHelper helper = new ReviewHelper();
//		ResponseEntity<Review> expectedReviewResponse = helper.dummySpecificReviewResponse();
//		Review expectedReview = helper.dummySpecificReview().get();
//		when(mockReviewService.getSpecificReview(1)).thenReturn(expectedReview);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/reviews/getSpecificReview/1")
//				.accept(MediaType.APPLICATION_JSON);
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		assertEquals("Expected matches actual", expectedReviewResponse.getBody().toString(),
//				result.getResponse().getContentAsString());
//
//	}

//	@Test
//	public void testAddReview() throws Exception {
//		ReviewHelper helper = new ReviewHelper();
//		ResponseEntity<List<Review>> expectedReviewListResponse = helper.dummyReviewResponse();
//		List<Review> expectedReviewList = helper.dummyAllReviews();
//		//when(mockReviewService.addReview(Mockito.any(Review.class)).thenReturn(expectedReviewList);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/reviews/getReviews")
//				.accept(MediaType.APPLICATION_JSON);
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		assertEquals("Expected matches actual", expectedReviewListResponse.getBody().toString(),
//				result.getResponse().getContentAsString());
//
//	}
//
//	@Test
//	public void testUpdateReview() throws Exception {
//		ReviewHelper helper = new ReviewHelper();
//		ResponseEntity<List<Review>> expectedReviewListResponse = helper.dummyReviewResponse();
//		List<Review> expectedReviewList = helper.dummyAllReviews();
//		when(mockReviewService.getReviews()).thenReturn(expectedReviewList);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/reviews/getReviews")
//				.accept(MediaType.APPLICATION_JSON);
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		
//		assertEquals("Expected matches actual", expectedReviewListResponse.getBody().toString(),
//				result.getResponse().getContentAsString());
//
//	}
//
//	@Test
//	public void testDeleteReview() throws Exception {
//		ReviewHelper helper = new ReviewHelper();
//		ResponseEntity<List<Review>> expectedReviewListResponse = helper.dummyReviewResponse();
//		List<Review> expectedReviewList = helper.dummyAllReviews();
//		when(mockReviewService.getReviews()).thenReturn(expectedReviewList);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/reviews/getReviews")
//				.accept(MediaType.APPLICATION_JSON);
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		assertEquals("Expected matches actual", expectedReviewListResponse.getBody().toString(),
//				result.getResponse().getContentAsString());
//
//	}

}
