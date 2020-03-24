package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.TurnoException;
import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.model.Turno;
//import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class TurnoServices {
    @Autowired
    private TurnoPersistence tp;

    public List<Turno> getTurnsByUser(String user) {
        try {
            return tp.getTurnsByUsername(user);
        } catch (TurnoException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Turno> getAllTurnos() throws TurnoException {
            return tp.getTotalTurnos();
    }
    public List<Turno> getTurnsBySede(String sede){
        return tp.getTurnsByOffice(sede);
    }
    public Turno getTurn(String id){
        try {
            return tp.getTurnoById(id);
        } catch (TurnoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean saveTurn(Turno turno){
        try {
            return tp.guardarTurno(turno);

        } catch (TurnoException e) {
            e.printStackTrace();
            return false;
        }
    }
	/*public List<Turno> getAllValidTurnos()throws TurnoException{
		return tp.getAllValidTurnos();
	}*/
	public List<Turno> getTurnosFecha(Date fecha) throws TurnoException {
		return tp.getTurnosFecha(fecha);
	}
	



}
