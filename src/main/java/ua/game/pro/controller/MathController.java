package ua.game.pro.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import resources.exceptions.ProjectExceptions;
import resources.parset.Parset;
import resources.wrapper.BaseActionWrapper;
import resources.wrapper.StringWrapper;
import ua.game.pro.entity.User;
import ua.game.pro.service.UserService;

@Controller
public class MathController {

	private StringWrapper lg = new StringWrapper();
	@Autowired
	private UserService userService;

	@RequestMapping("/math")
	public String Math(@ModelAttribute String string, Model model, Principal principal) {

		model.addAttribute("heder", ("img/heder" + lg.getString() + ".png"));
		model.addAttribute("LeftBodyDiv", ("img/LeftBodyDiv" + lg.getString() + ".png"));

		try {
			User user = userService.findOne(Integer.parseInt(principal.getName()));
			model.addAttribute("user", user);
			return "views-math-math";
		} catch (NullPointerException e) {
			return "views-math-math";
		} catch (Exception e) {
			return "views-math-math";
		}
	}

	@RequestMapping("/ru")
	public String MathRu(Model model) {
		lg.setString("ru");
		return "redirect:/";
	}

	@RequestMapping("/ua")
	public String MathUa(Model model) {
		lg.setString("ua");
		return "redirect:/";
	}


	@RequestMapping(value = "do", method = RequestMethod.GET)
	public String doUa(@ModelAttribute BaseActionWrapper baseActionWrapper, Model model) {

		String string;
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

}
