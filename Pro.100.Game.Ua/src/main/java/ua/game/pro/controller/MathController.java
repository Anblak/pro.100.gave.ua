package ua.game.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import DiscreteMath.Exceptions.DiscreteMathException;
import Parset.Parset;
import ua.game.pro.wrapper.BaseActionWrapper;

@Controller
public class MathController {

	@RequestMapping("/math")
	public String hehMath() {
		return "math";
	}
	
	
	//тут твориться історія,тут ми передаєм стрінгу в контроллер і назад на сторінку,тільки круту стрінгу
	@RequestMapping(value="/doMath",method=RequestMethod.GET)
	public String doMath(@ModelAttribute BaseActionWrapper baseActionWrapper,Model model)throws DiscreteMathException {
		
		String string = "";
		string = new Parset().HashSetIntegerToString(baseActionWrapper.getBaseActions());
		model.addAttribute("answer", string);
				
		return "math";
	}
	
	
	
}
