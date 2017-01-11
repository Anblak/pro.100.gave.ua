package ua.game.pro.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import resources.creatorHTMLTag.CreatorHTMLTag;
import ua.game.pro.entity.FileUser;
import ua.game.pro.entity.Profesor;
import ua.game.pro.entity.User;
import ua.game.pro.service.FileUserService;
import ua.game.pro.service.GroupOfUsersService;
import ua.game.pro.service.ProfesorService;
import ua.game.pro.service.UserService;

@Controller
public class GroupController {
	CreatorHTMLTag creator = new CreatorHTMLTag();
	@Autowired
	private UserService userService;
	@Autowired
	private GroupOfUsersService groupService;
	@Autowired
	private FileUserService fileUserService;
	@Autowired
	private ProfesorService profesorService;

	@RequestMapping(value = "/group", method = RequestMethod.GET)
	public String outPrintGrup(Model model, Principal principal) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		String groupName = user.getGroup().getName();

		String input = creator.p(groupName, "p", "width:150px;height: 50px;")+creator.form(creator.button("profesor", "button", "submit"), "profesor", "get");

		String div = creator.div(input, "width:300px;height:100px;background:green;display:inline-block;", "div");

		model.addAttribute("body", div);

		return "views-filecontent-group";
	}

	@RequestMapping(value = "profesor", method = RequestMethod.GET)
	public String outPrintProfesor(Model model, Principal principal) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		List<Profesor> listProfesor = profesorService.findAll();
		String body = "";
		for (Profesor profesor : listProfesor) {
			if(profesor.getGroupOfUsers().getId()==user.getGroup().getId()){
				
			String input = creator.p(profesor.getName(), "p", "width:150px;height: 50px;")
					+ creator.form(creator.button("go file of profesorUser", "button", "submit"),
							"group/profesor/" + profesor.getId(), "get");
			body += (" " + creator.div(input, "width:300px;height:100px;background:green;display:inline-block;", "div") + " ");
			}

		}

		model.addAttribute("body", body);

		return "views-filecontent-group";
	}

	@RequestMapping(value = "group/profesor/{idp}", method = RequestMethod.GET)
	public String outPrintUserOfGrup(Model model, Principal principal, @PathVariable String idp) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		String body = "";

		for (User user2 : userService.findAll()) {
			if (user.getGroup().getId() == user2.getGroup().getId() && user2.getGroup() != null) {
				String input = creator.p(user2.getName(), "p", "width:150px;height: 50px;")
						+ creator.form(creator.button("go in file user", "button", "submit"),
								"file/" + user2.getId() + "/" + idp, "get");

				body += (" " + creator.div(input, "width:300px;height:100px;background:green;display:inline-block;", "div") + " ");
			}
		}

		model.addAttribute("body", body);
		return "views-filecontent-group";
	}

	@RequestMapping(value = "group/profesor/file/{id}/{idu}", method = RequestMethod.GET)
	public String outPrintFile(Model model, Principal principal, @PathVariable String idu, @PathVariable String id) {
		User user = userService.findOne(Integer.parseInt(idu));
		String body = "";

		Profesor profesor = profesorService.findOne(Integer.parseInt(id));

		for (FileUser fileUser : fileUserService.findAll()) {
			if (fileUser != null && user != null && profesor != null) {

				if (fileUser.getUser().getId() == user.getId()) {

					if (fileUser.getProfesor().getId() == profesor.getId()) {

						if (fileUser.getUser().getGroup().getId() == user.getGroup().getId()) {
							String input = creator.a(fileUser.getPath(), "", "",
									(creator.p(fileUser.getName(), "p", "width:150px;height: 50px;")));
							body += " "
									+ (creator.div(input, "width:300px;height:100px;background:green;display:inline-block;", "div") + " ");
						}
					}
				}
			}
		}
	
		model.addAttribute("body", body);
		return "views-filecontent-group";
	}
}

// @Autowired
// private UserService userService;
//
// @Autowired
// private GroupService groupService;
//
// @InitBinder
// protected void initBinder(WebDataBinder binder){
// binder.registerCustomEditor(User.class, new UserEditor(userService));
// }
//
//
// @RequestMapping("/group")
// public String group() {
//
// return "group";
// }
//
// @RequestMapping(value = "/savegroup", method = RequestMethod.POST)
// public String newGroup(Model model,@ModelAttribute Group group) {
//
// String uuid = UUID.randomUUID().toString();
//
// group.setUuid(uuid);
//
// groupService.save(group);
//
//
//
//
// return "group";
// }
//
// @RequestMapping("/deleteGroup/{id}")
// public String de(@PathVariable int id) {
//
// groupService.delete(id);
//
// return "redirect:/group";
// }
//
// }
