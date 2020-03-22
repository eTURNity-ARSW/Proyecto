package edu.eci.arsw.Eturnity.Persistence;
import java.util.List;

import edu.eci.arsw.Eturnity.model.Sede;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.model.Usuario;


public interface TurnoPersistence {
   public boolean guardarTurno(Turno t) throws TurnoException;
   public Turno getTurnoById(String id)throws TurnoException;
   public List<Turno> getTurnsByUsername(String user)throws TurnoException;
   public List<Turno> getTotalTurnos() throws TurnoException;
   public List<Turno> getTurnsByOffice(String sede);

}
