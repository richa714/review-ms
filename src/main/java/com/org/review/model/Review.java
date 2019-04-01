package com.org.review.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Richa_Arora Review model class
 *
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review{

	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "review_generator")
	// @SequenceGenerator(name = "review_generator", sequenceName =
	// "review_sequence", allocationSize = 50)
	// @GeneratedValue
	private int id;

	private int productId;

	private int rating;

	private String comments;
}
