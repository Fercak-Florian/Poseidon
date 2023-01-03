package com.nnk.springboot.controllers;
import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model model, Principal principal) {
		log.info("display home page");
		return "home";
	}

	@RequestMapping("/admin/home")
	public String adminHome(Model model) {
		return "redirect:/bid/list";
	}
}
