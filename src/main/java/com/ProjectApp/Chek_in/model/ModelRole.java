package com.ProjectApp.Chek_in.model;

import java.util.List;

import com.fasterxml.classmate.AnnotationOverrides.StdImpl;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ModelRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    private String nameRole;
    
    public ModelRole(){

    }
    public ModelRole(Long idRole,String nameRole){
        this.idRole = idRole;
        this.nameRole = nameRole;

    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getnameRole() {
        return nameRole;
    }

    public void setnameRole(String nameRole) {
        this.nameRole = nameRole;
    }

}
