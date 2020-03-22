package edu.eci.arsw.Eturnity.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Servicio {
    @Id
    TipoServicio type;
    String description;

    public Servicio(){}

    public Servicio(TipoServicio type, String description){
        this.type = type;
        this.description = description;

    }

    public TipoServicio getType() {
        return type;
    }

    public void setType(TipoServicio type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
