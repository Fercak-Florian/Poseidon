package com.nnk.springboot.services;

import java.util.List;

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
}
