//package ua.game.pro.controller;
//
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//
//
//import ua.game.pro.editor.UserEditor;
//import ua.game.pro.entity.Group;
//import ua.game.pro.entity.User;
//import ua.game.pro.service.GroupService;
//import ua.game.pro.service.UserService;
//
//@Controller
//public class GroupController {
//	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private GroupService groupService;
//	
//	@InitBinder
//	protected void initBinder(WebDataBinder binder){
//		binder.registerCustomEditor(User.class, new UserEditor(userService));
//	}
//	
//
//	@RequestMapping("/group")
//	public String group() {
//
//		return "group";
//	}
//
//	@RequestMapping(value = "/savegroup", method = RequestMethod.POST)
//	public String newGroup(Model model,@ModelAttribute Group group) {
//		
//		   String uuid = UUID.randomUUID().toString();
//
//	        group.setUuid(uuid);
//		
//		groupService.save(group);
//		
//		
//	
//		
//		return "group";
//	}
//
//	@RequestMapping("/deleteGroup/{id}")
//	public String de(@PathVariable int id) {
//
//		groupService.delete(id);
//		
//		return "redirect:/group";
//	}
//
//}
