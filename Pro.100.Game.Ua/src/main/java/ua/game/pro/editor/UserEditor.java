package ua.game.pro.editor;

import java.beans.PropertyEditorSupport;

import ua.game.pro.service.UserService;



public class UserEditor extends PropertyEditorSupport{
	
	private final UserService userService;

	public UserEditor(UserService userService) {
		super();
		this.userService=userService;
	}
	
	
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(userService.findOne(Integer.parseInt(text)));
	}

}
