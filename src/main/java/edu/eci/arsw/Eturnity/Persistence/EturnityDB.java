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



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.eci.arsw.Eturnity.model.Entidad;
import edu.eci.arsw.Eturnity.model.Sede;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.model.Usuario;

public class EturnityDB {

    private static final String urlDb = "jdbc:postgresql://ec2-184-72-236-57.compute-1.amazonaws.com:5432/d3o1qavh7ob2us?user=gmxthezsiokoxr&password=e09ee466adf0398707d90c0769454ddf9ceb4b82855b7ddcf5f411cccec35775";
    private Connection c;
    private Usuario u;
    private Entidad e;
    private Turno t;
    private Sede s;

    public void getConnection() {
        try {
            c = DriverManager.getConnection(urlDb);
        } catch (SQLException e) {

        }
    }

    public List<Usuario> getAllUsers() {
        System.out.println("Entro4");
        List<Usuario> users = new ArrayList<Usuario>();
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            System.out.println(c + "      conection");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario;");
            while (rs.next()) {
                System.out.println(rs.getString("username"));
                u = new Usuario(rs.getString("username"), rs.getString("nombre"), rs.getString("correo"), rs.getString("documento"), rs.getString("contrasena"));
                users.add(u);
            }
            c.close();
            stmt.close();
            rs.close();
            System.out.println(users);
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;

    }

    public void createNewUser(Usuario u) {
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO usuario (username,nombre,correo,documento,contrasena)" + "VALUES ('" + u.getUsername() + "','" + u.getNombre() + "','" + u.getCorreo() + "','" + u.getDocumento() + "','" + u.getContrasena() + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void deleteUser(String username){
        Statement pstmt = null;
        try{
            u = getUsuarioByUsername(username);
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            pstmt=c.createStatement();
            String sql = "DELETE FROM usuario WHERE username = '" + username + "'";
            pstmt = c.createStatement();
            pstmt.executeUpdate(sql);
            c.commit();
            c.close();
        }catch(Exception ex){
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario getUsuarioByUsername(String username) {
        PreparedStatement pstmt = null;
        Usuario u = null;
        try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            String sql = "Select * from usuario where username = ?";
            pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            u = new Usuario(rs.getString("username"), rs.getString("nombre"), rs.getString("correo"), rs.getString("documento"), rs.getString("contrasena"));
            c.close();
            pstmt.close();
            rs.close();
            return u;
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    public List<Turno> getAllTurnos(){
        System.out.println("Entre turnos");
        List<Turno> allTurnos = new ArrayList<Turno>();
        Statement pstmt = null;
        try{
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            pstmt = c.createStatement();
            ResultSet r = pstmt.executeQuery("SELECT * FROM turno;");
            while(r.next()){
                t = new Turno(r.getString("identifier"),r.getString("tipo"), r.getBoolean("valido"),r.getString("fecha"),r.getString("turnouserid"),r.getString("turnosedeid"));
                allTurnos.add(t);
            }
            c.close();
            pstmt.close();
            r.close();
            System.out.println(allTurnos);
        } catch(Exception ex){
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);

        }

        return allTurnos;
    }
    public void createTurno(Turno t){
        Statement pstmt=null;
        try{
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            pstmt=c.createStatement();
            String sql = "INSERT INTO turno (identifier,tipo,valido,fecha,turnouserid,turnosedeid)" 
            + "VALUES ('" + t.getIdentifier()+"','"+t.getTipo()+"','"+t.isValido()
            + "','"+t.getFecha()+"','"+t.getUser()+"','"+t.getSede()+"');";
            pstmt.executeUpdate(sql);
            pstmt.close();
            c.commit();
            c.close();
        }catch(Exception ex){
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	public List<Turno> getTurnosByUsername(String username) {
        String sql = "SELECT * FROM turno WHERE turnouserid = ?";
        List<Turno> allTurnosUsername=new ArrayList<Turno>();
        try{
            if(u==null){
                u=getUsuarioByUsername(username);
            }
            getConnection();
            PreparedStatement pstmt=c.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, u.getUsername());
            ResultSet r = pstmt.executeQuery();
            while(r.next()){
                t = new Turno(r.getString("identifier"),r.getString("tipo"),r.getBoolean("valido"),r.getString("fecha"),r.getString("turnouserid"),r.getString("turnosedeid"));
                allTurnosUsername.add(t);
            }
            u.setTurnos(allTurnosUsername);
            c.close();
            pstmt.close();
        }catch(Exception ex){
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null,ex);
        }
        return allTurnosUsername;
	}

	




    
}
