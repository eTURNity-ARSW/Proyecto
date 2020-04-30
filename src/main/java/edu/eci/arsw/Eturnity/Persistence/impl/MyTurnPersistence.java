package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.EturnityDB;
import edu.eci.arsw.Eturnity.Persistence.TurnoException;
import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.model.Turno;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MyTurnPersistence implements TurnoPersistence {

    @Override
    public boolean guardarTurno(Turno t) throws TurnoException {

        return false;

    }

    @Override
    public Turno getTurnoById(String id) throws TurnoException {

        return null;
    }

    @Override
    public List<Turno> getTurnsByUsername(String user) throws TurnoException {
        return null;

    }

    @Override
    public List<Turno> getTotalTurnos() throws TurnoException {
        return null;
    }

    @Override
    public List<Turno> getTurnsByOffice(String sede) {
        return null;
    }

    @Override
    public boolean updateTurno(Turno t, String id) throws TurnoException {
        return false;
    }

  /*  @Override
    public List<Turno> getAllValidTurnos() throws TurnoException {
        //return turnorep.findByValido();
    }*/

    @Override
    public List<Turno> getTurnosFecha(Date fecha) throws TurnoException {
        return null;
    }

   /*
    public void createTurno(String t){
        System.out.println("Entro a crear user");
        EturnityDB db = new EturnityDB();
        db.createTurno(t);
    }
*/

}
