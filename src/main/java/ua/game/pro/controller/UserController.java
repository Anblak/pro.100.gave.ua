package ua.game.pro.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
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

import resources.creatorHTMLTag.CreatorHTMLTag;
import resources.parset.Parset;

import resources.wrapper.StringWrapper;
import ua.game.pro.dto.DTOUtilMapper;

import ua.game.pro.editor.ProfessorEditor;
import ua.game.pro.entity.GroupOfUsers;
import ua.game.pro.entity.Professor;
import ua.game.pro.entity.enums.Role;
import ua.game.pro.entity.User;
import ua.game.pro.service.FileUserService;
import ua.game.pro.service.GroupOfUsersService;
import ua.game.pro.service.MailSenderService;
import ua.game.pro.service.ProfessorService;
import ua.game.pro.service.UserService;
import ua.game.pro.validator.GroupOfUsersValidationMessages;
import ua.game.pro.validator.UserValidationMessages;

@Controller
public class UserController {
	private String professor;

	@Autowired
	private UserService userService;

	@Autowired
	private FileUserService fileUserService;

	@Autowired
	private GroupOfUsersService groupOfUsersService;

	@Autowired
	private ProfessorService professorService;

	@Autowired
	private MailSenderService mailSenderService;

	private CreatorHTMLTag creator = new CreatorHTMLTag();

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Professor.class, new ProfessorEditor(professorService));
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

		String uuid = UUID.randomUUID().toString();

		user.setUuid(uuid);
		try {
			user.setPathImage("img/useranon.png");
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
		String theme = "Pro.100.Game.Ua";
		String mailBody = "<html lang='uk'><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /></head><body style='background:black;'><center><div style='background:yellow;width:400px;height:70px'><p>Welcome to site administration pro100.game.ua</p><p>if you want to continue to register at the site pro100.game.ua Click on the <a href='http://localhost:8080/Pro.100.Game.Ua/confirm/"
				+ uuid + "'>link</a></p><div></center></html></body>";

//		mailSenderService.sendMail(theme, mailBody, user.getEmail());

		return "redirect:/";
	}

	@RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
	public String confirm(@PathVariable String uuid) {

		User user = userService.findByUUID(uuid);
		user.setEnabled(true);

		userService.updateUser(user);

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
				.ArrayListToMap(DTOUtilMapper.profesorToProfesorDTO(professorService.findAll()), user);
		model.addAttribute("profesor", new StringWrapper());
		model.addAttribute("profesorsMap", profesorMap);

		return "views-filecontent-some";
	}

	@RequestMapping("/profesort")
	public String profile(@ModelAttribute StringWrapper profesor, Model model) {

		model.addAttribute("profesor", profesor);
		this.professor = profesor.getString();
		model.addAttribute("test", this.professor);
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
	// Professor professor =
	// professorService.findOne(Integer.parseInt(fileWrapper.getProfessor()));
	//
	// User user = userService.findOne(Integer.parseInt(principal.getName()));
	//
	// fileUserService.saveFile(fileWrapper.getMultipartFile(), user, professor);
	//
	// return "redirect:/profile";
	// }

	// =====================================================================
	@RequestMapping("/profile")
	public String profile(Principal principal, Model model) {
		try {

			User user = userService.findOne(Integer.parseInt(principal.getName()));
			model.addAttribute("user", user);
			HashMap<Integer, String> profesorMap;

			if (user.getRole() != Role.ROLE_USER && user.getRole() != Role.ROLE_ADMIN) {


				profesorMap = new Parset()
						.ArrayListToMap(DTOUtilMapper.profesorToProfesorDTO(professorService.findAll()), user);

			} else {
				profesorMap = new HashMap<>();

			}
			// groupUserAdd
			TreeMap<Integer, String> map = new TreeMap<>();
			for (User forUser : userService.findAll()) {
				if (forUser.getRole() == Role.ROLE_USER) {
					map.put(forUser.getId(), forUser.getName());
				}
			}

			StringWrapper string = new StringWrapper();
			string.setString(
					creator.form(creator.selectAll(map, "idUser", "5") + creator.button("submit", "button", "submit"),
							"addInGroupMessage", "get"));
			model.addAttribute("groupUserAdd", string);
			// end groupUserAdd
			model.addAttribute("profesorMap", profesorMap);
			model.addAttribute("profesor", new StringWrapper());
			// model.addAttribute("uuidBody", uuidBody);

			// model.addAttribute("profesorID", new StringWrapper());

			//
			// try {
			// model.addAttribute("profesors", new Professor());
			// model.addAttribute("profesorsDTOs",
			// DTOUtilMapper.profesorToProfesorDTO(professorService.findAll()));
			// } catch (Exception e) {
			// System.out.println(e.getMessage());
			// }

			return "views-filecontent-profile";

		} catch (NullPointerException e) {
			return "views-base-home";
		} catch (Exception e) {
			return "views-filecontent-profile";
		}
	}

	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public String saveImage(Principal principal, @RequestParam MultipartFile image) {

		User user = userService.findOne(Integer.parseInt(principal.getName()));

		userService.saveImage(principal, image);

		return "redirect:/user" + user.getId();
	}

	@RequestMapping(value = "/saveFile", method = RequestMethod.POST)
	public String saveImage(Principal principal, @RequestParam MultipartFile multipartFile, Model model,
			@ModelAttribute StringWrapper profesor) {

		int profesorID = Integer.parseInt(profesor.getString());

		User user = userService.findOne(Integer.parseInt(principal.getName()));

		fileUserService.saveFile(multipartFile, user, profesorID);

		// Professor profesorr= new Professor("test");
		// profesorr.setId(1);

		// User user =
		// userService.findOne(Integer.parseInt(principal.getName()));
		// fileUserService.saveFile(multipartFile, user,profesorr);

		return "redirect:/profile";
	}

	@RequestMapping(value = "/saveProfesor", method = RequestMethod.POST)
	public String profesor(@RequestParam StringWrapper profesorID, Model model) {
		model.addAttribute("profesorID", profesorID);
		// this.professor = professor.getName();
		return "views-filecontent-profile";
	}

	// @RequestMapping(value = "/saveFile", method = RequestMethod.POST)
	// public String saveFile(@RequestParam MultipartFile multipartFile,
	// Principal principal, Model model) {
	//
	// int profesorID = Integer.parseInt(professor);
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

		try {
			groupOfUsersService.save(groupOfUsers, user);
		} catch (Exception e) {
			if (e.getMessage().equals(GroupOfUsersValidationMessages.EMPTY_NAME_FIELD)) {
				model.addAttribute("nameException", e.getMessage());
			}
		}

		String uuidBody = "http://localhost:8080/Pro.100.Game.Ua/confirmAdd/" + uuid;

		model.addAttribute("groupUID", groupOfUsers);

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
	public String newProfesor(Principal principal, @ModelAttribute Professor professor, Model model) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		professor.setGroupOfUsers(user.getGroupOfUsers());
		professorService.save(professor);

		return "redirect:/profile";

	}

	@RequestMapping(value = "/user{id}", method = RequestMethod.GET)
	public String newProfesor(Principal principal, @PathVariable String id, Model model) {

		try {

			User user = userService.findOne(Integer.parseInt(principal.getName()));

			User userStore = userService.findOne(Integer.parseInt(id));

			model.addAttribute("userT", userStore);
			model.addAttribute("user", user);
			if (userStore.getGroupOfUsers() != null && user.getGroupOfUsers() != null) {

				if (userStore.getGroupOfUsers().getId() == user.getGroupOfUsers().getId()) {
					model.addAttribute("groupUID", user.getGroupOfUsers());
				}
			}

			return "views-user-user";
		} catch (NullPointerException e) {
			return "views-base-home";
		} catch (Exception e) {
			return "views-user-user";
		}
	}

	@RequestMapping(value = "/researchUserIntoMail", method = RequestMethod.GET)
	public String researchUserIntoMail(@RequestParam String email, Model model) {
		String uuid = UUID.randomUUID().toString();
		StringWrapper string = new StringWrapper();

		for (int i = 0; i < userService.findAll().size(); i++) {
			if (userService.findAll().get(i).getEmail().equals(email)) {
				User user = userService.findAll().get(i);
				user.setUuid(uuid);

				userService.updateUser(user);
				String theme = "Pro.100.Game.Ua";
				String mailBody = "<html lang='uk'><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /></head><body style='' ><center><div style='background:yellow;width:500px;height:auto'><p>Welcome to site <span>pro100.game.ua</span></p><p>If you want to change your password Click on the <a href='http://localhost:8080/Pro.100.Game.Ua/passwordResetRequest"
						+ userService.findAll().get(i).getUuid()
						+ "'>link</a></p><p>and wait for the message</p></div></center> </body></html>";
				string.setString("messages sent to email: " + userService.findAll().get(i).getEmail());
				model.addAttribute("messages", string);
				mailSenderService.sendMail(theme, mailBody, userService.findAll().get(i).getEmail());
			} else {
				string.setString("not found email: " + email);
				model.addAttribute("messages", string);
			}

		}

		return "views-tiles-template";

	}

	@RequestMapping(value = "/passwordResetRequest{id}", method = RequestMethod.GET)
	public String passwordResetRequest(@PathVariable String id, Model model) {

		User user = null;

		StringWrapper string = new StringWrapper();

		for (int i = 0; i < userService.findAll().size(); i++) {

			if (userService.findAll().get(i).getUuid().equals(id)) {

				user = userService.findAll().get(i);

			}

		}
		String mailBody = "<center>		<div  id='passwordchange' class='modal' style='display:block' ><form  action='passwordResetRequestm"
				+ user.getUuid()
				+ "' class='modal-content animate' method='get' style='width:450px;height:auto;'>					<div class='imgcontainer'><p><br></p><p>Welcome to site <span>pro100.game.ua</span></p><br><p>user</p>					<span						onclick='closeForm()'						class='close' title='Close Modal'>&times;</span><img src='"
				+ user.getPathImage() + "' alt='Avatar' class='avatar'><div ><br><p>name :" + user.getName()
				+ "</p><br><p>email: " + user.getEmail() + "</p><br><p>phone: " + user.getPhone()
				+ "</p><br></div>	<div class='container'>		<p></p>					<p> <p><label>Enter the new password</label></p><input name='password'		type='password'  placeholder='password' id='inputPasswordOne' style='width:90%;height:50px;margin-left:5%;margin-right:5%' ></p>			<p> <p><label>repeat password:</label></p><input 				type='password' placeholder='repeat password' id='inputPasswordTwo' onchange='checkPassword()' style='width:90%;height:50px;margin-left:5%;margin-right:5%'></p>	<button type='submit' disabled='disabled' id='mainButton' ><div onclick='checkPassword()' style='width:100%' >password change</div></button>		<!--  <input type='checkbox' checked='checked'> Remember me--></div>		<div class='container' style='background-color: #f1f1f1'>					<button type='button'			onclick='closeForm()'				class='cancelbtn' style='width:100%'>Cancel</button>	</form>			<div id='info'></div>			</div>			</div></div></center><script>function closeForm(){document.getElementById('passwordchange').style.display='none';}function checkPassword(){if((document.getElementById('inputPasswordTwo').value==document.getElementById('inputPasswordOne').value)&&(document.getElementById('inputPasswordTwo').value!='')){document.getElementById('mainButton').disabled='';document.getElementById('info').innerHTML='ready';document.getElementById('info').style.color='green';}else{document.getElementById('mainButton').disabled='disabled';document.getElementById('info').style.color='red';document.getElementById('info').innerHTML='error:[Passwords do not match]';}}</script> ";
		string.setString(mailBody);

		model.addAttribute("messages", string);
		return "views-base-home";
	}

	@RequestMapping(value = "/passwordResetRequestm{id}", method = RequestMethod.GET)
	public String recoverPassword(@PathVariable String id, @RequestParam String password, Model model) {

		User user = null;

		StringWrapper string = new StringWrapper();
		for (int i = 0; i < userService.findAll().size(); i++) {
			if (userService.findAll().get(i).getUuid().equals(id)) {
				user = userService.findAll().get(i);
				user.setUuid("");
				userService.updateUser(user);

			}
		}

		user.setPassword(password);
		userService.updatePassword(user);
		string.setString("Password Reset");
		model.addAttribute("messages", string);
		return "views-tiles-template";
	}

	@RequestMapping(value = "/addInGroupMessage", method = RequestMethod.GET)
	public String invited(@RequestParam String[] idUser, Principal principal) {

		User userCreator = userService.findOne(Integer.parseInt(principal.getName()));

		ArrayList<User> users = new ArrayList<>();
		for (String string : idUser) {
			users.add(userService.findOne(Integer.parseInt(string)));
		}

		for (int i = 0; i < users.size(); i++) {
			String uuid = UUID.randomUUID().toString();
			User user = users.get(i);

			user.setUuid(uuid);
			users.get(i).setUuid(uuid);
			userService.updateUser(user);

		}

		for (User user : users) {

			userService.updateUser(user);
			String theme = "Pro.100.Game.Ua";
			String mailBody = "<html lang='uk'><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /></head><body style='' ><center><div style='background:yellow;width:500px;height:auto'>"
					+ "<p>Welcome to site <span>pro100.game.ua</span></p>"
					+ "<p>You are invited to a group ___ , if you want to accept the invitation Click on the  "
					+ "<a href='http://localhost:8080/Pro.100.Game.Ua/addInGroup" + userCreator.getGroupOfUsers().getId() + "/"
					+ user.getUuid() + "'>link</a></p><p>and wait for the message</p></div></center> </body></html>";

			mailSenderService.sendMail(theme, mailBody, user.getEmail());

		}
		return "views-filecontent-profile";

	}

	@RequestMapping(value = "/addInGroup{id}/{uuid}", method = RequestMethod.GET)
	public String takeInvited(@PathVariable String uuid, @PathVariable String id) {

		User user = userService.findByUUID(uuid);

		GroupOfUsers group = groupOfUsersService.findOne(Integer.parseInt(id));

		user.setUuid("");

		userService.update(user, group);

		return "redirect:/";
	}

}
