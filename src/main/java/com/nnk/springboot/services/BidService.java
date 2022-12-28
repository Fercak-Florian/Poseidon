package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.repositories.BidRepository;

@Service
public class BidService {
	
	private BidRepository bidRepository;
	
	public BidService (BidRepository bidRepository) {
		this.bidRepository = bidRepository;
	}

	public List<Bid> getBids() {
		return bidRepository.findAll();
	}
	
	public Optional<Bid> getBidById(int id){
		return bidRepository.findById(id);
	}
	
	public Bid saveBid(Bid bid) {
		return bidRepository.save(bid);
	}
	
	public Bid updateBid(int id, Bid bid) {
		Bid bidToUpdate = bidRepository.findById(id).get();
		bidToUpdate.setAccount(bid.getAccount());
		bidToUpdate.setType(bid.getType());
		bidToUpdate.setBidQuantity(bid.getBidQuantity());
		Bid updatedBid = bidRepository.save(bidToUpdate);
		return updatedBid;
	}
	
	public void deleteBid(int id) {
		Bid bid = bidRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid bid Id : " + id));
		bidRepository.delete(bid);
	}
}
