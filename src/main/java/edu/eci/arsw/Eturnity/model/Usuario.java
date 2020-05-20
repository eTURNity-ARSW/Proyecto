package edu.eci.arsw.Eturnity.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Usuario {

    @Id
    public String username;

    private String nombre;
    private String correo;
    private String documento;
    private String contrasena;
    private List turnos;
    private List entidades;

    public Usuario(){

    }
    

    public Usuario(String username, String nombre, String correo, String documento, String contrasena) {
        this.username=username;
        this.contrasena=contrasena;
        this.correo=correo;
        this.documento=documento;
        this.nombre=nombre;
        //this.turnos = new ArrayList<>();
        //this.entidades = new ArrayList<>();


        //this.ubicacion = "";
    }

    public List getTurnos()  {
        return turnos;
    }

    public void setTurnos(List turnos){
        this.turnos = turnos;
    }

    public List getEntidades() {
        return entidades;
    }

    public void setEntidades(List entidades) {
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
