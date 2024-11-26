package com.ProjectApp.Chek_in.controllers;

import com.ProjectApp.Chek_in.model.*;
import com.ProjectApp.Chek_in.repository.HotelRepository;
import com.ProjectApp.Chek_in.repository.RatingHotelRepository;
import com.ProjectApp.Chek_in.repository.ReviewsHotelRepository;
import com.ProjectApp.Chek_in.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class HotelControllerAdmin {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RatingHotelRepository ratingHotelRepository;
    @Autowired
    private ReviewsHotelRepository reviewsHotelRepository;

    @GetMapping("/hotels")
    public String getAllHotel(Model model){

        List<ModelHotel> list = hotelRepository.findAll();
        List<ModelRoom> listRoom = roomRepository.findAll();
        List<ModelRatingHotel> listRating = ratingHotelRepository.findAll();
        List<ModelReviewsHotel> listReviews = reviewsHotelRepository.findAll();
        model.addAttribute("hotelList",list);
        model.addAttribute("hotelNew",new ModelHotel());
        model.addAttribute("roomList",listRoom);
        model.addAttribute("ratingList",listRating);
        model.addAttribute("reviewsHotelList",listReviews);
        return "HotelCRUD";
    }
    @PostMapping("/hotel/add")
    public String addHotel(ModelHotel hotel, BindingResult result, Model model){
        List<ModelHotel> list = hotelRepository.findAll();
        for (int i = 0;i< list.size();i++){
            for (int j = 0;j < list.get(i).getRooms().size();j++){
                Long id = list.get(i).getRooms().get(j).getIdRoom();
                Long idHotel = hotel.getRooms().get(j).getIdRoom();
                if(Objects.equals(idHotel, id)){
                    return "redirect:/hotels";
                }
            }
        }
        hotelRepository.save(hotel);
        return "redirect:/hotels";
    }
    @PostMapping("/hotel/update")
    public String updateHotel(ModelHotel user){
        if(hotelRepository.existsById(user.getIdHotel())) {
            hotelRepository.save(user);
        }
        return "redirect:/hotels";
    }
    @PostMapping("/hotel/delete")
    public String deleteHotel(@RequestParam Long id){
        hotelRepository.deleteById(id);
        return "redirect:/hotels";
    }
}
