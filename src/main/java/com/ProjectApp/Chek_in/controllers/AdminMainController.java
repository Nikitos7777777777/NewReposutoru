package com.ProjectApp.Chek_in.controllers;

import com.ProjectApp.Chek_in.model.ModelReviewsRoom;
import com.ProjectApp.Chek_in.model.ModelSession;
import com.ProjectApp.Chek_in.model.ModelUser;
import com.ProjectApp.Chek_in.repository.SessionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Objects;

@Controller
public class AdminMainController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping("/AdminPanel")
    public String AdminPanel(@CookieValue(value = "Session") String Session, Model model){

        List<ModelSession> ListSession = sessionRepository.findAll();
        
        for(int i = 0;i < ListSession.size();i++){

            String sessionBD = ListSession.get(i).getkeySession();

            if(Objects.equals(Session,sessionBD)){
                
                ModelUser user = ListSession.get(i).getuser();

                if(Objects.equals(user.getRole().getnameRole(), "Admin")){

                    return "MainAdminPanel";
                    
                }
            }
        }
        return "redirect:/Error";
    }
}
