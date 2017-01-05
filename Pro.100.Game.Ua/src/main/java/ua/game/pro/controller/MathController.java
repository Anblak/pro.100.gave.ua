package ua.game.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import BaseActions.BaseActions;
import DiscreteMath.Exceptions.DiscreteMathException;
import Parset.Parset;
import ua.game.pro.wrapper.BaseActionWrapper;

@Controller
public class MathController {

	@Autowired
	private Parset parset; 
	
	
	@RequestMapping("/math")
	public String hehMath() {
		return "math";
	}
	
	
	//тут твориться історія,тут ми передаєм стрінгу в контроллер і назад на сторінку,тільки круту стрінгу
	@RequestMapping(value="/math",method=RequestMethod.GET)
	public String doMath(@ModelAttribute BaseActionWrapper baseActionWrapper,Model model){
		
		model.addAttribute("answer", parset.HashSetIntegerToString(baseActionWrapper.getBaseActions()));
			
		return "math";
	}
	
	
	
}
