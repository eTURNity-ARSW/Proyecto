package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.TurnoException;
import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.Persistence.impl.MyTurnPersistence;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.Repositories.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class TurnoServices {
    @Autowired
    private TurnoPersistence tp;
    public List<Turno> getTurnoUsername(String usuario) throws TurnoException {
        List<Turno> resp = new ArrayList<>();
        if (usuario.equals("anybody")){
            resp=TurnoRepository.findByAnybody();
        }
        else if(usuario.equals("none")){
            resp=TurnoRepository.findByNull();
        }
        else{
            resp= (List<Turno>) TurnoRepository.findByUsername(usuario);
        }
        return resp;
            //tp.getTurnoByUsername("pepito");
    }

    public List<Turno> getAllTurnos() throws TurnoException{
        tp.getTotalTurnos();
        return null;
    }

    






}
