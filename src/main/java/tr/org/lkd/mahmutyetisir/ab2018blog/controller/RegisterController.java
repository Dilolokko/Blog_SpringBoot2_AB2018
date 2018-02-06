package tr.org.lkd.mahmutyetisir.ab2018blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tr.org.lkd.mahmutyetisir.ab2018blog.model.User;
import tr.org.lkd.mahmutyetisir.ab2018blog.service.UserService;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model){

        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        userService.register(user);
        return "redirect:/blog";
    }
}