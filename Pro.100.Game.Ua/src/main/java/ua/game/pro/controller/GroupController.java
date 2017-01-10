package ua.game.pro.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import resources.creatorHTMLTag.CreatorHTMLTag;
import ua.game.pro.entity.User;
import ua.game.pro.service.FileUserService;
import ua.game.pro.service.GroupOfUsersService;
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

	@RequestMapping("/showGroup")
	public String outPrintGrup(Model model, Principal principal) {
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		String groupName = user.getGroup().getName();
		
		
		
		String p=creator.p(groupName, "pGroup", "");
		
		String div=creator.div(p, "width:77px;height:69px;background:green", "divWithGroup");
		
		model.addAttribute("body",div);
		
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
