package edu.eci.arsw.Eturnity.cache;

import edu.eci.arsw.Eturnity.model.Turno;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class TurnoCache {
    private static Map<String, List<Turno>> entityTurns = new HashMap<String, List<Turno>>();

    public List<Turno> getTurnoByEntidadCache(String entidad){
        synchronized (entityTurns){
            return entityTurns.get(entidad);
        }

    }
}
