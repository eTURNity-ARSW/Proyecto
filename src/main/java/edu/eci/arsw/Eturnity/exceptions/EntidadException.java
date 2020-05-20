package edu.eci.arsw.Eturnity.exceptions;

public class EntidadException extends Exception {
    public static final String INVALID_NIT = "No existe la empresa solicitada";
    public static final String ALREDY_EXISTS = "La entidad ya se encuentra registrada";
    public static final String NO_EXIST_ADDRESS = "No existe empresa en la dirección";
    public static final String INVALID_NAME = "NO existe entidad con este nombre";
    public static final String INVALID_SERVICE = "NO se encuentran registros del servicio en la entidad";

    public EntidadException(String message){
        super(message);
    }

    public EntidadException(String message, String Additional_Info){
        super(message+" Info: "+Additional_Info);
    }
}
