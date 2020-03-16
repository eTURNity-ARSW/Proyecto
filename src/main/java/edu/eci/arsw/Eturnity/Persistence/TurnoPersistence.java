package edu.eci.arsw.Eturnity.Persistence;
import java.util.Set;
import edu.eci.arsw.Eturnity.model.Turno;
import org.springframework.stereotype.Service;

@Service
public interface TurnoPersistence {
   public void guardarTurno(Turno t) throws TurnoException;
   public Turno getTurno(String id, String username) throws TurnoException;
   public Set<Turno> getTotalTurnos() throws TurnoException;
   public Set<Turno> getTurnosUsuario(String usuario) throws TurnoException;
}
