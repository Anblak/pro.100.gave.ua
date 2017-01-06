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
		return "views-math-math";
	}
	
	
	//��� ��������� ������,��� �� ������� ������ � ���������� � ����� �� �������,����� ����� ������
	@RequestMapping(value="/doMath",method=RequestMethod.GET)
	public String doMath(@ModelAttribute BaseActionWrapper baseActionWrapper,Model model){
		
		String string = "";
		try {
			string = new Parset().HashSetIntegerToString(baseActionWrapper.getBaseActions());
		} catch (DiscreteMathException e) {
			string=e.getLocalizedMessage();
		} catch (Exception e) {
			string="formul/space was :[ "+e.getLocalizedMessage()+" ] ";
		}
		
		model.addAttribute("answer", string);
				
		return "views-math-math";
	}
	
	
	
}
