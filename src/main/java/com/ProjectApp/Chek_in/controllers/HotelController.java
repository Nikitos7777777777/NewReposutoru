package com.ProjectApp.Chek_in.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.ProjectApp.Chek_in.model.ModelHotel;
import com.ProjectApp.Chek_in.model.ModelRatingHotel;
import com.ProjectApp.Chek_in.model.ModelReviewsHotel;
import com.ProjectApp.Chek_in.model.ModelRoom;
import com.ProjectApp.Chek_in.model.ModelSession;
import com.ProjectApp.Chek_in.model.ModelUser;
import com.ProjectApp.Chek_in.repository.HotelRepository;
import com.ProjectApp.Chek_in.repository.RatingHotelRepository;
import com.ProjectApp.Chek_in.repository.ReviewsHotelRepository;
import com.ProjectApp.Chek_in.repository.RoomRepository;
import com.ProjectApp.Chek_in.repository.SessionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RatingHotelRepository ratingHotelRepository;
    @Autowired
    private ReviewsHotelRepository reviewsHotelRepository;
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping("/hotelsUser")
    public String readCookie(@CookieValue(value = "Session") String Session, Model model) {
        
        List<ModelSession> ListSession = sessionRepository.findAll();
        
        for(int i = 0;i < ListSession.size();i++){

            String sessionBD = ListSession.get(i).getkeySession();

            if(Objects.equals(Session,sessionBD)){
                
                // ModelUser user = ListSession.get(i).getuser();
                List<ModelHotel> list = hotelRepository.findAll();
                List<ModelRoom> listRoom = roomRepository.findAll();
                List<ModelRatingHotel> listRating = ratingHotelRepository.findAll();
                List<ModelReviewsHotel> listReviews = reviewsHotelRepository.findAll();
                model.addAttribute("hotelList",list);
                model.addAttribute("roomList",listRoom);
                model.addAttribute("ratingList",listRating);
                model.addAttribute("reviewsHotelList",listReviews);
                
                return "AllHotelPage";
            }

        }
        return "redirect:/Error";
    }

}
