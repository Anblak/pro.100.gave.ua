package ua.game.pro.editor;

import ua.game.pro.service.UserService;

import java.beans.PropertyEditorSupport;


public class UserEditor extends PropertyEditorSupport {

    private final UserService userService;

    public UserEditor(UserService userService) {
        super();
        this.userService = userService;
    }


    public void setAsText(String text) throws IllegalArgumentException {
        setValue(userService.findOne(Integer.parseInt(text)));
    }

}
