package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "pages/users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "pages/new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }


    @DeleteMapping("/{id}/delete")
    public String removeUser(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "pages/edit";
    }

    @PostMapping("/{id}/update")
    public String editUser(@PathVariable("id") int id, @ModelAttribute User user, Model model) {
        userService.updateUser(id, user.getName(), user.getSurName(), user.getEmail());
        return "redirect:/";
    }
}