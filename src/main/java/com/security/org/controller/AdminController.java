package com.security.org.controller;

import com.security.org.entity.User;
import com.security.org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listCustomers(Model model) {
        model.addAttribute("users", userService.getCustomerList());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.showById(id));
        return "show";
    }

    @GetMapping("/{id}/edit")
    public String update(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.showById(id));
        return "edit";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.update(user, id);
        return "redirect:/admin/users";
    }

    @GetMapping("/new")
    public String newCustomer(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute("user") User user) {

        userService.save(user);
        return "redirect:/admin/users";
    }
}
