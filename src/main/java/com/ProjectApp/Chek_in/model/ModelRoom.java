package com.ProjectApp.Chek_in.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ModelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoom;
    
    private String img;
    private String name;
    private String capacity;
    private int cost;

    @ManyToMany
    @JoinTable(
        name = "Room_rating",
        joinColumns = @JoinColumn(name = "room_id"),
        inverseJoinColumns = @JoinColumn(name = "ratingroom_id") 
    )
    private List<ModelRatingRoom> ratingRooms;

    @ManyToMany
    @JoinTable(
        name = "Room_reviews",
        joinColumns = @JoinColumn(name = "room_id"), 
        inverseJoinColumns = @JoinColumn(name = "reviewsRoom_id") 
    )
    private List<ModelReviewsRoom> reviewsRooms;
    
    public ModelRoom(){

    }
    public ModelRoom(Long idRoom, String img, String name, String capacity, int cost, List<ModelRatingRoom> ratingRooms, List<ModelReviewsRoom> reviewsRooms) {
        this.idRoom = idRoom;
        this.img = img;
        this.name = name;
        this.capacity = capacity;
        this.cost = cost;
        this.ratingRooms = ratingRooms;
        this.reviewsRooms = reviewsRooms;
    }

    public Long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
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

    public List<ModelRatingRoom> getRatingRooms() {
        return ratingRooms;
    }

    public void setRatingRooms(List<ModelRatingRoom> ratingRooms) {
        this.ratingRooms = ratingRooms;
    }

    public List<ModelReviewsRoom> getReviewsRooms() {
        return reviewsRooms;
    }

    public void setReviewsRooms(List<ModelReviewsRoom> reviewsRooms) {
        this.reviewsRooms = reviewsRooms;
    }
}
