package ua.game.pro.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import resources.creatorHTMLTag.CreatorHTMLTag;
import ua.game.pro.entity.FileUser;
import ua.game.pro.entity.GroupOfUsers;
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

		try {

			User user = userService.findOne(Integer.parseInt(principal.getName()));
			String groupName = user.getGroup().getName();
			model.addAttribute("user", user);
			String input = creator.p(groupName, "p", "")
					+ creator.div(creator.form(creator.button("profesor", "buttonNext", "submit"), "profesor", "GET"),
							"", "wrapperButton")
					+ creator.div(
							creator.form(creator.button("DELETE", "buttonDelete", "submit"), "deletegroup", "GET"), "",
							"wrapperButton");
			String div = creator.div(input, "", "div");
			model.addAttribute("body", div);
			return "views-filecontent-group";
		} catch (NullPointerException e) {
			return "views-base-home";
		} catch (Exception e) {
			return "views-filecontent-group";
		}

	}

	@RequestMapping(value = "/profesor", method = RequestMethod.GET)
	public String outPrintProfesor(Model model, Principal principal) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		List<Profesor> listProfesor = profesorService.findAll();
		String body = "";
		for (Profesor profesor : listProfesor) {
			if (profesor.getGroupOfUsers().getId() == user.getGroup().getId()) {

				String input = creator.p(profesor.getName(), "p", "")
						+ creator.div(creator.form(creator.button("Profesor for Group", "buttonNext", "submit"),
								"" + profesor.getId(), "get"), "display:inline-block", "wrapperButton")
						+ creator.div(creator.form(creator.button("DELETE", "buttonDelete", "submit"), "deleteprofesor",
								"GET"), "display:inline-block", "wrapperButton");
				body += (" " + creator.div(input, "", "div") + " ");

			}

		}

		model.addAttribute("body", body);

		return "views-filecontent-group";
	}

	@RequestMapping(value = "/{idp}", method = RequestMethod.GET)
	public String outPrintUserOfGrup(Model model, Principal principal, @PathVariable String idp) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		String body = "";
		Profesor profesor = profesorService.findOne(Integer.parseInt(idp));

		for (User user2 : userService.findAll()) {
			if (profesor.getGroupOfUsers().getId() == user2.getGroup().getId() && user2.getGroup() != null) {
				String input = creator.p(user2.getName(), "p", "")
						+ creator.form(creator.button("go in file user", "buttonNext", "submit"),
								"file" + profesor.getId() + "&" + user2.getId()+"", "GET");

				body += (" " + creator.div(input, "", "div") + " ");
			}
		}

		model.addAttribute("body", body);
		return "views-filecontent-group";
	}

	@RequestMapping(value = "file{idpath}", method = RequestMethod.GET)
	public String outPrintFile(Model model, Principal principal,@PathVariable(value="idpath") String idpath) {
		int idp,idu;
		String idps="",idus="";
		boolean tempBoolean=true;
		for (int i = 0; i < idpath.length(); i++) {
			if(tempBoolean&&idpath.charAt(i)!='&'){
				idps+=idpath.charAt(i);
				tempBoolean=false;
			}else if(!tempBoolean&&idpath.charAt(i)!='&'){
				idus+=idpath.charAt(i);
			}
		}
		idp=Integer.parseInt(idps);
		idu=Integer.parseInt(idus);
System.out.println("idu "+ idu+" idp "+ idp);
		try {
			User user = userService.findOne((idu));
			String body = "";

			Profesor profesor = profesorService.findOne((idp));

			for (FileUser fileUser : fileUserService.findAll()) {
				if (fileUser != null && user != null && profesor != null) {

					if (fileUser.getUser().getId() == user.getId()) {

						if (fileUser.getProfesor().getId() == profesor.getId()) {

							if (fileUser.getUser().getGroup().getId() == user.getGroup().getId()) {
								String input = creator.a("/Pro.100.Game.Ua/" + fileUser.getPath(), "", "",
										(creator.p(fileUser.getName(), "p", "")));
								;
								body += " " + (creator.div(input, "", "div") + " ");
								// creator.button((creator.p(fileUser.getName(),
								// "p", "width:150px;height: 17px;")), "", "",
								// fileUser.getPath(), "submit", "", "");
								//
								// creator.a(fileUser.getPath(), "", "",
								// (creator.p(fileUser.getName(), "p",
								// "width:150px;height: 17px;")));
							}
						}
					}
				}
			}

			model.addAttribute("body", body);
			return "views-filecontent-group";

		} catch (NullPointerException e) {
			return "views-base-home";
		} catch (Exception e) {
			return "views-filecontent-group";
		}
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
