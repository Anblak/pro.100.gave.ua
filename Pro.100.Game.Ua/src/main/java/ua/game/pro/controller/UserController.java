package ua.game.pro.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.UUID;

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

import resources.parset.Parset;
import resources.wrapper.FileWrapper;
import resources.wrapper.StringWrapper;
import ua.game.pro.dto.DTOUtilMapper;
import ua.game.pro.dto.ProfesorDTO;
import ua.game.pro.editor.ProfesorEditor;
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
	private String profesor;

	@Autowired
	private UserService userService;

	@Autowired
	private FileUserService fileUserService;

	@Autowired
	private GroupOfUsersService groupOfUsersService;

	@Autowired
	private ProfesorService profesorService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Profesor.class, new ProfesorEditor(profesorService));
	}

	@RequestMapping("/registration")
	public String newUser(Model model) {
		// model.addAttribute("userDTOs",
		// DTOUtilMapper.usersToUsersDTO(userService.findAll()));
		// model.addAttribute("user", new User());

		return "views-base-registration";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, Model model) {

		try {
			userService.save(user);
		} catch (Exception e) {
			if (e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD)
					|| e.getMessage().equals(UserValidationMessages.NAME_ALREADY_EXIST)) {
				model.addAttribute("usernameException", e.getMessage());
			} else if (e.getMessage().equals(UserValidationMessages.EMPTY_EMAIl_FIELD)
					|| e.getMessage().equals(UserValidationMessages.EMAIL_ALREADY_EXIST)) {
				model.addAttribute("emailException", e.getMessage());
			} else if (e.getMessage().equals(UserValidationMessages.EMPTY_PASSWORD_FIELD)) {
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

	// =====================================================================
	@RequestMapping("/some")
	public String profile(Model model, Principal principal) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		HashMap<Integer, String> profesorMap = new Parset()
				.ArrayListToMap(DTOUtilMapper.profesorToProfesorDTO(profesorService.findAll()), user);
		model.addAttribute("profesor", new StringWrapper());
		model.addAttribute("profesorsMap", profesorMap);

		return "views-filecontent-some";
	}

	@RequestMapping("/profesort")
	public String profile(@ModelAttribute StringWrapper profesor, Model model) {

		model.addAttribute("profesor", profesor);
		this.profesor = profesor.getString();
		model.addAttribute("test", this.profesor);
		// String formAddFile="<form:form
		// action='./saveFile?${_csrf.parameterName}=${_csrf.token}'
		// method='post' enctype='multipart/form-data'> <input type='file'
		// name='multipartFile'> <button>safe file</button> </form:form> ";
		// model.addAttribute("saveFileForm", formAddFile);
		return "views-filecontent-profile";

	}

	// @RequestMapping(value = "/saveFile", method = RequestMethod.POST)
	// public String saveImage(Principal principal, @RequestParam FileWrapper
	// fileWrapper, Model model) {
	//
	// Profesor profesor =
	// profesorService.findOne(Integer.parseInt(fileWrapper.getProfesor()));
	//
	// User user = userService.findOne(Integer.parseInt(principal.getName()));
	//
	// fileUserService.saveFile(fileWrapper.getMultipartFile(), user, profesor);
	//
	// return "redirect:/profile";
	// }

	// =====================================================================
	@RequestMapping("/profile")
	public String profile(Principal principal, Model model) {

		User user = userService.findOne(Integer.parseInt(principal.getName()));
		model.addAttribute("user", user);
		//System.out.println(user.getGroup());

		if (user.getGroup()!=null) {
			String list = "<form:form method=\"POST\" commandName=\"profesor\" action=\"profesort\"><form:select path=\"string\" itemLable=\"name\" itemValue=\"id\">	<form:option value=\"-\" label=\"--Select profesor\" /><form:options items=\"${profesorMap}\" /></form:select><button>submit</button>	</form:form>";
			model.addAttribute("list", list);
			System.out.println(user.getGroup());
			HashMap<Integer, String> profesorMap = new Parset()
					.ArrayListToMap(DTOUtilMapper.profesorToProfesorDTO(profesorService.findAll()), user);

			model.addAttribute("profesorMap", profesorMap);
			model.addAttribute("profesor", new StringWrapper());
		}

		// model.addAttribute("uuidBody", uuidBody);

		// model.addAttribute("profesorID", new StringWrapper());

		//
		// try {
		// model.addAttribute("profesors", new Profesor());
		// model.addAttribute("profesorsDTOs",
		// DTOUtilMapper.profesorToProfesorDTO(profesorService.findAll()));
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// }

		return "views-filecontent-profile";
	}

	@RequestMapping(value = "/saveFile", method = RequestMethod.POST)
	public String saveImage(Principal principal, @RequestParam MultipartFile multipartFile, Model model) {

		int profesorID = Integer.parseInt(profesor);

		User user = userService.findOne(Integer.parseInt(principal.getName()));

		fileUserService.saveFile(multipartFile, user, profesorID);

		// Profesor profesorr= new Profesor("test");
		// profesorr.setId(1);

		// User user =
		// userService.findOne(Integer.parseInt(principal.getName()));
		// fileUserService.saveFile(multipartFile, user,profesorr);

		return "redirect:/profile";
	}

	@RequestMapping(value = "/saveProfesor", method = RequestMethod.POST)
	public String profesor(@RequestParam StringWrapper profesorID, Model model) {
		model.addAttribute("profesorID", profesorID);
		// this.profesor = profesor.getName();
		return "views-filecontent-profile";
	}

	// @RequestMapping(value = "/saveFile", method = RequestMethod.POST)
	// public String saveFile(@RequestParam MultipartFile multipartFile,
	// Principal principal, Model model) {
	//
	// int profesorID = Integer.parseInt(profesor);
	//
	// User user = userService.findOne(Integer.parseInt(principal.getName()));
	//
	// fileUserService.saveFile(multipartFile, user, profesorID);
	//
	// return "redirect:/profile";
	// }

	@RequestMapping(value = "/createGroup", method = RequestMethod.POST)
	public String createGroup(Principal principal, @ModelAttribute GroupOfUsers groupOfUsers, Model model) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		// if(user.getGroup().equals(null)){
		String uuid = UUID.randomUUID().toString();

		groupOfUsers.setUuid(uuid);

		String uuidBody = "hi, to add another users,give them this link    http://localhost:8080/Pro.100.Game.Ua/confirmAdd/"
				+ uuid;

		try {
			groupOfUsersService.save(groupOfUsers, user);
		} catch (Exception e) {
			if (e.getMessage().equals(GroupOfUsersValidationMessages.EMPTY_NAME_FIELD)) {
				model.addAttribute("nameException", e.getMessage());
			}
		}
		System.out.println(uuidBody);
		model.addAttribute("uuidBody", uuidBody);

		// }else{
		//
		// }
		return "redirect:/profile";
	}

	@RequestMapping("/deleteGroup/{id}")
	public String deleteGroup(Principal principal, @PathVariable int id) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		groupOfUsersService.delete(id, user);

		return "redirect:/profile";
	}

	@RequestMapping("/confirmAdd/{uuid}")
	public String newUserInGroup(Principal principal, @PathVariable String uuid) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		userService.update(user, groupOfUsersService.findByUUID(uuid));

		return "redirect:/profile";
	}

	@RequestMapping(value = "/newProfesor", method = RequestMethod.POST)
	public String newProfesor(Principal principal, @ModelAttribute Profesor profesor, Model model) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		profesor.setGroupOfUsers(user.getGroup());
		profesorService.save(profesor);

		return "redirect:/profile";

	}
}
