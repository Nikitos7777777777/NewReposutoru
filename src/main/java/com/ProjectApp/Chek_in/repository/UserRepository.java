package com.ProjectApp.Chek_in.repository;

import com.ProjectApp.Chek_in.model.ModelUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<ModelUser,Long> {
    // Optional<ModelUser> findByUsername(Long username);
}
