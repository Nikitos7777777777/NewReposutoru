package com.ProjectApp.Chek_in.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Optional;

import ch.qos.logback.core.model.Model;

@Entity
public class ModelBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBooking;

    @Size(max=8,message = "Неправельно заполнина дата начало")
    private String startDay;

    @Size(max=8,message = "Неправельно заполнена дата конца")
    private String endDay;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_booking")
    private List<ModelHotel> hotel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_room")
    private ModelRoom room;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ModelUser user;

    public ModelBooking(){

    }
    public ModelBooking(Long idBooking, String startDay, String endDay, List<ModelHotel> hotel, ModelRoom room,ModelUser user) {
        this.idBooking = idBooking;
        this.startDay = startDay;
        this.endDay = endDay;
        this.hotel = hotel;
        this.room = room;
        this.user = user;
    }
    public Long getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Long idBooking) {
        this.idBooking = idBooking;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public List<ModelHotel> getHotel() {
        return hotel;
    }

    public void setHotel(List<ModelHotel> hotel) {
        this.hotel = hotel;
    }

    public ModelRoom getRoom() {
        return room;
    }

    public void setRoom(ModelRoom room) {
        this.room = room;
    }

    public ModelUser getUser() {
        return user;
    }

    public void setUser(ModelUser user) {
        this.user = user;
    }
}
