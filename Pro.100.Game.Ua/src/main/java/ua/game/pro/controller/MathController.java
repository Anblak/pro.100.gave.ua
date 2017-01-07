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

	@RequestMapping("/ru.math")
	public String MathRu(Model model) {
		model.addAttribute("heder", "img/hederRU.png");
		model.addAttribute("LeftBodyDiv", "img/LeftBodyDivRU.png");
		model.addAttribute("lg", "ru.do");
		
		return "views-math-math";
	}

	@RequestMapping("/ua.math")
	public String MathUa(Model model) {
		model.addAttribute("heder", "img/hederUA.png");
		model.addAttribute("LeftBodyDiv", "img/LeftBodyDivUA.png");
		model.addAttribute("lg", "ua.do");
		return "views-math-math";
	}

	
	@RequestMapping(value = "ru.do", method = RequestMethod.GET)
	public String doUa(@ModelAttribute BaseActionWrapper baseActionWrapper, Model model) {

		String string = "";
		String space = "";
		try {
			string = "B:" + new Parset().HashSetIntegerToString(baseActionWrapper.getBaseActions());
			space = new Parset().ArrayListHashSetIntegerToString(baseActionWrapper.list);
		} catch (DiscreteMathException e) {
			string = e.getLocalizedMessage();
		} catch (Exception e) {
			string = "formul/space was :[ " + e.getLocalizedMessage() + " ] ";
		}

		model.addAttribute("heder", "img/hederRU.png");
		model.addAttribute("LeftBodyDiv", "img/LeftBodyDivRU.png");
		
		model.addAttribute("answer", string);
		model.addAttribute("space", space);
		return "views-math-math";
	}

	@RequestMapping(value = "ua.do", method = RequestMethod.GET)
	public String doRu(@ModelAttribute BaseActionWrapper baseActionWrapper, Model model) {

		String string = "";
		String space = "";
		try {
			string = "B:" + new Parset().HashSetIntegerToString(baseActionWrapper.getBaseActions());
			space = new Parset().ArrayListHashSetIntegerToString(baseActionWrapper.list);
		} catch (DiscreteMathException e) {
			string = e.getLocalizedMessage();
		} catch (Exception e) {
			string = "formul/space was :[ " + e.getLocalizedMessage() + " ] ";
		}
		model.addAttribute("heder", "img/hederUA.png");
		model.addAttribute("LeftBodyDiv", "img/LeftBodyDivUA.png");
		model.addAttribute("answer", string);
		model.addAttribute("space", space);
		return "views-math-math";
	}

}
