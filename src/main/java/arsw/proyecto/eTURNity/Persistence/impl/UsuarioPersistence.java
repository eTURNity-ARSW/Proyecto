package arsw.proyecto.eTURNity.Persistence.impl;

import arsw.proyecto.eTURNity.Persistence.Persistence;
import arsw.proyecto.eTURNity.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioPersistence implements Persistence {
    eturnityDB edb = new eturnityDB();


    @Override
    public void conexionDB() {
        edb.conexionDB();
    }
    public void insertarUsuario(Usuario user){
        edb.insertarUsuario(user);
    }

}
