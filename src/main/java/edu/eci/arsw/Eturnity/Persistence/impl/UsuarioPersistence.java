package edu.eci.arsw.Eturnity.Persistence.impl;
import edu.eci.arsw.Eturnity.Persistence.UserException;
import edu.eci.arsw.Eturnity.Persistence.UserPersistence;
import edu.eci.arsw.Eturnity.Repositories.UserRepository;
import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UsuarioPersistence implements UserPersistence {

    @Autowired
    private UserRepository repository;

    @Override
    public Usuario getUsuarioByUsername(String name) {
        return null;
    }

    @Override
    public boolean conexionDB() {
        String urlDatabase = "jdbc:postgresql://ec2-184-72-236-57.compute-1.amazonaws.com:5432/d3o1qavh7ob2us",
                usuarioDB= "gmxthezsiokoxr",
                passwordDB= "e09ee466adf0398707d90c0769454ddf9ceb4b82855b7ddcf5f411cccec35775";
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(urlDatabase, usuarioDB, passwordDB);
            if(c!=null) return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean saveUser(Usuario user) throws UserException {
        String pattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@"+"[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        Pattern pat = Pattern.compile(pattern);
        boolean bol= pat.matcher(user.getCorreo()).matches();

        if(repository.getUser(user.getUsername())!=null) {
            throw new UserException(UserException.USUARIO_INVALIDO);
        }else if(bol) {
            throw new UserException(UserException.USUARIO_REGISTRADO);
        }else if(repository.getUsuarioByName(user.getUsername())!=null) {
            System.out.print(user.getCorreo());
            throw new UserException(UserException.CORREO_INVALIDO);
        }
        repository.save(user);
        return true;
    }

    @Override
    public Usuario getUser(String username) {
        return repository.getUser(username);
    }

    @Override
    public List<Usuario> getAll() {
        return null;
    }


}
