package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.TradeService;

import java.util.List;

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
public class TradeController {
    // TODO: Inject Trade service
	
	private TradeService tradeService;
	
	public TradeController(TradeService tradeService) {
		this.tradeService = tradeService;
	}

    @RequestMapping("/trade/list")
    public String home(Model model)
    {
        // TODO: find all Trade, add to model
    	List<Trade> trades = tradeService.getTrades();
    	model.addAttribute("trades", trades);	
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(/*Trade bid*/) {
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@ModelAttribute @Validated Trade trade, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Trade list
    	tradeService.saveTrade(trade);
        return "trade/add";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Trade by Id and to model then show to the form
    	Trade trade = tradeService.getTradeById(id).get();
    	model.addAttribute("trade", trade);
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Validated Trade trade,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Trade and return Trade list
    	tradeService.updateTrade(id, trade);
    	return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Trade by Id and delete the Trade, return to Trade list
    	tradeService.deleteTrade(id);
        return "redirect:/trade/list";
    }
}
