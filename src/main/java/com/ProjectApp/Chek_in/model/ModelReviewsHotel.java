package com.ProjectApp.Chek_in.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ModelReviewsHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReviewsHotel;
    
    private String reviews;

    public ModelReviewsHotel(){

    }
    public ModelReviewsHotel(Long idReviewsHotel, String reviews) {
        this.idReviewsHotel = idReviewsHotel;
        this.reviews = reviews;
    }

    public Long getIdReviewsHotel() {
        return idReviewsHotel;
    }

    public void setIdReviewsHotel(Long idReviewsHotel) {
        this.idReviewsHotel = idReviewsHotel;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }
}
