package com.ProjectApp.Chek_in.controllers;

import com.ProjectApp.Chek_in.model.ModelRatingRoom;
import com.ProjectApp.Chek_in.model.ModelUser;
import com.ProjectApp.Chek_in.repository.RatingRoomRepository;
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
public class RatingRoomController {
    @Autowired
    private RatingRoomRepository ratingRoomRepository;
    @GetMapping("/ratingRooms")
    public String getAllRatingRoom(Model model){

        List<ModelRatingRoom> list = ratingRoomRepository.findAll();
        model.addAttribute("ratingRoomsList",list);
        return "RatingRoomCRUD";
    }
    @PostMapping("/ratingRoom/add")
    public String addRatingRoom(ModelRatingRoom ratingRoom, BindingResult result, Model model){
        ratingRoomRepository.save(ratingRoom);
        return "redirect:/ratingRooms";
    }
    @PostMapping("/ratingRoom/update")
    public String updateRatingRoom(ModelRatingRoom ratingRoom){
        if(ratingRoomRepository.existsById(ratingRoom.getIdRatingRoom())) {
            ratingRoomRepository.save(ratingRoom);
        }
        return "redirect:/ratingRooms";
    }
    @PostMapping("/ratingRoom/delete")
    public String deleteRatingRoom(@RequestParam Long id){
        ratingRoomRepository.deleteById(id);
        return "redirect:/ratingRooms";
    }
}
