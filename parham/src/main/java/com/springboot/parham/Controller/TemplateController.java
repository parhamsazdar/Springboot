package com.springboot.parham.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TemplateController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/contact")
    public String contact() {
        return "view/contact";
    }

    @RequestMapping(value = "/usertemplate")
    public String userTemplate(Model model) {
        List<User> users =new ArrayList<>();
        users.add(new User("htef","5613"));
        users.add(new User("ali","1234"));
        model.addAttribute("users",users);
        return "view/userTemplate";
    }

    @RequestMapping("/loginform")
    public String loginForm(Model model){
        model.addAttribute("userdata",new User());
        return "view/loginform";
    }


    @RequestMapping("/login")
    public String login(@ModelAttribute("userdata") User user){
        System.out.println(user.getName()+" "+user.getPassword());
//        model.addAttribute("",new);
        return "redirect:loginform";
    }




}
