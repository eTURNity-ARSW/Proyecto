package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.TurnoException;
import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.Repositories.TurnoRepository;
import edu.eci.arsw.Eturnity.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;


@Service
public class MyTurnPersistence implements TurnoPersistence {
    @Autowired
    private TurnoRepository turnorep;


    @Override
    public boolean guardarTurno(Turno t) throws TurnoException {
        String pattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@"+"[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";;
        Pattern pat = Pattern.compile(pattern);
        if(turnorep.findByid(t.getId())!=null) throw  new TurnoException(TurnoException.TURNO_REGISTRADO);
        Turno save = turnorep.save(t);
        if (save!=null) return true;
        return false;

    }

    @Override
    public Turno getTurnoById(String id) throws TurnoException {
        Turno byId = turnorep.findByid(id);
        if(byId!=null){
            return byId;
        }
        return null;
    }

    @Override
    public Turno getTurnoByUsername(String username) throws TurnoException {
        Turno byUsername = (Turno) TurnoRepository.findByUsername(username);
        if(byUsername != null){
            return byUsername;
        }
        return null;

    }

    @Override
    public List<Turno> getTotalTurnos() throws TurnoException {
        return (List<Turno>) turnorep.findAll();
    }

    @Override
    public void updateTurno(Turno t, String id) throws TurnoException {

    }


}
