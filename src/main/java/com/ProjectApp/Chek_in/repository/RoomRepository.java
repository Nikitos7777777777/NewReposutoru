package com.ProjectApp.Chek_in.repository;

import com.ProjectApp.Chek_in.model.ModelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<ModelRoom,Long> {
}
