package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;

@Service
public class RatingService {
	
	private RatingRepository ratingRepository;
	
	public RatingService(RatingRepository ratingRepository) {
		this.ratingRepository = ratingRepository;
	}
	
	public List<Rating> getRatings(){
		return ratingRepository.findAll();
	}
	
	public Optional<Rating> getRatingById(int id){
		return ratingRepository.findById(id);
	}
	
	public Rating saveRating(Rating rating) {
		return ratingRepository.save(rating);
	}
	
	public Rating updateRating(int id, Rating rating) {
		Rating ratingToUpdate = ratingRepository.findById(id).get();
		ratingToUpdate.setMoodysRating(rating.getMoodysRating());
		ratingToUpdate.setSandRating(rating.getSandRating());
		ratingToUpdate.setFitchRating(rating.getFitchRating());
		ratingToUpdate.setOrderNumber(rating.getOrderNumber());
		return ratingRepository.save(ratingToUpdate);
	}
	
	public void deleteRating(int id) {
		Rating rating = ratingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rating Id : " + id));
		ratingRepository.delete(rating);
	}
}
