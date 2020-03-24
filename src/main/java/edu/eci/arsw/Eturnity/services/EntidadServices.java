package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.EntidadException;
import edu.eci.arsw.Eturnity.Persistence.EntidadPersistence;
import edu.eci.arsw.Eturnity.Persistence.TurnoException;
import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.model.Entidad;
import edu.eci.arsw.Eturnity.model.Sede;
import edu.eci.arsw.Eturnity.model.Servicio;
import edu.eci.arsw.Eturnity.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class EntidadServices {
    @Autowired
    private EntidadPersistence esp;
    @Autowired
    private TurnoPersistence tsp;

    public boolean saveEnterprise(Entidad e){
        try {
            return esp.Save(e);
        } catch (EntidadException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public Entidad getEnterprise(String nit){
        try {
            return esp.getEnterprise(nit);
        } catch (EntidadException e) {
            e.printStackTrace();
            return null;
            //Falta tratarla
        }

    }
    public List<Sede> getOfficeByEnterprise(String nit) throws EntidadException {

        esp.getEnterprise(nit).getSedes().forEach(x-> System.out.println(x));
        return esp.getEnterprise(nit).getSedes();

    }

    public List<Servicio> getServicesByEnterprise(String nit) throws EntidadException {

        ArrayList<Servicio> servicios = new ArrayList<>();
        for (Sede x : esp.getEnterprise(nit).getSedes()) {
            for (Servicio z: x.getServicios()){
                if(!servicios.contains(z)) servicios.add(z);
            }
        }
        return servicios;

    }
    public List<Entidad> getEnterpriseByCity(String city) throws EntidadException {

        return esp.getEnterpriseByCity(city);

    }

    public HashMap<Sede, ArrayList<Turno>> getTurnByEnterprise(String nit) throws EntidadException, TurnoException {
        HashMap<Sede, ArrayList<Turno>> turnos = new HashMap<>();
        for (Sede sede : esp.getEnterprise(nit).getSedes()){
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
    }
	public List<Entidad> getAllEntidades()throws EntidadException{
		return esp.getAll();
	}


}
