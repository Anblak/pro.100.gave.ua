package ua.game.pro.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import BaseActions.BaseActions;
import DiscreteMath.Exceptions.DiscreteMathException;
import Parset.Parset;
import StringReader.FunctionString.FunctionString;
import ua.game.pro.wrapper.BaseActionWrapper;

@Controller
public class MathController {

	@RequestMapping("/math")
	public String Math() {
		return "math";
	}

	// тут твориться історія,тут ми передаєм стрінгу в контроллер і назад на
	// сторінку,тільки круту стрінгу

	@RequestMapping(value = "/domath", method = RequestMethod.GET)
	public String doMath(@ModelAttribute BaseActionWrapper baseActionWrapper, Model model)
			throws DiscreteMathException {
		String string = "";
		//// if(baseActionWrapper.getFormul()!=null&&baseActionWrapper.getSpace()!=null){
		//// string
		//// =parset.HashSetIntegerToString(baseActionWrapper.getBaseActions());
		//// model.addAttribute("answer",string );}
		//// }else{
		//// string="eror";
		//// model.addAttribute("answer",string );
		//// }
		//
		// HashSet<Integer > set = new FunctionString().stringFunction("(1^2)",
		//// "(1,4)(3,4)");
		//
		// for (Integer integer : set) {
		// System.out.println(integer);
		// }
		// string="test";
		// if(string==null){
		// System.out.println(string+"null");
		// }else{
		// System.out.println(string);
		// }
		// try{
		// System.out.println(new Parset().HashSetIntegerToString(set));
		// }catch (Exception e) {
		// System.out.println("error [ "+e+" ]");
		// }

		string = new Parset().HashSetIntegerToString(baseActionWrapper.getBaseActions());
		model.addAttribute("answer", string);

		
		Parset parset = new Parset();
		String answer = parset.HashSetIntegerToString(baseActionWrapper.getBaseActions());

		model.addAttribute("answer", string);

		return "math";

	}

}
