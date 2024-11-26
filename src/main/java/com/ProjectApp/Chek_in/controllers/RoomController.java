package com.ProjectApp.Chek_in.controllers;

import com.ProjectApp.Chek_in.model.ModelRoom;
import com.ProjectApp.Chek_in.repository.RatingRoomRepository;
import com.ProjectApp.Chek_in.repository.ReviewsRoomRepository;
import com.ProjectApp.Chek_in.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ReviewsRoomRepository reviewsRoomRepository;
    @Autowired
    private RatingRoomRepository ratingRoomRepository;
    @GetMapping("/rooms")
    public String getAllRoom(Model model){

        List<ModelRoom> list = roomRepository.findAll();
        model.addAttribute("roomList",list);
        model.addAttribute("roomListNew",new ModelRoom());
        model.addAttribute("reviewsRoomList", reviewsRoomRepository.findAll());
        model.addAttribute("ratingRoomList", ratingRoomRepository.findAll());
        return "RoomCRUD";
    }
    @PostMapping("/room/add")
    public String addRoom(ModelRoom hotel, BindingResult result, Model model){
        roomRepository.save(hotel);
        return "redirect:/rooms";
    }
    @PostMapping("/room/update")
    public String updateRoom(ModelRoom hotel){
        if(roomRepository.existsById(hotel.getIdRoom())) {
            roomRepository.save(hotel);
        }
        return "redirect:/rooms";
    }
    @PostMapping("/room/delete")
    public String deleteRoom(@RequestParam Long id){
        roomRepository.deleteById(id);
        return "redirect:/rooms";
    }
}
