package com.ProjectApp.Chek_in.controllers;

import com.ProjectApp.Chek_in.model.ModelBooking;
import com.ProjectApp.Chek_in.model.ModelReviewsRoom;
import com.ProjectApp.Chek_in.model.ModelSession;
import com.ProjectApp.Chek_in.model.ModelUser;
import com.ProjectApp.Chek_in.repository.SessionRepository;
import com.ProjectApp.Chek_in.repository.UserRepository;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class MainUserPanel {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/MainUserPanelPage")
    public String MainUserOanelOpen(Model model){
        return "MainUserPanel";
    }

    @GetMapping("/Profile")
    public String readCookie(@CookieValue(value = "Session") String Session, Model model) {
        
        List<ModelSession> ListSession = sessionRepository.findAll();
        
        for(int i = 0;i < ListSession.size();i++){

            String sessionBD = ListSession.get(i).getkeySession();

            if(Objects.equals(Session,sessionBD)){
                
                ModelUser user = ListSession.get(i).getuser();
                model.addAttribute("user",user);

                return "ProfilePage";
            }

        }
        return "redirect:/Error";
    }

    @GetMapping("/Exit")
    public String DeleteSessionExit(@CookieValue(value = "Session") String Session, Model model) {
        
        List<ModelSession> ListSession = sessionRepository.findAll();
        
        for(int i = 0;i < ListSession.size();i++){

            String sessionBD = ListSession.get(i).getkeySession();

            if(Objects.equals(Session,sessionBD)){
                
                sessionRepository.deleteById(ListSession.get(i).getIdSession());
                return "Authentication";
            }

        }
        return "redirect:/Error";
    }
}
