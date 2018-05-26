package ua.game.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.game.pro.entity.User;
import ua.game.pro.entity.enums.Role;
import ua.game.pro.service.UserService;

@RestController
public class AdminRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/createFirstAdmin")
    public void createFirstAdmin() throws Exception {
        User user = new User();
        user.setName("admin");
        user.setPassword("admin");
        user.setEmail("admin@admin");
        user.setPhone(328847373);
        user.setRole(Role.ROLE_ADMIN);
        userService.save(user);
        System.out.println("admin created");
    }
}
