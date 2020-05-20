package edu.eci.arsw.Eturnity.exceptions;


public class TurnoException extends Exception {
    public static final String TURNO_REGISTRADO="El turno ya existe";
    public static final String INVALID_ID = "No existe el turno solicitado";
    public static final String INVALID = "No es un turno valido";
    public static final String INVALID_DATE = "No es una fecha valida";
    public static final String INVALID_USER = "No tiene relacion con este usuario";
    public static final String INVALID_SEDE = "No existe este turno en esta sede";
    public TurnoException(String message){
        super(message);
    }
    
}

