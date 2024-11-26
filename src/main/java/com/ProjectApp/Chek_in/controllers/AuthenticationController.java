package com.ProjectApp.Chek_in.controllers;


import com.ProjectApp.Chek_in.model.ModelSession;
import com.ProjectApp.Chek_in.model.ModelUser;
import com.ProjectApp.Chek_in.repository.SessionRepository;
import com.ProjectApp.Chek_in.repository.UserRepository;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties.Listener.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ProjectApp.Chek_in.model.ModelUser;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@Controller
public class AuthenticationController {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping("/")
    public String AuthenticationOpen(Model model){
        return "Authentication";
    }

    @PostMapping("/AuthenticationUser")
    public String AuthenticationMethod(HttpServletResponse response,@RequestParam("username") String Username,
                                        @RequestParam("password") String Password,Model model ){
        
        List<ModelUser> ListUser = userRepository.findAll();

        for(int i = 0;i < ListUser.size();i++){

            if(Objects.equals(Username, ListUser.get(i).getUsername()) && Objects.equals(Password, ListUser.get(i).getPassword())){
                
                String string_id_session = generateString();

                ValidExistingSession(string_id_session);
                
                ModelSession sessionModel = new ModelSession();
                sessionModel.setkeySession(string_id_session);
                sessionModel.setuser(ListUser.get(i));

                sessionRepository.save(sessionModel);
            
                Cookie cookie = new Cookie("Session", string_id_session);
                cookie.setPath("/");
                cookie.setMaxAge(86400);
                response.addCookie(cookie);
                response.setContentType("text/plain");

                if(Objects.equals(ListUser.get(i).getRole().getnameRole(),"Admin"))
                {
                    return "MainAdminPanel";
                }
                else if(Objects.equals(ListUser.get(i).getRole().getnameRole(),"Manager"))
                {
                    return "MainManagerPanel";
                }
                else
                {
                    return "MainUserPanel";
                }
                
               
            }     
        }
        return "redirect:/Error";
    }
    public String ValidExistingSession(String id_session){
        
        List<ModelSession> ListSession = sessionRepository.findAll();

        for(int i = 0;i < ListSession.size();i++){
            if(Objects.equals(id_session, ListSession.get(i).getkeySession())){
                return "redirect:/Error";
            }
        }

        return "OK";
    }
    public static String generateString()
    {
        Random rng = new Random();
        String characters = "qwertyuiop3sd4f5g6hj7k89l1jgkf2";
        int length = 15;

        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
}
