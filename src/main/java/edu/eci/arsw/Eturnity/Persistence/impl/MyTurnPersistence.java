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
    public void createTurno(Turno turn) {
        System.out.println("Entro a crear turno");
        EturnityDB db = new EturnityDB();
        db.createTurno(turn);

    }

    @Override
    public List<Turno> getAllTurnos() {
        System.out.println("Entro get allturnos");
        EturnityDB db=new EturnityDB();
        return db.getAllTurnos();
    }

    @Override
    public List<Turno> getTurnosByUsername(String username) {
        System.out.println("Entro a turnos by name");
        EturnityDB db= new EturnityDB();
        return db.getTurnosByUsername(username);
    }

    @Override
    public void  deleteTurnoByUsername(String identifier, String username){
        System.out.println("Entro a eliminar turno MYPERSISTENCE");
        EturnityDB db = new EturnityDB();
        db.deleteTurnoByUsername(identifier, username);
    }
}
