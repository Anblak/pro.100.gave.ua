package ua.game.pro.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping("/Group")
	public String outPrintGrup(Model model, Principal principal) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		String groupName = user.getGroup().getName();

		String p = creator.p(groupName, "pGroup", "");

		String div = creator.div(p, "width:77px;height:69px;background:green", "divWithGroup");

		model.addAttribute("body", div);

		return "views-filecontent-some";
	}

	@RequestMapping("/Group/Profesor")
	public String outPrintProfesor(Model model, Principal principal) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		List<Profesor> listProfesor = profesorService.findAll();
		String body = "";
		for (Profesor profesor : listProfesor) {
			body += (" " + creator.div(creator.p(profesor.getName(), "pProfesor", ""),
					"width:77px;height:69px;background:green", "divProfesor") + " ");

		}

		model.addAttribute("body", body);

		return "views-filecontent-some";
	}

	@RequestMapping("/testtt")
	public String outPrintUserOfGrup(Model model, Principal principal) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		String body = "";

		for (User user2 : userService.findAll()) {
			if (user.getGroup().getId() == user2.getGroup().getId() && user2.getGroup() != null) {

				body += (" " + creator.div(creator.p(user2.getName(), "pUser", ""),
						"width:77px;height:69px;background:green", "divUserGroup") + " ");
			}
		}

		model.addAttribute("body", body);
		return "views-filecontent-some";
	}

	@RequestMapping("/file")
	public String outPrintFile(Model model, Principal principal) {
		int idu = 3;// переробити
		User user = userService.findOne(idu);
		String body = "";
		int id = 3;///// переробити
		Profesor profesor = profesorService.findOne(id);
		for (FileUser fileUser : fileUserService.findAll()) {
			if(fileUser!=null){
				
			if (fileUser.getUser().getId() == user.getId()) {
				if (fileUser.getProfesor().getId() == profesor.getId()) {
					if (fileUser.getUser().getGroup().getId() == user.getGroup().getId()) {
						body += " " + (creator.div(
								creator.a("", fileUser.getPath(), "", (creator.p(fileUser.getName(), "pFile", ""))),
								"width:77px;height:69px;background:green", "divFile") + " ");
						}
					}
				}
			}
		}
		model.addAttribute("body", body);
		return "views-filecontent-some";
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
