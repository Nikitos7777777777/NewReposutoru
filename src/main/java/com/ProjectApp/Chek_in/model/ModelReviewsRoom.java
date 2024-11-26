package com.ProjectApp.Chek_in.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ModelReviewsRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReviewsRoom;

    private String review;
    
    public ModelReviewsRoom(){

    }
    public ModelReviewsRoom(Long idReviewsRoom, String review) {
        this.idReviewsRoom = idReviewsRoom;
        this.review = review;
    }

    public Long getIdReviewsRoom() {
        return idReviewsRoom;
    }

    public void setIdReviewsRoom(Long idReviewsRoom) {
        this.idReviewsRoom = idReviewsRoom;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
