package ua.game.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.game.pro.dto.UserDTO;
import ua.game.pro.entity.User;
import ua.game.pro.entity.enums.Role;


@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String newAuthor(Model model) {

        model.addAttribute("roles", Role.values());
        model.addAttribute("newUser", new UserDTO());
        return "views-admin-admin";
    }


}
