package com.ProjectApp.Chek_in.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ModelRatingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idRatingRoom;
    private int rating;

    public ModelRatingRoom(){

    }
    public ModelRatingRoom(Long idRatingRoom, int rating) {
        this.idRatingRoom = idRatingRoom;
        this.rating = rating;
    }

    public Long getIdRatingRoom() {
        return idRatingRoom;
    }

    public void setIdRatingRoom(Long idRatingRoom) {
        this.idRatingRoom = idRatingRoom;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
