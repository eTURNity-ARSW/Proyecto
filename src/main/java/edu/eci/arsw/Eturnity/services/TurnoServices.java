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

    public List<Turno> getTurnosByUsername(String user) {
      return tp.getTurnosByUsername(user); 
    }
    /*
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
    */

 
	/*public List<Turno> getAllValidTurnos()throws TurnoException{
		return tp.getAllValidTurnos();
	}
	public List<Turno> getTurnosFecha(Date fecha) throws TurnoException {
		return tp.getTurnosFecha(fecha);
    }*/
    
    public void createTurno(Turno t){
        tp.createTurno(t);
   }
    
    
    public List<Turno> getAllTurnos(){
        return tp.getAllTurnos();
    }
    



}
