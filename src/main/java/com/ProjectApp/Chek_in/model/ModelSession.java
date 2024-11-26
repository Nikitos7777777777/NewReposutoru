package com.ProjectApp.Chek_in.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Entity
public class ModelSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSession;

    private String keySession;

    @OneToOne
    @JoinColumn(name = "user_id")
    private ModelUser user;

    public ModelSession(){
        
    }

    public ModelSession(Long idSession, String keySession,ModelUser user){
        this.idSession = idSession;
        this.keySession = keySession;
        this.user = user;
    }

    public Long getIdSession() {
        return idSession;
    }

    public void setIdSession(Long idSession) {
        this.idSession = idSession;
    }

    public String getkeySession() {
        return keySession;
    }

    public void setkeySession(String keySession) {
        this.keySession = keySession;
    }

    public ModelUser getuser() {
        return user;
    }

    public void setuser(ModelUser user) {
        this.user = user;
    }
}

