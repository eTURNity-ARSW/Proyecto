package edu.eci.arsw.Eturnity.model;


import edu.eci.arsw.Eturnity.Persistence.UserException;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Usuario {

    @Id
    private String username;
    private String nombre;
    private String correo;
    private String documento;
    private String contrasena;
    private ArrayList<Turno> turnos;
    private ArrayList<Entidad> entidades;


    //private String ubicacion;

    public Usuario(){
    }

    public Usuario(String username, String nombre, String correo, String documento, String contrasena) {
        this.username=username;
        this.contrasena=contrasena;
        this.correo=correo;
        this.documento=documento;
        this.nombre=nombre;
        this.turnos = new ArrayList<>();
        this.entidades = new ArrayList<>();


        //this.ubicacion = "";
    }

    public ArrayList<Turno> getTurnos() throws UserException {
        if(turnos.isEmpty()){throw new UserException(UserException.SIN_TURNOS);}
        return turnos;
    }

    public void setTurnos(ArrayList<Turno> turnos){
        this.turnos = turnos;
    }

    public ArrayList<Entidad> getEntidades() throws  UserException{
        if(entidades.isEmpty()){throw new UserException((UserException.SIN_ENTIDADES));}
        return entidades;
    }

    public void setEntidades(ArrayList<Entidad> entidades) {
        this.entidades = entidades;
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


    //public String getUbicacion(){return ubicacion;}

    //public void setUbicacion(String ubicacion){this.ubicacion =  ubicacion;}

}
