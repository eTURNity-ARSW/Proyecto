package edu.eci.arsw.Eturnity.model;


import java.util.List;
import org.springframework.data.annotation.Id;


public class Entidad {
    @Id
    private String nit;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String telefono;
    private List<Sede> sedes;

    public Entidad(){

    }
    public Entidad(String nit, String nombre, String  direccion, String ciudad, String telefono){
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public boolean addSede(Sede sede){
        return sedes.add(sede);
    }

    public List<Sede> getSedes(){return sedes;}

    public void setSedes(List<Sede> sedes){this.sedes =  sedes;}

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Entidad{" +
                "nit='" + nit + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
