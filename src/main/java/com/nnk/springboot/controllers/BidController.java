package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.services.BidService;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
public class BidController {
	// TODO: Inject Bid service
	
	private BidService bidService;

	public BidController(BidService bidListService) {
		this.bidService = bidListService;
	}

	@RequestMapping("/bid/list")
	public String home(Model model) {
		// TODO: call service find all bids to show to the view
		List<Bid> bids = bidService.getBids();
		model.addAttribute("bids", bids);
		log.info("display bid list");
		return "bid/list";
	}

	@GetMapping("/bid/add")
	public String addBidForm(Bid bid) {
		log.info("display form to add bid");
		return "bid/add";
	}

	@PostMapping("/bid/validate")
	public String validate(@Valid Bid bid, BindingResult result, Model model) {
		// TODO: check data valid and save to db, after saving return bid list
		if(!result.hasErrors()) {
			bidService.saveBid(bid);
			log.info("successful bid adding");
			return "redirect:/bid/list";
		}
		return "bid/add";
	}

	@GetMapping("/bid/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		// TODO: get Bid by Id and to model then show to the form
		Optional<Bid> optBid = bidService.getBidById(id);
		Bid bid = optBid.get();
		model.addAttribute("bid", bid);
		log.info("display form to update bid");
		return "bid/update";
	}

	@PostMapping("/bid/update/{id}")
	public String updateBid(@PathVariable("id") Integer id, @Valid Bid bid, BindingResult result,
			Model model) {
		// TODO: check required fields, if valid call service to update Bid and return
		// list Bid
		if(!result.hasErrors()) {
			bidService.updateBid(id, bid);
			log.info("successful bid updating");
			return "redirect:/bid/list";
		}
		return "bid/update";
	}

	@GetMapping("/bid/delete/{id}")
	public String deleteBid(@PathVariable("id") Integer id, Model model) {
		// TODO: Find Bid by Id and delete the bid, return to Bid list
		bidService.deleteBid(id);
		log.info("successful bid deleting");
		return "redirect:/bid/list";
	}
}
