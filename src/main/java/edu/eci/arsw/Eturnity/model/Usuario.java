package edu.eci.arsw.Eturnity.model;


import edu.eci.arsw.Eturnity.Persistence.UserException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Usuario {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String username;
    private String nombre;
    private String correo;
    private String documento;
    private String contrasena;
    private ArrayList<Turno> turnos;
    public Usuario(){
    }
    public Usuario(String username, String nombre, String correo, String documento, String contrasena) {
        this.username=username;
        this.contrasena=contrasena;
        this.correo=correo;
        this.documento=documento;
        this.nombre=nombre;
        this.turnos = new ArrayList<>();
    }

    public ArrayList<Turno> getTurnos() throws UserException {
        if(turnos.isEmpty()){throw new UserException(UserException.SIN_TURNOS);}
        return turnos;
    }

    public String getUsername(){
        return username;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDocumento() {
        return documento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString(){
        return "Usuario{Username: "+username+" Nombre: "+nombre+" Correo: "+correo+"}";
    }
}
