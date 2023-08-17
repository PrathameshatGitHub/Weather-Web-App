package com.smart.smartcontactmaneger.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.smartcontactmaneger.dao.UserRepository;
import com.smart.smartcontactmaneger.entities.User;


import jakarta.validation.constraints.Email;

@Controller
@RequestMapping("/user")


public class usercontroller {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/index")
    public String dashboard(Model model,Principal principal){
       

        String username=principal.getName();
      User user= userRepository.getUserByUserName(username);
      System.out.println(user);
      model.addAttribute("user", user);




        return"normal/user_dashboard";
    }
    
}
