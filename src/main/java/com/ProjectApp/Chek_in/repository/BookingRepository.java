package com.ProjectApp.Chek_in.repository;

import com.ProjectApp.Chek_in.model.ModelBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<ModelBooking,Long> {
}
