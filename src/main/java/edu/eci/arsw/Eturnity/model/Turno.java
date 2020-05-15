package edu.eci.arsw.Eturnity.model;
import java.util.Date;
import org.springframework.data.annotation.Id;


public class Turno {
    @Id
    private String identifier;
    private String tipo;
    private boolean valido;
    private String fecha;
    private String turnouserid;
    private String turnosedeid;
    private String modulo;
    private int id;
    
    //Atributos solo para consulta del usuario
    private Sede sede;
    private Entidad entidad;

    public Turno(){
    }

    
    
    public Turno(String tipo, String fecha, String turnouserid, String turnosedeid,String modulo){
        this.tipo = tipo;
        this. fecha = fecha;
        this. turnouserid = turnouserid;
        this.turnosedeid = turnosedeid;
        this.modulo=modulo;
        
    }

    public int CompareTo(Turno turno){
        if(turno==null){return 1;}
        if(turno.identifier.charAt(0)==this.identifier.charAt(0)) {
            if (this.valido) {
                int i = this.identifier.compareTo(turno.identifier);
                return i > 0 ? 1 : 0;
            }
        }
        return 0;
    }
    public int CompareTo(Turno turno, char service){
        if(turno==null && this.identifier.charAt(0) == service){return 1;}
        if(turno.identifier.charAt(0)==this.identifier.charAt(0) && this.identifier.charAt(0)==service) {
            if (this.valido) {
                int i = this.identifier.compareTo(turno.identifier);
                return i > 0 ? 1 : 0;
            }
        }
        return 0;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTurnouserid() {
        return turnouserid;
    }

    public void setTurnouserid(String turnouserid) {
        this.turnouserid = turnouserid;
    }

    public String getTurnosedeid() {
        return turnosedeid;
    }

    public void setTurnosedeid(String turnosedeid) {
        this.turnosedeid = turnosedeid;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
    
    

    @Override
    public String toString() {
        return "Turno{id: " + identifier + ", tipo: " + tipo + ", User: " + turnouserid + ", fecha: " + fecha +", sede: " + turnosedeid + '}';
    }
}
