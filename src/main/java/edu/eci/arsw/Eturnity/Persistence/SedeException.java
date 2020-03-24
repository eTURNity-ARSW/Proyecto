package edu.eci.arsw.Eturnity.Persistence;

public class SedeException extends Exception {
    public static final String INVALID_IDENTIFIER = "No existe la sede solicitada";
    public static final String ALREDY_EXISTS = "La sede ya se encuentra registrada";
    public static final String NO_EXIST_CITY = "No existe sede en la ciudad";
    public static final String NO_EXIST_DIRECCION = "No existe sede en esta direccion";
    public static final String INVALID_ENTIDAD = "NO existe sede en esta entidad";

    public SedeException(String message){
        super(message);
    }

    public SedeException(String message, String Additional_Info){
        super(message+" Info: "+Additional_Info);
    }
}