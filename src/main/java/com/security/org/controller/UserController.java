package com.security.org.controller;

import com.security.org.entity.User;
import com.security.org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Action;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public String showUser() {
        return "user";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.showById(id));
        return "show";
    }
    @GetMapping("/{id}/edit")
    public String update(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showById(id));
        return "edit";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/list";

    }
    @GetMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("users", userService.getCustomerList());
        return "index";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(user, id);
        return "redirect:/list";
    }
    @GetMapping("/new")
    public String newCustomer(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }
    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/list";
    }

}
