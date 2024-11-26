package com.ProjectApp.Chek_in.controllers;

import com.ProjectApp.Chek_in.model.ModelBooking;
import com.ProjectApp.Chek_in.model.ModelHotel;
import com.ProjectApp.Chek_in.model.ModelRoom;
import com.ProjectApp.Chek_in.model.ModelUser;
import com.ProjectApp.Chek_in.repository.BookingRepository;
import com.ProjectApp.Chek_in.repository.HotelRepository;
import com.ProjectApp.Chek_in.repository.RoomRepository;
import com.ProjectApp.Chek_in.repository.UserRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/bookings")
    public String getAllBooking(Model model){

        List<ModelBooking> list = bookingRepository.findAll();
        List<ModelHotel> listHotel = hotelRepository.findAll();
        model.addAttribute("bookingNew",new ModelBooking());
        model.addAttribute("hotelNew",new ModelHotel());
        model.addAttribute("userNew",new ModelUser());
        model.addAttribute("usersModelList",userRepository.findAll());
        model.addAttribute("bookingList",list);
        model.addAttribute("roomList",roomRepository.findAll());
        model.addAttribute("hotelList",listHotel);
        model.addAttribute("userList", userRepository.findAll());
        return "BookingCRUD";
    }
    @PostMapping("/booking/add")
    public String addBooking(ModelBooking booking, BindingResult result, Model model){

        List<ModelHotel> list = hotelRepository.findAll();
        // Optional<ModelUser> userOption = userRepository.findById(Long.valueOf(userId));
        // ModelUser userSelect = userOption.get();

//        for (int i = 0;i< list.size();i++){
            for (int j = 0;j < list.get(j).getRooms().size();j++){
                Long id = booking.getHotel().get(j).getRooms().get(j).getIdRoom();
                Long idroom = booking.getRoom().getIdRoom();
                if(Objects.equals(idroom, id)){

                    // ModelBooking bookingBuld = new ModelBooking();
                    // bookingBuld.setStartDay(booking.getStartDay());
                    // bookingBuld.setEndDay(booking.getEndDay());
                    // bookingBuld.setHotel(booking.getHotel());
                    // bookingBuld.setRoom(booking.getRoom());
                    // bookingBuld.setUser(userSelect);

                    bookingRepository.save(booking);
                    return "redirect:/bookings";
                }
            }
//        }
        return "redirect:/Error";
    }
    @PostMapping("/booking/update")
    public String updateBooking(ModelBooking booking){
        if(bookingRepository.existsById(booking.getIdBooking())) {
            bookingRepository.save(booking);
        }
        return "redirect:/bookings";
    }
    @PostMapping("/booking/delete")
    public String deleteBooking(@RequestParam Long id){
        bookingRepository.deleteById(id);
        return "redirect:/bookings";
    }
}
