package edu.eci.arsw.Eturnity.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Servicio {
    @Id
    String type;
    String description;

    public Servicio(){}

    public Servicio(String type, String description){
        this.type = type;
        this.description = description;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
