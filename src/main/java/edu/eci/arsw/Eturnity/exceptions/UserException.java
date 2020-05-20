package edu.eci.arsw.Eturnity.exceptions;

public class UserException extends Exception {
    public static String USUARIO_REGISTRADO ="El usuario ya existe";
    public static String CORREO_REGISTRADO ="EL correo ya existe";
    public static String USUARIO_INVALIDO ="El usuario no es valido";
    public static String CORREO_INVALIDO ="Correo no es valido";
    public static String DOCUMENTO_INVALIDO="Este número de documento no es valido";
    public static String SIN_TURNOS = "El usuario no ha generado turnos";
    public static String SIN_ENTIDADES ="El usuario no se encuentra registrado en ninguna entidad";

    public UserException(String message){
        super(message);
    }

}
