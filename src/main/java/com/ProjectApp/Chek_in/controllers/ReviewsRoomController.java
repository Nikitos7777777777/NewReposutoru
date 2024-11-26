package com.ProjectApp.Chek_in.controllers;

import com.ProjectApp.Chek_in.model.ModelReviewsRoom;
import com.ProjectApp.Chek_in.model.ModelUser;
import com.ProjectApp.Chek_in.repository.ReviewsRoomRepository;
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
public class ReviewsRoomController {
    @Autowired
    private ReviewsRoomRepository reviewsRoomRepository;
    @GetMapping("/reviewsRooms")
    public String getAllReviewsRoom(Model model){

        List<ModelReviewsRoom> list = reviewsRoomRepository.findAll();
        model.addAttribute("reviewsRoomList",list);
        return "ReviewsRoomCRUD";
    }
    @PostMapping("/reviewsRoom/add")
    public String addReviewsRoom(ModelReviewsRoom reviewsRoom, BindingResult result, Model model){
        reviewsRoomRepository.save(reviewsRoom);
        return "redirect:/reviewsRooms";
    }
    @PostMapping("/reviewsRoom/update")
    public String updateReviewsRoom(ModelReviewsRoom reviewsRoom){
        if(reviewsRoomRepository.existsById(reviewsRoom.getIdReviewsRoom())) {
            reviewsRoomRepository.save(reviewsRoom);
        }
        return "redirect:/reviewsRooms";
    }
    @PostMapping("/reviewsRoom/delete")
    public String deleteReviewsRoom(@RequestParam Long id){
        reviewsRoomRepository.deleteById(id);
        return "redirect:/reviewsRooms";
    }
}
