package arsw.proyecto.eTURNity.controllers;

public class UsuarioController {
    private String username;
    private String nombre;
    private String correo;
    private String documento;
    private String contraseña;

    public String getUsername(){
        return username;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDocumento() {
        return documento;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
