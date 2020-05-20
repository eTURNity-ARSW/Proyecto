package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.cache.TurnoCache;
import edu.eci.arsw.Eturnity.model.Turno;
//import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TurnoServices {

    @Autowired
    private TurnoPersistence tp;
    @Autowired
    private TurnoCache tc;

    public List<Turno> getTurnosByUsername(String user) {
        return tp.getTurnosByUsername(user);
    }

    public List<Turno> getTurnosBySede(String sede) {
        return tp.getTurnosBySede(sede);

    }

    public void createTurno(Turno t) {
        tp.createTurno(t);
    }

    public List<Turno> getAllTurnos() {
        return tp.getAllTurnos();
    }

    public void deleteTurnoByUsername(String identifier, String username) {
        System.out.println("ENTRE A SERVICE");
        tp.deleteTurnoByUsername(identifier, username);

    }

    public List<Turno> getAllTurnosValido(boolean valido) {
        return tp.getAllTurnosValido(valido);
    }

    public List<Turno> getTurnoByFecha(String fecha) {
        return tp.getTurnoByFecha(fecha);
    }
    
    public int getSiguienteTurno(String idSede){
        return tp.getSiguienteTurno(idSede);
    }

}
