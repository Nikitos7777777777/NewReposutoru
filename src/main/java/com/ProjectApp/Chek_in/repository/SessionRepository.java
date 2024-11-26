package com.ProjectApp.Chek_in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ProjectApp.Chek_in.model.ModelSession;

public interface SessionRepository extends JpaRepository<ModelSession,Long> {

}
