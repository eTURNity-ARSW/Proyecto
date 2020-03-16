package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.TurnoException;
import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TurnoServices {
    @Autowired
    private TurnoPersistence tp;
    public void getUser() throws TurnoException {
        tp.getTurnoByUsername("pepito");
    }



}
