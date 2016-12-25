package ua.game.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MathController {

	@RequestMapping("/math")
	public String newAuthor() {
		return "math";
	}
}
