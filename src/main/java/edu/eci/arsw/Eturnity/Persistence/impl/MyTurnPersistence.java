package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.EturnityDB;
import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.exceptions.TurnoException;
import edu.eci.arsw.Eturnity.model.Turno;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class MyTurnPersistence implements TurnoPersistence {

    @Override
    public void createTurno(Turno turn) throws TurnoException{
        System.out.println("Entro a crear turno");
        EturnityDB db = new EturnityDB();
        db.createTurno(turn);

    }

    @Override
    public List<Turno> getAllTurnos() throws TurnoException {
        System.out.println("Entro get allturnos");
        EturnityDB db = new EturnityDB();
        return db.getAllTurnos();
    }

    @Override
    public List<Turno> getTurnosByUsername(String username) throws TurnoException {
        System.out.println("Entro a turnos by name");
        EturnityDB db = new EturnityDB();
        return db.getTurnosByUsername(username);
    }

    @Override
    public void deleteTurnoByUsername(String identifier, String username) throws TurnoException {
        System.out.println("Entro a eliminar turno MYPERSISTENCE");
        EturnityDB db = new EturnityDB();
        db.deleteTurnoByUsername(identifier, username);
    }

    @Override
    public List<Turno> getAllTurnosValido(boolean valido) throws TurnoException {
        System.out.println("Entro a consultar turnos validos");
        EturnityDB db = new EturnityDB();
        return db.getAllTurnosValidos(valido);
    }

    @Override
    public List<Turno> getTurnoByFecha(String fecha) throws TurnoException {
        EturnityDB db = new EturnityDB();
        return db.getTurnoByFecha(fecha);
    }

    @Override
    public List<Turno> getTurnosBySede(String sede) throws TurnoException {
        EturnityDB db = new EturnityDB();
        return db.getTurnosBySede(sede);
    }

    @Override
    public int getSiguienteTurno(String idSede) throws TurnoException {
        EturnityDB db = new EturnityDB();
        int actual = db.getTurnoActual(idSede);
        int ans;
        if (actual == 99) {
            ans = 0;
        } else {
            ans = actual + 1;
        }
        return ans;
    }

}
