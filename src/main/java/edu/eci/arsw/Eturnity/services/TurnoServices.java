package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.TurnoException;
import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TurnoServices {
    @Autowired
    private TurnoPersistence tp;
    public void getTurnoUsername() throws TurnoException {
        tp.getTurnoByUsername("pepito");
    }

    public List<Turno> getAllTurnos() throws TurnoException{
        tp.getTotalTurnos();
        return null;
    }






}
