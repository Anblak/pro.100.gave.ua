package ua.game.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home() {
	
		return "home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String anton() {
		
		return "redirect:/home";
	}

	@RequestMapping("/loginpage")
	public String login() {
		
		return "loginpage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout() {

		return "redirect:/";
	}
}
