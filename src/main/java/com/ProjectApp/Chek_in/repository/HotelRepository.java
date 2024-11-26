package com.ProjectApp.Chek_in.repository;

import com.ProjectApp.Chek_in.model.ModelHotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<ModelHotel,Long> {
}
