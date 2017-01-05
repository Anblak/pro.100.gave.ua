package ua.game.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import BaseActions.BaseActions;
import DiscreteMath.Exceptions.DiscreteMathException;

@Controller
public class MathController {

	@RequestMapping("/math")
	public String hehMath() {
		return "math";
	}
	
	
	//тут твориться історія,тут ми передаєм стрінгу в контроллер і назад на сторінку,тільки круту стрінгу
	@RequestMapping(value="/math",method=RequestMethod.GET)
	public String doMath(@ModelAttribute String formul,@ModelAttribute String space,Model model){
		
		BaseActions baseActions=new BaseActions();
		try {
			baseActions.baseOperationOnSpace(formul, space);
		} catch (DiscreteMathException e) {}
		return "math";
	}
	
	
	
}
