package ua.game.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class AdminController {
	@RequestMapping("/admin")
	public String newAuthor() {
		return "views-admin-admin";
	}
}
