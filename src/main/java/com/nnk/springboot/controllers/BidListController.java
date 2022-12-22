package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.BidListService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*import javax.validation.Valid;*/

@Controller
public class BidListController {
	// TODO: Inject Bid service
	
	private BidListService bidListService;

	public BidListController(BidListService bidListService) {
		this.bidListService = bidListService;
	}

	@RequestMapping("/bidList/list")
	public String home(Model model) {
		// TODO: call service find all bids to show to the view
		List<BidList> bidList = bidListService.getBids();
		model.addAttribute("bidList", bidList);
		return "bidList/list";
	}

	@GetMapping("/bidList/add")
	public String addBidForm(/*BidList bid*/) {
		return "bidList/add";
	}

	@PostMapping("/bidList/validate")
	public String validate(@ModelAttribute @Validated BidList bid, BindingResult result, Model model) {
		// TODO: check data valid and save to db, after saving return bid list
		bidListService.saveBids(bid);
		return "bidList/add";
	}

	@GetMapping("/bidList/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		// TODO: get Bid by Id and to model then show to the form
		System.out.println(id);
		Optional<BidList> optBid = bidListService.getBidById(id);
		BidList bid = optBid.get();
		model.addAttribute("bidList", bid);
		return "bidList/update";
	}

	@PostMapping("/bidList/update/{id}")
	public String updateBid(@PathVariable("id") Integer id,@ModelAttribute @Validated BidList bidList, BindingResult result,
			Model model) {
		// TODO: check required fields, if valid call service to update Bid and return
		// list Bid
		bidListService.updateBid(id, bidList);
		return "redirect:/bidList/list";
	}

	@GetMapping("/bidList/delete/{id}")
	public String deleteBid(@PathVariable("id") Integer id, Model model) {
		// TODO: Find Bid by Id and delete the bid, return to Bid list
		bidListService.deleteBid(id);
		return "redirect:/bidList/list";
	}
}
