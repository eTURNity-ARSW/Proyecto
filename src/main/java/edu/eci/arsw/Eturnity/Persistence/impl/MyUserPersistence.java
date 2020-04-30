package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.EturnityDB;
import edu.eci.arsw.Eturnity.Persistence.UserException;
import edu.eci.arsw.Eturnity.Persistence.UserPersistence;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MyUserPersistence implements UserPersistence {
    @Override
    public Usuario getUsuarioByUsername(String username) throws UserException {
        EturnityDB db = new EturnityDB();
        return db.getUsuarioByUsername(username);

    }

    @Override
    public Usuario getUserByName(String name) {
        return null;
    }

    @Override
    public boolean saveUser(Usuario user) throws UserException {
        return false;
    }

    public ArrayList<Turno> getTurnosByUsername(String username) throws UserException {
        Usuario usuarioByUsername = getUsuarioByUsername(username);
        if (usuarioByUsername!=null) {return usuarioByUsername.getTurnos();}
        throw new UserException(UserException.USUARIO_INVALIDO);
    }


    //@Override
    public void createNewUser(Usuario u){
        System.out.println("Entro a crear user");
        EturnityDB db = new EturnityDB();
        db.createNewUser(u);
    }

    @Override
    public List<Usuario> getAll() {
        System.out.println("Entro3");
        EturnityDB db = new EturnityDB();
        return db.getAllUsers();
    }



    public void deleteUser(String u){
        System.out.println("Entro a borrar user");
        EturnityDB db=new EturnityDB();
        db.deleteUser(u);

    }
}
