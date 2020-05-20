package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.EntidadException;
import edu.eci.arsw.Eturnity.Persistence.EntidadPersistence;
import edu.eci.arsw.Eturnity.Persistence.TurnoException;
import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.cache.TurnoCache;
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
    @Autowired
    private TurnoCache tc;

    

    public Entidad getEnterprise(String nombre) throws EntidadException {

        return esp.getEnterprise(nombre);

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

	public List<Entidad> getAllEntidades(){
        System.out.println("SERVICIOS");
		return esp.getAllEntidades();
	}

	public void createEntidad(Entidad e) {
        esp.createEntidad(e);
    }
    public void deleteEntidad(String e){
        esp.deleteEntidad(e);
    }

    /*
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
    }*/


}
