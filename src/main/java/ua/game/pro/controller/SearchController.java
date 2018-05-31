package ua.game.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.game.pro.entity.FileUser;
import ua.game.pro.service.ESService;
import ua.game.pro.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private ESService esService;

    @Autowired
    private UserService userService;

    @RequestMapping("/search/{searchText}")
    public String fileUserList(@PathVariable String searchText, Model model, Principal principal) {
        if (principal != null) {
            List<FileUser> fileUserList = esService.findFiles(searchText,
                    userService.findOne(Integer.parseInt(principal.getName())).getGroup().getId());
            model.addAttribute("searchResult", fileUserList);
            return "views-base-search";
        } else
            return "views-base-home";
    }
}
