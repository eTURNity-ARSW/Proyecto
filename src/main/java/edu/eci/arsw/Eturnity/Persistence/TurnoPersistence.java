package edu.eci.arsw.Eturnity.Persistence;
import java.util.Set;
import edu.eci.arsw.Eturnity.model.Turno;
import org.springframework.stereotype.Repository;


public interface TurnoPersistence {
   public boolean guardarTurno(Turno t) throws TurnoException;
   public Turno getTurnoById(String id)throws TurnoException;
   public Turno getTurnoByUsername(String id)throws TurnoException;
   public Set<Turno> getTotalTurnos() throws TurnoException;

}
