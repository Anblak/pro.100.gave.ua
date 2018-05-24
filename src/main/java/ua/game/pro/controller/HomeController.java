package ua.game.pro.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import resources.creatorHTMLTag.CreatorHTMLTag;
import ua.game.pro.entity.User;
import ua.game.pro.service.UserService;

@Controller
public class HomeController {
	@Autowired
	UserService userService;
	CreatorHTMLTag creator = new CreatorHTMLTag();


	@RequestMapping(value = { "/", "home" }, method = RequestMethod.GET)
	public String home(Principal principal, Model model) {
		if (principal != null) {

			User user = userService.findOne(Integer.parseInt(principal.getName()));
//			model.addAttribute("user", user);
			/* add music in model */



			// creator.li(creator.a(href, "", "", creator.div(input, ""
			// ,"container
			// musicDiv")),"current-song");

			// <li class="current-song"><
			//
			// a href="resources/test1.mp3"><div
			// class="container musicDiv">test1</div></a></li>
			//
			// <li><
			// a href="resources/test2.mp3"><div
			// class="container musicDiv">test2</div></a></li>


			/* end add music in model */
		}
		return "views-base-home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String anton() {

		return "redirect:/home";
	}

	@RequestMapping("/loginpage")
	public String login() {

		return "views-base-loginpage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout() {

		return "redirect:/";
	}
}
