package com.ProjectApp.Chek_in.controllers;

import com.ProjectApp.Chek_in.model.ModelBooking;
import com.ProjectApp.Chek_in.model.ModelHotel;
import com.ProjectApp.Chek_in.model.ModelRatingHotel;
import com.ProjectApp.Chek_in.model.ModelReviewsHotel;
import com.ProjectApp.Chek_in.model.ModelRoom;
import com.ProjectApp.Chek_in.model.ModelSession;
import com.ProjectApp.Chek_in.model.ModelUser;
import com.ProjectApp.Chek_in.repository.BookingRepository;
import com.ProjectApp.Chek_in.repository.HotelRepository;
import com.ProjectApp.Chek_in.repository.RoomRepository;
import com.ProjectApp.Chek_in.repository.SessionRepository;
import com.ProjectApp.Chek_in.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.persistence.Id;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class BookingControllerUser {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping("/Order")
    public String readCookie(@CookieValue(value = "Session") String Session, 
                                                            @RequestParam("idRoom") int IdRoom,
                                                            @RequestParam("idHotel") int IdHotel,
                                                            Model model) {
        
        List<ModelSession> ListSession = sessionRepository.findAll();
        
        for(int i = 0;i < ListSession.size();i++){

            String sessionBD = ListSession.get(i).getkeySession();

            if(Objects.equals(Session,sessionBD)){


                int idUser =  ListSession.get(i).getuser().getIdUser().intValue();

                model.addAttribute("room",IdRoom);
                model.addAttribute("hotel",IdHotel);
                model.addAttribute("user",idUser);
                
                return "OrderRoomPage";
            }

        }
        return "redirect:/Error";
    }

    @PostMapping("/order/add")
    public String addBooking(@RequestParam("startDay") String StartDay,
                             @RequestParam("endDay") String EndDay,
                             @RequestParam("idRoom") int IdRoom,
                             @RequestParam("idHotel") int IdHotel,
                             @RequestParam("idUser") int IdUseer, 
                             Model model){

        ModelBooking bookingUser = new ModelBooking();
        bookingUser.setStartDay(StartDay);
        bookingUser.setEndDay(EndDay);
        bookingUser.setRoom(takeRoom(IdRoom));
        bookingUser.setHotel(takeHotel(IdHotel));
        bookingUser.setUser(takeUser(IdUseer));

        bookingRepository.save(bookingUser);
        
        return "MainUserPanel";
    }

    public ModelRoom takeRoom(int IdRoom){

        List<ModelRoom> ListRoom = roomRepository.findAll();

        for(int i = 0;i < ListRoom.size();i++){

            if(Objects.equals(Long.valueOf(IdRoom), ListRoom.get(i).getIdRoom())){

                ModelRoom room = ListRoom.get(i);
                return room;
            }
        }

        return null;
    }

    public List<ModelHotel> takeHotel(int IdHotel){

        List<ModelHotel> ListHotel = hotelRepository.findAll();

        for(int i = 0;i < ListHotel.size();i++){

            if(Objects.equals(Long.valueOf(IdHotel), ListHotel.get(i).getIdHotel())){

                List<ModelHotel> hotel = new ArrayList<>();
                hotel.add(ListHotel.get(i));
                return hotel;
            }
        }

        return null;
    }

    public ModelUser takeUser(int IdUser){

        List<ModelUser> ListUser = userRepository.findAll();

        for(int i = 0;i < ListUser.size();i++){

            if(Objects.equals(Long.valueOf(IdUser), ListUser.get(i).getIdUser())){

                ModelUser user = ListUser.get(i);
                return user;
            }
        }

        return null;
    }

}
