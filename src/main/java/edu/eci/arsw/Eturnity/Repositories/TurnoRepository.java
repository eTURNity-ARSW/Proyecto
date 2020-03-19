package edu.eci.arsw.Eturnity.Repositories;

import edu.eci.arsw.Eturnity.model.Turno;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TurnoRepository  extends CrudRepository<Turno,String> {
    public static List<Turno> findByAnybody() {
        return null;
    }
    static List<Turno> findByNull() {
        return null;
    }
    static List<Turno> findByUsuario(String usuario) {
        return null;
    }
    public Turno findByid(String id);
    public static List<Turno> findByUsername(String username){
        return null;
    }


}
