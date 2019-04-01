package com.org.review.exception;




public class ReviewNotFoundException extends Exception {

	
	  public ReviewNotFoundException(int id) {
	  super("Review not found with id:: "+id); }
	 

}
