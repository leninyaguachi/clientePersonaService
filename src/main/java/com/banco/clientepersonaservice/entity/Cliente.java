package com.banco.clientepersonaservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Cliente extends Persona {

    @NotNull
    @Column(name = "clienteid", unique = true)
    private Long clienteid;

    @NotNull
    @Size(min = 6, max = 20)
    private String contrasena;

    @NotNull
    private boolean estado;

    // Getters y Setters

    public Long getClienteid() {
        return clienteid;
    }

    public void setClienteid(Long clienteid) {
        this.clienteid = clienteid;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}