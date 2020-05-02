package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.TurnoException;
import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.Persistence.UserException;
import edu.eci.arsw.Eturnity.Persistence.UserPersistence;
import edu.eci.arsw.Eturnity.model.Entidad;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

@Service
public class UserServices {
    @Autowired
    private UserPersistence usp;
    @Autowired
    private TurnoPersistence tsp;

    public boolean saveUser(Usuario user) throws UserException {
        return usp.saveUser(user);
    }
    public Usuario getUser(String username) throws UserException {
        return usp.getUsuarioByUsername(username);
    }

    public List<Usuario> getAllUsers() throws UserException {
        return usp.getAll();
    }

    public void createNewUser(Usuario u){
         usp.createNewUser(u);
    }

    public void deleteUser(String u){
        usp.deleteUser(u);
    }



    public List<Turno> ConsultTurnsByUser(String username) throws UserException {
        return usp.getUsuarioByUsername(username).getTurnos();
    }

    public List<Entidad> ConsultEnterpriseByUser(String username) throws UserException {
        return usp.getUsuarioByUsername(username).getEntidades();
    }
    /*
    public Turno consultCurrentTurnBySede(String sede) throws TurnoException {
        List<Turno> turnos = tsp.getTurnsByOffice(sede);
        Turno currentTurn = null;
        if(turnos.get(0).isValido()) currentTurn = turnos.get(0);
        for(int i = 0; i<turnos.size();i++){
            if(turnos.get(i).CompareTo(currentTurn)>0) currentTurn = turnos.get(i);
        }
        return currentTurn;
    }

    public Turno consultCurrentTurnBySedeAndService(String sede, char service) throws TurnoException{
        List<Turno> turnos = tsp.getTurnsByOffice(sede);
        Turno currentTurn = null;
        if(turnos.get(0).isValido() && turnos.get(0).getIdentifier().charAt(0)==service) currentTurn = turnos.get(0);
        for(int i = 0; i<turnos.size();i++){
            if(turnos.get(i).CompareTo(currentTurn, service)>0) currentTurn = turnos.get(i);
        }
        return currentTurn;

    }*/

}

