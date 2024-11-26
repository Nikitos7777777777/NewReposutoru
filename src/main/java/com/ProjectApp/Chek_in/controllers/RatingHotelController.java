package com.ProjectApp.Chek_in.controllers;

import com.ProjectApp.Chek_in.model.ModelRatingHotel;
import com.ProjectApp.Chek_in.model.ModelUser;
import com.ProjectApp.Chek_in.repository.RatingHotelRepository;
import com.ProjectApp.Chek_in.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RatingHotelController {
    @Autowired
    private RatingHotelRepository ratingHotelRepository;
    @GetMapping("/ratingHotels")
    public String getAllRatingHotel(Model model){

        List<ModelRatingHotel> list = ratingHotelRepository.findAll();
        model.addAttribute("ratingHotelList",list);
        return "RatingHotelCRUD";
    }
    @PostMapping("/ratingHotel/add")
    public String addRatingHotel(ModelRatingHotel ratingHotel, BindingResult result, Model model){
        ratingHotelRepository.save(ratingHotel);
        return "redirect:/ratingHotels";
    }
    @PostMapping("/ratingHotel/update")
    public String updateRatingHotel(ModelRatingHotel ratingHotel){
        if(ratingHotelRepository.existsById(ratingHotel.getIdRatingHotel())) {
            ratingHotelRepository.save(ratingHotel);
        }
        return "redirect:/ratingHotels";
    }
    @PostMapping("/ratingHotel/delete")
    public String deleteRatingHotel(@RequestParam Long id){
        ratingHotelRepository.deleteById(id);
        return "redirect:/ratingHotels";
    }
}
