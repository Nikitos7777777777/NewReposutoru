package com.ProjectApp.Chek_in.controllers;

import com.ProjectApp.Chek_in.model.ModelBooking;
import com.ProjectApp.Chek_in.model.ModelReviewsRoom;
import com.ProjectApp.Chek_in.model.ModelRole;
import com.ProjectApp.Chek_in.model.ModelUser;
import com.ProjectApp.Chek_in.repository.RoleRepository;
import com.ProjectApp.Chek_in.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/RegistrationOpen")
    public String RegistrationPanel(Model model){
        return "Registration";
    }

    @PostMapping("/user/create")
    public String CreatUser(ModelUser user){

        List<ModelRole> list = roleRepository.findAll();
    
        ModelUser newUser = new ModelUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setActive(user.isActive());
        newUser.setRole(list.get(0));

        userRepository.save(newUser);
        return "Authentication";
    }
}
