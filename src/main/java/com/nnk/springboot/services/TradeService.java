package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;

@Service
public class TradeService {

	private TradeRepository tradeRepository;
	
	public TradeService(TradeRepository tradeRepository) {
		this.tradeRepository = tradeRepository;
	}
	
	public List<Trade> getTrades(){
		return tradeRepository.findAll();
	}
	
	public Optional<Trade> getTradeById(int id){
		return tradeRepository.findById(id);
	}
	
	public Trade saveTrade(Trade trade) {
		return tradeRepository.save(trade);
	}
	
	public Trade updateTrade(int id, Trade trade) {
		Trade tradeToUpdate = tradeRepository.findById(id).get();
		tradeToUpdate.setAccount(trade.getAccount());
		tradeToUpdate.setType(trade.getType());
		return tradeRepository.save(tradeToUpdate);
	}
	
	public void deleteTrade(int id) {
		Trade trade = tradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid trade Id : " + id));
		tradeRepository.delete(trade);
	}
}
