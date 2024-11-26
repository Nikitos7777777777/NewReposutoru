package com.ProjectApp.Chek_in.controllers;

import com.ProjectApp.Chek_in.model.ModelBooking;
import com.ProjectApp.Chek_in.model.ModelRole;
import com.ProjectApp.Chek_in.model.ModelUser;
import com.ProjectApp.Chek_in.repository.BookingRepository;
import com.ProjectApp.Chek_in.repository.RoleRepository;
import com.ProjectApp.Chek_in.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.management.relation.Role;

@Controller
public class UserControllerAdmin {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/users")
    public String getAllCars(Model model){

        List<ModelUser> list = userRepository.findAll();
        List<ModelBooking> listBooking = bookingRepository.findAll();

        model.addAttribute("table",list);
        model.addAttribute("tableBooking",listBooking);
        return "UserCRUD";
    }

    @PostMapping("/user/add")
    public String addUser(ModelUser user, BindingResult result, Model model){

        List<ModelRole> list = roleRepository.findAll();
    
        ModelUser newUser = new ModelUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setActive(user.isActive());
        newUser.setRole(list.get(0));

        userRepository.save(newUser);
        return "MainAdminPanel";
    }

    @PostMapping("/user/update")
    public String updateUser(ModelUser user){
        if(userRepository.existsById(user.getIdUser())) {
            userRepository.save(user);
        }
        return "MainAdminPanel";
    }

    @PostMapping("/user/delete")
    public String deleteUser(@RequestParam Long id){
        userRepository.deleteById(id);
        return "MainAdminPanel";
    }
}
