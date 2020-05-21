package edu.eci.arsw.Eturnity.cache;

import edu.eci.arsw.Eturnity.model.Entidad;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class EntidadCache {
    private static Map<String, Entidad> entityMap = new HashMap<String, Entidad>();

    public Entidad getCacheEntity(String nombre) {
        synchronized (entityMap) {
            System.out.println("cache");
            return entityMap.get(nombre);
        }
    }

    public boolean findEntity(String nombre) {
        synchronized (entityMap) {
            return entityMap.containsKey(nombre);
        }
    }

    public void addEntityCache(Entidad entidad){
        synchronized (entityMap){
            entityMap.put(entidad.getNombre(),entidad);
            entityMap.forEach((key, value) -> System.out.println(key + ":" + value));

        }
    }
}