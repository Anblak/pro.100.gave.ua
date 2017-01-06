package ua.game.pro.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import ua.game.pro.dto.DTOUtilMapper;
import ua.game.pro.entity.User;
import ua.game.pro.service.UserService;
import ua.game.pro.validator.UserValidationMessages;



@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/registration")
	public String newUser(Model model) {
//		model.addAttribute("userDTOs", DTOUtilMapper.usersToUsersDTO(userService.findAll()));
//		model.addAttribute("user", new User());
		return "views-base-registration";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, Model model) {

		try {
			userService.save(user);
		} catch (Exception e) {
			if(e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD)||
					e.getMessage().equals(UserValidationMessages.NAME_ALREADY_EXIST)){
				model.addAttribute("usernameException", e.getMessage());
			}else if(e.getMessage().equals(UserValidationMessages.EMPTY_EMAIl_FIELD )||
					e.getMessage().equals(UserValidationMessages.EMAIL_ALREADY_EXIST)){
				model.addAttribute("emailException", e.getMessage());
			}else if(e.getMessage().equals(UserValidationMessages.EMPTY_PASSWORD_FIELD)){
				model.addAttribute("passwordException", e.getMessage());
			}
			return "views-base-registration";
		}

		return "redirect:/registration";
	}

	@RequestMapping("/deleteUser/{id}")
	public String newUser(@PathVariable int id) {

		userService.delete(id);

		return "redirect:/registration";
	}

	@RequestMapping("/profile")
	public String profile(Principal principal, Model model) {

		User user = userService.findOne(Integer.parseInt(principal.getName()));

		model.addAttribute("user", user);

		return "views-filecontent-profile";
	}
}
