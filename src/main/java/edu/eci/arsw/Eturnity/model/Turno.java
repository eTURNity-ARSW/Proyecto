package edu.eci.arsw.Eturnity.model;
import java.util.Date;
import org.springframework.data.annotation.Id;


public class Turno {
    @Id
    private String identifier;
    private String tipo;
    private boolean valido;
    private Date fecha;
    private String user;
    private String sede;

    public Turno(){
    }

    
    public Turno(String identifier, String tipo, String user, String sede){
        this.identifier=identifier;
        this.tipo=tipo;
        this.user=user;
        this.sede=sede;
    }


    public Turno(String identifier, String tipo, String user, String sede, Date fecha, boolean valido){
        this.identifier = identifier;
        this.tipo = tipo;
        this. user = user;
        this.sede = sede;
        this. fecha = fecha;
        this. valido = valido;
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

    public void setIdentifier(String id) {
        this.identifier = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "Turno{id: " + identifier + ", tipo: " + tipo + ", User: " + user + ", fecha: " + fecha +", sede: " + sede + '}';
    }
}
