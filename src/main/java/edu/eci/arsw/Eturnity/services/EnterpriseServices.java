package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.EnterpriseException;
import edu.eci.arsw.Eturnity.Persistence.EnterprisePersistence;
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
public class EnterpriseServices {
    @Autowired
    private EnterprisePersistence esp;
    @Autowired
    private TurnoPersistence tsp;

    public boolean saveEnterprise(Entidad e){
        try {
            return esp.Save(e);
        } catch (EnterpriseException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public Entidad getEnterprise(String nit){
        try {
            return esp.getEnterprise(nit);
        } catch (EnterpriseException e) {
            e.printStackTrace();
            return null;
            //Falta tratarla
        }

    }
    public List<Sede> getOfficeByEnterprise(String nit) throws EnterpriseException {

        esp.getEnterprise(nit).getSedes().forEach(x-> System.out.println(x));
        return esp.getEnterprise(nit).getSedes();

    }

    public List<Servicio> getServicesByEnterprise(String nit) throws EnterpriseException {

        ArrayList<Servicio> servicios = new ArrayList<>();
        for (Sede x : esp.getEnterprise(nit).getSedes()) {
            for (Servicio z: x.getServicios()){
                if(!servicios.contains(z)) servicios.add(z);
            }
        }
        return servicios;

    }
    public List<Entidad> getEnterpriseByCity(String city) throws EnterpriseException {

        return esp.getEnterpriseByCity(city);

    }

    public HashMap<Sede, ArrayList<Turno>> getTurnByEnterprise(String nit) throws EnterpriseException, TurnoException {
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


}
