package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.services.CurvePointService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Slf4j
@Controller
public class CurveController {

	private CurvePointService curvePointService;

	public CurveController(CurvePointService curvePointService) {
		this.curvePointService = curvePointService;
	}

	@RequestMapping("/curvePoint/list")
	public String home(Model model) {
		List<CurvePoint> curvePoints = curvePointService.getCurvePoints();
		model.addAttribute("curvePoints", curvePoints);
		log.info("display CurvePoint list");
		return "curvePoint/list";
	}

	@GetMapping("/curvePoint/add")
	public String addBidForm(CurvePoint curvePoint) {
		log.info("display form to add CurvePoint");
		return "curvePoint/add";
	}

	@PostMapping("/curvePoint/validate")
	public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			curvePointService.saveCurvePoint(curvePoint);
			log.info("successful CurvePoint adding");
			return "redirect:/curvePoint/list";
		}
		return "curvePoint/add";
	}

	@GetMapping("/curvePoint/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		CurvePoint curvePoint = curvePointService.getCurvePointById(id);
		model.addAttribute("curvePoint", curvePoint);
		log.info("display form to update CurvePoint");
		return "curvePoint/update";
	}

	@PostMapping("/curvePoint/update/{id}")
	public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint, BindingResult result,
			Model model) {
		if (!result.hasErrors()) {
			curvePointService.updateCurvePoint(id, curvePoint);
			log.info("Successful CurvePoint updating");
			return "redirect:/curvePoint/list";
		}
		return "curvePoint/add";
	}

	@GetMapping("/curvePoint/delete/{id}")
	public String deleteBid(@PathVariable("id") Integer id, Model model) {
		curvePointService.deleteCurvePoint(id);
		log.info("successful CurvePoint deleting");
		return "redirect:/curvePoint/list";
	}
}
