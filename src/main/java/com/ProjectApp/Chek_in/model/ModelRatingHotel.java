package com.ProjectApp.Chek_in.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ModelRatingHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idRatingHotel;
    private int rating;

    public ModelRatingHotel(){

    }
    public ModelRatingHotel(Long idRatingHotel, int rating) {
        this.idRatingHotel = idRatingHotel;
        this.rating = rating;
    }

    public Long getIdRatingHotel() {
        return idRatingHotel;
    }

    public void setIdRatingHotel(Long idRatingHotel) {
        this.idRatingHotel = idRatingHotel;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
