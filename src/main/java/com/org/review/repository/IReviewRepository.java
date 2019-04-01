package com.org.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.review.model.Review;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Integer> {

	//@Query("select rating,comments from Review where productId=:productId")
	public List<Review> findByProductId(int productId);

	@Modifying
	@Query("update Review set rating=:rating,comments=:comments where id=:id")
	public int updateReview(@Param("id")int id,@Param("rating") int rating,@Param("comments") String comments);

}
