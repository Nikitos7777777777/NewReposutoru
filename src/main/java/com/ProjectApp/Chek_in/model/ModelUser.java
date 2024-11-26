package com.ProjectApp.Chek_in.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

@Entity
public class ModelUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String username;

    @Size(min=4,message = "Поновой заполняй")
    private String password;

    @Nullable
    private boolean active;

    @Nullable
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ModelBooking> bookings;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private ModelRole role;

    public ModelUser(){

    }
    public ModelUser(Long idUser, String username, String password, boolean active, List<ModelBooking> bookings,ModelRole role) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.active = active;
        this.bookings = bookings;
        this.role = role;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<ModelBooking> getBookings() {
        return bookings;
    }

    public void setBookings(List<ModelBooking> bookings) {
        this.bookings = bookings;
    }

    public ModelRole getRole() {
        return role;
    }

    public void setRole(ModelRole role) {
        this.role = role;
    }
}
