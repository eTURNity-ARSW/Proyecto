package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.EturnityDB;
import edu.eci.arsw.Eturnity.Persistence.UserException;
import edu.eci.arsw.Eturnity.Persistence.UserPersistence;
import edu.eci.arsw.Eturnity.Repositories.UserRepository;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class MyUserPersistence implements UserPersistence {
    @Autowired
    private UserRepository repository;

    @Override
    public Usuario getUsuarioByUsername(String username) throws UserException {
        Usuario byUsername = repository.findByUsername(username);
        if(byUsername == null) {
            throw new UserException(UserException.USUARIO_INVALIDO);
        }
        return byUsername;

    }

    @Override
    public Usuario getUserByName(String name) {
        Usuario byName = repository.findByNombre(name);
        if(byName != null){
            return byName;
        }
        return null;
    }

    @Override
    public boolean saveUser(Usuario user) throws UserException {
        String pattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@"+"[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";;
        Pattern pat = Pattern.compile(pattern);
        if(repository.findByUsername(user.getUsername())!= null) throw new UserException(UserException.USUARIO_REGISTRADO);
        else
        if(repository.findByCorreo(user.getCorreo())!=null) throw new UserException(UserException.CORREO_REGISTRADO);

        if(!pat.matcher(user.getCorreo()).matches()) {
            System.out.print(user.getCorreo());
            throw new UserException(UserException.CORREO_INVALIDO);
        }
        Usuario save = repository.save(user);
        if (save!=null) return true;
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
        System.out.println("Entro4");
        EturnityDB db = new EturnityDB();
        return db.getAllUsers();
    }
}
