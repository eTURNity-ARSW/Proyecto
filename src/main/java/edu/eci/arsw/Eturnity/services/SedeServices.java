package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.SedeException;
import edu.eci.arsw.Eturnity.Persistence.SedePersistence;
//mport edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.model.Sede;
import edu.eci.arsw.Eturnity.model.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SedeServices {
    @Autowired
    private SedePersistence sp;
    /*@Autowired
    private TurnoPersistence tsp;*/

   /* public boolean saveSede(Sede s){
        try {
            return sp.Save(s);
        } catch (SedeException ex) {
            ex.printStackTrace();
            return false;
        }
    }*/
    public Sede getSede(String identificador){
        try {
            return sp.getSede(identificador);
        } catch (SedeException e) {
            e.printStackTrace();
            return null;
            //Falta tratarla
        }

    }
    

    public List<Servicio> getServicesBySede(String identificador) throws SedeException {

        ArrayList<Servicio> servicios = new ArrayList<>();
        for (Servicio x : sp.getSede(identificador).getServicios()) {
                if(!servicios.contains(x)) servicios.add(x);
            }
        return servicios;

    }

    public List<Sede> getSedeByCity(String ciudad) throws SedeException {

        return sp.getSedeByCiudad(ciudad);

    }
/*
    public HashMap<Sede, ArrayList<Turno>> getTurnBySede(String identificador) throws SedeException, TurnoException {
        HashMap<Sede, ArrayList<Turno>> turnos = new HashMap<>();
        for (Sede sede : sp.getSede(identificador)){
            for(Turno t: tsp.getTotalTurnos()){
                if(t.getSede().equals(sede.getIdentificador())) {
                    if(turnos.containsKey(sede)){
                        turnos.get(sede).add(t);
                    }else{
                        ArrayList<Turno> nuevoTurno = new ArrayList<>();
                        nuevoTurno.add(t);
                        turnos.put(sede,nuevoTurno);
                    }

                }
            }
        }
        return turnos;
    }*/
	public List<Sede> getAllSedes()throws SedeException{
		return sp.getAll();
	}


}
