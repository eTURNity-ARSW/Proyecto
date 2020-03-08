package arsw.proyecto.eTURNity.DAO;

public interface UsuarioDAO {

    void insertarUsuario(String username, String nombre, String correo, String documento, String contraseña);
}
