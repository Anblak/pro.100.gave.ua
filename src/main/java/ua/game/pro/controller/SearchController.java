package ua.game.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import resources.file.File;
import java.util.List;
import ua.game.pro.entity.FileUser;
import ua.game.pro.service.ESService;
import ua.game.pro.service.UserService;

import java.security.Principal;

@Controller
public class SearchController {
    @Autowired
    private ESService esService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/search/{searchText}", method = RequestMethod.GET)
    public String fileUserList(@PathVariable String searchText, Model model, Principal principal){

        System.out.println(principal.getName() + "    ----------- principal ");
        try {
            System.out.println(userService.findOne(Integer.getInteger(principal.getName())).getGroup().getId() + "   - group");
        } catch (Exception e){
            System.out.println("kak vsegda");
            System.out.println(e.getMessage());
        }
        System.out.println(  "   - group");
        List<FileUser> fileUserList = esService.findFiles(searchText,
                userService.findOne(Integer.getInteger(principal.getName())).getGroup().getId());

        model.addAttribute("files", fileUserList);
        return "views-user-search";
    }
}
