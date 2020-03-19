package edu.eci.arsw.Eturnity.model;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Entidad {

    @Id
    private String id;
    private String nombre;
    private String direccion;
    private int telefono;
    private String ciudad;


    public Entidad(){

    }

     public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

     public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

     public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }







}

