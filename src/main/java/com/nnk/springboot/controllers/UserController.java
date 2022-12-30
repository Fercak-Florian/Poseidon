package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.services.UserService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Slf4j
@Controller
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/user/list")
	public String home(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		log.info("display user list");
		return "user/list";
	}

	@GetMapping("/user/add")
	public String addUser(User user) {
		log.info("display form to add user");
		return "user/add";
	}

	@PostMapping("/user/validate")
	public String validate(@Valid User user, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			userService.saveUser(user);
			log.info("successful user adding");
			return "redirect:/user/list";
		}
		return "user/add";
	}

	@GetMapping("/user/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		User user = userService.getUserById(id);
		user.setPassword("");
		model.addAttribute("user", user);
		log.info("display form to update user");
		return "user/update";
	}

	@PostMapping("/user/update/{id}")
	public String updateUser(@PathVariable("id") Integer id, @Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			log.info("failed to add user");
			return "user/update";
		}

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setId(id);
		userService.saveUser(user);
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		log.info("successful user updating");
		return "redirect:/user/list";
	}

	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model) {
		userService.deleteUser(id);
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		log.info("successful user deleting");
		return "redirect:/user/list";
	}
}
