package edu.eci.arsw.Eturnity.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Entidad {
    @Id
    private String nit;
    private String nombre, referencias, direccion, ciudad;
    private long telefono;
    private ArrayList<Sede> sedes;

    public Entidad(){

    }
    public Entidad(String nit, String nombre, String referencias, String  direccion, String ciudad, long telefono){
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.nit = nit;
        this.nombre = nombre;
        this.referencias = referencias;
        this.telefono = telefono;
        this.sedes =  new ArrayList<>();
    }

    public boolean addSede(Sede sede){
        return sedes.add(sede);
    }

    public ArrayList<Sede> getSedes(){return sedes;}

    public void setSedes(ArrayList<Sede> sedes){this.sedes =  sedes;}

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Entidad{" +
                "nit='" + nit + '\'' +
                ", nombre='" + nombre + '\'' +
                ", referencias='" + referencias + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
