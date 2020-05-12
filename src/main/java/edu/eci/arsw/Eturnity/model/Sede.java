package edu.eci.arsw.Eturnity.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.springframework.data.annotation.Id;



public class Sede {
    @Id
    private String identificador;
    private String ciudad;
    private String direccion;
    private String horario;
    private ArrayList<Servicio> servicios;
    private String entidad;
    private List turnos;

    public Sede(){}

    public Sede(String id, String city, String address, String date, String entidad){
        this.identificador =  id;
        this.ciudad =  city;
        this.direccion = address;
        this.horario = date;
        this.entidad = entidad;
        this.servicios =  new ArrayList<>();
    }

    public boolean addService(Servicio s){
        return servicios.add(s);
    }

    public boolean removeService(Servicio s){
        return servicios.remove(s);
    }
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public List getTurnos(){
        return turnos;
    }

    public void setTurnos(List turnos){
        this.turnos=turnos;
    }

    @Override
    public String toString() {
        return "Sede{" +
                "id='" + identificador + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", horario=" + horario +
                ", entidad=" + entidad +
                '}';
    }
}
