package com.suyash.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.suyash.flightreservation.entities.User;
import com.suyash.flightreservation.repos.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "login/registerUser";
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		//LOGGER.info("Inside register()" + user);
		//user.setPassword(encoder.encode(user.getPassword()));
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ "+user);
		
		userRepository.save(user);
		return "login/login";

	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		return "login/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		//boolean loginResponse = securityService.login(email, password);
		//LOGGER.info("Inside login() and the email is: " + email);
		
		User user = userRepository.findByEmail(email);
		if (user.getPassword().equals(password))
		{ 
			return "findFlights";} 
		else {
		  modelMap.addAttribute("msg", "Invalid user name or password .Please try again.");
		  }
		 
		
		userRepository.findByEmail(email);

		return "login/login";

	}
	
	
}
