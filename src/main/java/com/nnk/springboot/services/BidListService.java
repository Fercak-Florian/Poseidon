package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;

@Service
public class BidListService {
	
	private BidListRepository bidListRepository;
	
	public BidListService (BidListRepository bidListRepository) {
		this.bidListRepository = bidListRepository;
	}

	public List<BidList> getBids() {
		List<BidList> bidList = bidListRepository.findAll();
		return bidList;
	}
	
	public Optional<BidList> getBidById(int id){
		return bidListRepository.findById(id);
	}
	
	public BidList saveBids(BidList bid) {
		BidList bidList = bidListRepository.save(bid);
		return bidList;
	}
	
	public BidList updateBid(int id, BidList bid) {
		BidList bidToUpdate = bidListRepository.findById(id).get();
		bidToUpdate.setAccount(bid.getAccount());
		bidToUpdate.setType(bid.getType());
		bidToUpdate.setBidQuantity(bid.getBidQuantity());
		BidList updatedBid = bidListRepository.save(bidToUpdate);
		return updatedBid;
	}
	
	public void deleteBid(int id) {
		bidListRepository.deleteById(id);
	}
}
