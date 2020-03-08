package arsw.proyecto.eTURNity.MyBatisDAO;

import arsw.proyecto.eTURNity.DAO.UsuarioDAO;
import arsw.proyecto.eTURNity.Persistence.impl.UsuarioPersistence;
import arsw.proyecto.eTURNity.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBatisUsuarioDAO implements UsuarioDAO {
    @Autowired
    UsuarioPersistence userPer = null;

    @Override
    public void insertarUsuario(String username, String nombre, String correo, String documento, String contraseña){
        Usuario user = new Usuario(username,nombre,correo, documento, contraseña);
        userPer.insertarUsuario(user);
    }
}

