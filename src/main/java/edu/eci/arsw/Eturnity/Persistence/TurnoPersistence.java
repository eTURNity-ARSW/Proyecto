package edu.eci.arsw.Eturnity.Persistence;
import java.util.Date;
import java.util.List;

import edu.eci.arsw.Eturnity.exceptions.TurnoException;
import edu.eci.arsw.Eturnity.model.Sede;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.model.Usuario;


public interface TurnoPersistence {
   public List<Turno> getAllTurnos() throws TurnoException;
   public void createTurno(Turno turn) throws TurnoException;
   public List<Turno> getTurnosByUsername(String user) throws TurnoException;
   public void deleteTurnoByUsername(String identifier, String username)throws TurnoException;
   public List<Turno> getAllTurnosValido(boolean valido)throws TurnoException;
   public List<Turno> getTurnoByFecha(String fecha)throws TurnoException;
   public List<Turno> getTurnosBySede(String sede)throws TurnoException;
   public int getSiguienteTurno(String idSede)throws TurnoException;

}
