package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.TurnoException;
import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.model.Turno;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MyTurnPersistence implements TurnoPersistence {
    @Override
    public void guardarTurno(Turno t) throws TurnoException {

    }

    @Override
    public Turno getTurno(String id, String username) throws TurnoException {
        return null;
    }

    @Override
    public Set<Turno> getTotalTurnos() throws TurnoException {
        return null;
    }

    @Override
    public Set<Turno> getTurnosUsuario(String usuario) throws TurnoException {
        return null;
    }
}
