//package com.security.org.controller;
//
//import com.security.org.entity.User;
//import com.security.org.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.naming.Binding;
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("/user")
//public class RegistrationController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/")
//    public String userInfo() {
//        return "user";
//    }
//    @PostMapping("/registration")
//    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult binding, Model model) {
//        if (binding.hasErrors()) {
//            return "registration";
//        }
//        if (!userService.save(user)){
//            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
//            return "registration";
//        }
//        return "redirect:/";
//
//    }
//}
