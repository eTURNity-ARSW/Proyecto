package edu.eci.arsw.Eturnity.Persistence;
import java.util.Date;
import java.util.List;

import edu.eci.arsw.Eturnity.model.Sede;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.model.Usuario;


public interface TurnoPersistence {
   public List<Turno> getAllTurnos();
   public void createTurno(Turno turn);
   public List<Turno> getTurnosByUsername(String user);
   public void deleteTurnoByUsername(String identifier, String username);
   public List<Turno> getAllTurnosValido(boolean valido);
   public List<Turno> getTurnoByFecha(String fecha);
   public List<Turno> getTurnosBySede(String sede);

}
