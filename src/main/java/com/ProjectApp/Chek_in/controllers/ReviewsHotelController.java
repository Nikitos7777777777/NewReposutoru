package com.ProjectApp.Chek_in.controllers;

import com.ProjectApp.Chek_in.model.ModelReviewsHotel;
import com.ProjectApp.Chek_in.repository.ReviewsHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReviewsHotelController {
    @Autowired
    private ReviewsHotelRepository reviewsHotelRepository;
    @GetMapping("/reviewsHotels")
    public String getAllReviewsHotel(Model model){

        List<ModelReviewsHotel> list = reviewsHotelRepository.findAll();
        model.addAttribute("reviewsHotelList",list);
        return "ReviewsHotelCRUD";
    }

    @PostMapping("/reviewsHotel/add")
    public String addReviewsHotel(ModelReviewsHotel reviewsHotel, BindingResult result, Model model){
        reviewsHotelRepository.save(reviewsHotel);
        return "redirect:/reviewsHotels";
    }

    @PostMapping("/reviewsHotel/update")
    public String updateReviewsHotel(ModelReviewsHotel reviewsHotel){
        if(reviewsHotelRepository.existsById(reviewsHotel.getIdReviewsHotel())) {
            reviewsHotelRepository.save(reviewsHotel);
        }
        return "redirect:/reviewsHotels";
    }
    
    @PostMapping("/reviewsHotel/delete")
    public String deleteReviewsHotel(@RequestParam Long id){
        reviewsHotelRepository.deleteById(id);
        return "redirect:/reviewsHotels";
    }
}
