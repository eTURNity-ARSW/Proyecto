package edu.eci.arsw.Eturnity.Persistence;
import java.util.Date;
import java.util.List;

import edu.eci.arsw.Eturnity.model.Sede;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.model.Usuario;


public interface TurnoPersistence {
   //public boolean guardarTurno(Turno t) throws TurnoException;
   //public Turno getTurnoById(String id)throws TurnoException;
   //public List<Turno> getTurnsByUsername(String user)throws TurnoException;
   public List<Turno> getAllTurnos();
   //public List<Turno> getTurnsByOffice(String sede);
   //public boolean updateTurno(Turno t, String id) throws TurnoException;
   //public List<Turno> getTurnosFecha(Date fecha) throws TurnoException;
   public void createTurno(Turno turn);
   public List<Turno> getTurnosByUsername(String user);
   
   public void deleteTurnoByUsername(String identifier, String username);

}
