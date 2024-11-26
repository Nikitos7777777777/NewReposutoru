package com.ProjectApp.Chek_in.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ModelHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHotel;

    private String img;
    private String name;
    private String capacity;
    private int cost;

    @Nullable
    @ManyToMany
    @JoinTable(
        name = "Hotel_reviews",
        joinColumns = @JoinColumn(name = "hotel_id"), 
        inverseJoinColumns = @JoinColumn(name = "reviewsHotel_id") 
    )
    private List<ModelReviewsHotel> reviewsHotels;
    
    @Nullable
    @ManyToMany
    @JoinTable(
        name = "Hotel_rating",
        joinColumns = @JoinColumn(name = "hotel_id"), // Колонка для связи с User
        inverseJoinColumns = @JoinColumn(name = "ratingHotel_id") // Колонка для связи с Role
    )
    private List<ModelRatingHotel> ratingHotels;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private List<ModelRoom> rooms;

    public ModelHotel(){

    }
    public ModelHotel(Long idHotel, String img, String name, String capacity, int cost, List<ModelReviewsHotel> reviewsHotels, List<ModelRatingHotel> ratingHotels, List<ModelRoom> rooms) {
        this.idHotel = idHotel;
        this.img = img;
        this.name = name;
        this.capacity = capacity;
        this.cost = cost;
        this.reviewsHotels = reviewsHotels;
        this.ratingHotels = ratingHotels;
        this.rooms = rooms;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<ModelReviewsHotel> getReviewsHotels() {
        return reviewsHotels;
    }

    public void setReviewsHotels(List<ModelReviewsHotel> reviewsHotels) {
        this.reviewsHotels = reviewsHotels;
    }

    public List<ModelRatingHotel> getRatingHotels() {
        return ratingHotels;
    }

    public void setRatingHotels(List<ModelRatingHotel> ratingHotels) {
        this.ratingHotels = ratingHotels;
    }

    public List<ModelRoom> getRooms() {
        return rooms;
    }

    public void setRooms(List<ModelRoom> rooms) {
        this.rooms = rooms;
    }
}
