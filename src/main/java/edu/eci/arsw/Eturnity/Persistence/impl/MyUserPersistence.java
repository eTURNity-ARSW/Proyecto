package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.EturnityDB;
import edu.eci.arsw.Eturnity.Persistence.UserPersistence;
import edu.eci.arsw.Eturnity.exceptions.UserException;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.model.Usuario;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.springframework.stereotype.Service;

@Service
public class MyUserPersistence implements UserPersistence {
    @Override
    public Usuario getUsuarioByUsername(String username) throws UserException {
        EturnityDB db = new EturnityDB();
        return db.getUsuarioByUsername(username);

    }

  

    @Override
    public boolean saveUser(Usuario user) throws UserException {
        return false;
    }

    public List<Turno> getTurnosByUsername(String username) throws UserException {
        Usuario usuarioByUsername = getUsuarioByUsername(username);
        if (usuarioByUsername!=null) {
            return usuarioByUsername.getTurnos();
        }
        throw new UserException(UserException.USUARIO_INVALIDO);
    }


    //@Override
    public void createNewUser(Usuario u) throws UserException {
        System.out.println("Entro a crear user");
        EturnityDB db = new EturnityDB();
        try {
            if (getUsuarioByUsername(u.getUsername()) == null) {
                db.createNewUser(u);
            } else {
                try {
                    throw new UserException(UserException.USUARIO_REGISTRADO);
                } catch (UserException ex) {
                    Logger.getLogger(MyUserPersistence.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (UserException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<Usuario> getAll() throws UserException{
        System.out.println("Entro3");
        EturnityDB db = new EturnityDB();
        return db.getAllUsers();
    }



    public void deleteUser(String u) throws UserException{
        System.out.println("Entro a borrar user");
        EturnityDB db=new EturnityDB();
        db.deleteUser(u);

    }
}
