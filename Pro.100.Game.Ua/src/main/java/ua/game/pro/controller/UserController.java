package ua.game.pro.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



import ua.game.pro.dto.DTOUtilMapper;
import ua.game.pro.editor.ProfesorEditor;
import ua.game.pro.entity.FileUser;
import ua.game.pro.entity.GroupOfUsers;
import ua.game.pro.entity.Profesor;
import ua.game.pro.entity.User;
import ua.game.pro.service.FileUserService;
import ua.game.pro.service.GroupOfUsersService;
import ua.game.pro.service.ProfesorService;
import ua.game.pro.service.UserService;
import ua.game.pro.validator.GroupOfUsersValidationMessages;
import ua.game.pro.validator.UserValidationMessages;



@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileUserService fileUserService;
	
	@Autowired
	private GroupOfUsersService groupOfUsersService;
	
	@Autowired
	private ProfesorService profesorService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Profesor.class, new ProfesorEditor(profesorService));
	}

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

		return "redirect:/";
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
		model.addAttribute("profesors", new Profesor());
		model.addAttribute("profesorsDTOs", DTOUtilMapper.profesorToProfesorDTO(profesorService.findAll()));
		
		return "views-filecontent-profile";
	}
	
	@RequestMapping(value = "/saveFile", method = RequestMethod.POST)
	public String saveImage(Profesor profesor,Principal principal,@RequestParam MultipartFile multipartFile,Model model){
	
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		fileUserService.saveFile(multipartFile, user,profesor);
		return "redirect:/profile";
	}
	
	@RequestMapping(value="/createGroup",method=RequestMethod.POST)
	public String createGroup(Principal principal, @ModelAttribute GroupOfUsers groupOfUsers,Model model) throws Exception{
//		User user = userService.findOne(Integer.parseInt(principal.getName()));
//		if(user.getGroup().equals(null)){
		
		
			try{
				groupOfUsersService.save(groupOfUsers);
			}catch (Exception e) {
				if(e.getMessage().equals(GroupOfUsersValidationMessages.EMPTY_NAME_FIELD)){
					model.addAttribute("nameException", e.getMessage());
				}
			}
			
//		}else{
//				
//		}
		return "redirect:/profile";
	}
	@RequestMapping(value="/newProfesor",method=RequestMethod.POST)
	public String newProfesor(@ModelAttribute Profesor profesor,Model model){
		profesorService.save(profesor);
	
		return "redirect:/profile";
		
	}
}
