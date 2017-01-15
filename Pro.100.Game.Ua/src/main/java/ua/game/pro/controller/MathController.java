package ua.game.pro.controller;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import resources.exceptions.ProjectExceptions;
import resources.parset.Parset;
import resources.wrapper.BaseActionWrapper;
import resources.wrapper.StringWrapper;

@Controller
public class MathController {

	private StringWrapper lg = new StringWrapper();

	@RequestMapping("/math")
	public String Math(@ModelAttribute String string, Model model) {
		// "img/LeftBodyDiv"+lg.getString()+".png"
		model.addAttribute("heder", ("img/heder" + lg.getString() + ".png"));
		model.addAttribute("LeftBodyDiv", ("img/LeftBodyDiv" + lg.getString() + ".png"));
//		model.addAttribute("lg",
//				"<div class=\"tiles\" > <form action=\"ua\" method=get class=\"formUA\"> <button class=\"buttonUA\" id=\"buttonUA\" style=\"\"> <p class=\"pUA\">UA</p></button></form><form action=\"ru\" method=get class=\"formRU\"><button class=\"buttonRU\" id=\"buttonRU\" style=\"\"><p class=\"pRU\">RU</p></button></form></div>");
		// model.addAttribute("lg", "do");

		return "views-math-math";
	}

	@RequestMapping("/ru")
	public String MathRu(Model model) {
		lg.setString("ru");

		// return "views-math-math";
		return "redirect:/";
	}

	@RequestMapping("/ua")
	public String MathUa(Model model) {
		lg.setString("ua");

		return "redirect:/";

	}

	// @RequestMapping("/ua.math")
	// public String MathUa(@ModelAttribute String string,Model model) {
	// model.addAttribute("heder", "img/hederUA.png");
	// model.addAttribute("LeftBodyDiv", "img/LeftBodyDivUA.png");
	// model.addAttribute("lg", "ua.do");
	// return "views-math-math";
	// }

	@RequestMapping(value = "do", method = RequestMethod.GET)
	public String doUa(@ModelAttribute BaseActionWrapper baseActionWrapper, Model model) {

		String string = "";
		String space = "";
		String resalt = "";

		try {
			string = "B:" + new Parset().HashSetIntegerToString(baseActionWrapper.getBaseActions());
			space = new Parset().ArrayListHashSetIntegerToStringStart(
					(ArrayList<HashSet<Integer>>) baseActionWrapper.list, baseActionWrapper.listSpace.size());

			resalt = new Parset().ArrayListHashSetIntegerToStringEnd(baseActionWrapper.list,
					baseActionWrapper.listSpace.size());
		} catch (ProjectExceptions e) {
			string = e.getLocalizedMessage();
		} catch (Exception e) {
			string = "formul/space was :[ " + e.getLocalizedMessage() + " ] ";
		}

		model.addAttribute("resalt", resalt);
		model.addAttribute("heder", "img/heder" + lg.getString() + ".png");
		model.addAttribute("LeftBodyDiv", ("img/LeftBodyDiv" + lg.getString() + ".png"));

		model.addAttribute("answer", string);
		model.addAttribute("space", space);
		return "views-math-math";
	}

	// @RequestMapping(value = "ua.do", method = RequestMethod.GET)
	// public String doRu(@ModelAttribute BaseActionWrapper baseActionWrapper,
	// Model model) {
	//
	// String string = "";
	// String space = "";
	// try {
	// string = "B:" + new
	// Parset().HashSetIntegerToString(baseActionWrapper.getBaseActions());
	// space = new
	// Parset().ArrayListHashSetIntegerToString(baseActionWrapper.list);
	// } catch (DiscreteMathException e) {
	// string = e.getLocalizedMessage();
	// } catch (Exception e) {
	// string = "formul/space was :[ " + e.getLocalizedMessage() + " ] ";
	// }
	// model.addAttribute("heder", "img/hederUA.png");
	// model.addAttribute("LeftBodyDiv", "img/LeftBodyDivUA.png");
	// model.addAttribute("answer", string);
	// model.addAttribute("space", space);
	// return "views-math-math";
	// }

}
