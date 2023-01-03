package com.nnk.springboot.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nnk.springboot.utils.CurrentUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private CurrentUser currentUser;

	public HomeController(CurrentUser currentUser) {
		this.currentUser = currentUser;
	}

	@RequestMapping("/")
	public String home(Model model, Principal principal) {
		String user = currentUser.getUserInfo(principal);
		System.out.println(user);
		log.info("display home page");
		return "home";
	}

	@RequestMapping("/admin/home")
	public String adminHome(Model model) {
		return "redirect:/bid/list";
	}

}
