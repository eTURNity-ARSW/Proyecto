package edu.eci.arsw.Eturnity.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.eci.arsw.Eturnity.model.Entidad;
import edu.eci.arsw.Eturnity.model.Sede;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.model.Usuario;

public class EturnityDB{
    private static final String urlDb = "jdbc:postgresql://ec2-184-72-236-57.compute-1.amazonaws.com:5432/d3o1qavh7ob2us?user=gmxthezsiokoxr&password=e09ee466adf0398707d90c0769454ddf9ceb4b82855b7ddcf5f411cccec35775";
    private Connection c;
    private Usuario u;
    private Entidad e;
    private Turno t;
    private Sede s;
    
    public void getConnection(){
        try{
            c=DriverManager.getConnection(urlDb);
        } catch(SQLException e){

        }
    }

    public List<Usuario> getAllUsers(){
        List<Usuario> users = new ArrayList<Usuario>();
        Statement stmt = null;
        try{
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Usuario;");
            while (rs.next()){
                //u = new Usuario(rs.getString(""))
            }
        }
    }




}