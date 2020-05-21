package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.exceptions.TurnoException;
import edu.eci.arsw.Eturnity.model.Turno;
//import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoServices {

    @Autowired
    private TurnoPersistence tp;

    public List<Turno> getTurnosByUsername(String user) throws TurnoException {
        return tp.getTurnosByUsername(user);
    }

    public List<Turno> getTurnosBySede(String sede) throws TurnoException{
        return tp.getTurnosBySede(sede);

    }

    public void createTurno(Turno t) throws TurnoException{
        tp.createTurno(t);
    }

    public List<Turno> getAllTurnos() throws TurnoException{
        return tp.getAllTurnos();
    }

    public void deleteTurnoByUsername(String identifier, String username) throws TurnoException{
        System.out.println("ENTRE A SERVICE");
        tp.deleteTurnoByUsername(identifier, username);

    }

    public List<Turno> getAllTurnosValido(boolean valido) throws TurnoException {
        return tp.getAllTurnosValido(valido);
    }

    public List<Turno> getTurnoByFecha(String fecha) throws TurnoException{
        return tp.getTurnoByFecha(fecha);
    }
    
    public int getSiguienteTurno(String idSede) throws TurnoException{
        return tp.getSiguienteTurno(idSede);
    }

}
