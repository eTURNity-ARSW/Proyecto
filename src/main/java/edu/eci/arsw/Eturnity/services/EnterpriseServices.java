package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.EnterpriseException;
import edu.eci.arsw.Eturnity.Persistence.EnterprisePersistence;
import edu.eci.arsw.Eturnity.model.Entidad;
import edu.eci.arsw.Eturnity.model.Sede;
import edu.eci.arsw.Eturnity.model.Servicio;
import edu.eci.arsw.Eturnity.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnterpriseServices {
    @Autowired
    private EnterprisePersistence esp;

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
    public List<Sede> getOfficeByEnterprise(String nit) {
        try {
            esp.getEnterprise(nit).getSedes().forEach(x-> System.out.println(x));
            return esp.getEnterprise(nit).getSedes();
        } catch (EnterpriseException e) {
            e.printStackTrace();
            return null;
            //Falta tratarla
        }
    }

    public List<Servicio> getServicesByEnterprise(String nit){
        try {
            ArrayList<Servicio> servicios = new ArrayList<>();
            for (Sede x : esp.getEnterprise(nit).getSedes()) {
                for (Servicio z: x.getServicios()){
                    if(!servicios.contains(z)) servicios.add(z);
                }
            }
            return servicios;
        } catch (EnterpriseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Entidad> getEnterpriseByCity(String city){
        try {
            return esp.getEnterpriseByCity(city);
        } catch (EnterpriseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void getTurnByEnterprise(String nit){
        try {
            ArrayList<Turno> turnos = new ArrayList<>();
            for (Sede sede : esp.getEnterprise(nit).getSedes()){

            }


        } catch (EnterpriseException e) {
            e.printStackTrace();
        }
    }


}
