package arsw.proyecto.eTURNity.model;

public class Usuario {
    private String username;
    private String nombre;
    private String correo;
    private String documento;
    private String contrasena;

    public Usuario(String username, String nombre, String correo, String documento, String contrasena) {
        this.username=username;
        this.contrasena=contrasena;
        this.correo=correo;
        this.documento=documento;
        this.nombre=nombre;
    }

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

    public String getContrasena() {
        return contrasena;
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

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
