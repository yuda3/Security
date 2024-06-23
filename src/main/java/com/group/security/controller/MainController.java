package com.group.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login(@RequestParam(name="error", required = false) String error,
                        @RequestParam(name="logout", required = false) String logout, Model model
    ){
        if(error != null){
            model.addAttribute("error", true);
        }
        if (logout != null){
            model.addAttribute("logout", true);
        }
        return "index";
    }
}
