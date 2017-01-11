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

	@RequestMapping("/group")
	public String outPrintGrup(Model model, Principal principal) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		String groupName = user.getGroup().getName();

		String p = creator.p(groupName, "pGroup", "");

		String div = creator.div(p, "width:77px;height:69px;background:green", "divWithGroup");

		model.addAttribute("body", div);

		return "views-filecontent-group";
	}

	@RequestMapping("group/profesor")
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

	@RequestMapping("/usersInTheGroup")
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
		return "views-filecontent-group";
	}

	@RequestMapping(value="/file/{idu}/{id}",method=RequestMethod.GET)
	public String outPrintFile(Model model, Principal principal,@PathVariable String idu, @PathVariable String id) {
		System.out.println(idu+id);
		User user = userService.findOne(Integer.parseInt(idu));
		String body = "";
		
		Profesor profesor = profesorService.findOne(Integer.parseInt(id));
		
		for (FileUser fileUser : fileUserService.findAll()) {
			if(fileUser!=null && user !=null && profesor != null){
				System.out.println("0");
			if (fileUser.getUser().getId() == user.getId()) {
				System.out.println("1");
				if (fileUser.getProfesor().getId() == profesor.getId()) {
					System.out.println("2");
					if (fileUser.getUser().getGroup().getId() == user.getGroup().getId()) {
						System.out.println("3");
						body += " " + (creator.div(
								creator.a(fileUser.getPath(), "", "", (creator.p(fileUser.getName(), "pFile", ""))),
								"width:77px;height:69px;background:green", "divFile") + " ");
						}
					}
				}
			}
		}
		System.out.println(body);
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
