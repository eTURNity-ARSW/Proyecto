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

import javax.naming.spi.DirStateFactory.Result;

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
    private ArrayList<Turno> turnoTotal;

    public void getConnection() {
        try {
            c = DriverManager.getConnection(urlDb);
        } catch (SQLException e) {

        }
    }

    /* USUARIO */
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
            c.close();
            while (rs.next()) {
                System.out.println(rs.getString("username"));
                u = new Usuario(rs.getString("username"), rs.getString("nombre"), rs.getString("correo"), rs.getString("documento"), rs.getString("contrasena"));
                users.add(u);
            }
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

    public void deleteUser(String username) {
        Statement pstmt = null;
        try {
            u = getUsuarioByUsername(username);
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            pstmt = c.createStatement();
            String sql = "DELETE FROM usuario WHERE username = '" + username + "'";
            pstmt = c.createStatement();
            pstmt.executeUpdate(sql);
            c.commit();
            c.close();
        } catch (Exception ex) {
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

    /*TURNO*/
    public List<Turno> getAllTurnos() {
        System.out.println("Entre turnos");
        List<Turno> allTurnos = new ArrayList<Turno>();
        Statement pstmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            pstmt = c.createStatement();
            ResultSet r = pstmt.executeQuery("SELECT * FROM turno;");
            c.close();
            while (r.next()) {
                t = new Turno(r.getString("identifier"), r.getString("tipo"), r.getBoolean("valido"), r.getString("fecha"), r.getString("turnouserid"), r.getString("turnosedeid"),r.getString("modulo"));
                allTurnos.add(t);
            }
            pstmt.close();
            r.close();
            System.out.println(allTurnos);
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);

        }

        return allTurnos;
    }

    public void createTurno(Turno t) {
        Statement pstmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            pstmt = c.createStatement();
            String sql = "INSERT INTO turno (identifier,tipo,valido,fecha,turnouserid,turnosedeid)"
                    + "VALUES ('" + t.getIdentifier() + "','" + t.getTipo() + "','" + t.isValido()
                    + "','" + t.getFecha() + "','" + t.getUser() + "','" + t.getSede() + "');";
            pstmt.executeUpdate(sql);
            pstmt.close();
            c.commit();
            c.close();
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Turno> getTurnosByUsername(String username) {
        String sql = "SELECT * FROM turno WHERE turnouserid = ?";
        List<Turno> allTurnosUsername = new ArrayList<Turno>();
        try {
            if (u == null) {
                u = getUsuarioByUsername(username);
            }
            getConnection();
            PreparedStatement pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, u.getUsername());
            ResultSet r = pstmt.executeQuery();
            c.close();
            while (r.next()) {
                t = new Turno(r.getString("identifier"), r.getString("tipo"), r.getBoolean("valido"), r.getString("fecha"), r.getString("turnouserid"), r.getString("turnosedeid"),r.getString("modulo"));
                allTurnosUsername.add(t);
            }
            u.setTurnos(allTurnosUsername);
            pstmt.close();
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allTurnosUsername;
    }

    /**
     * Metodo que permite consultar los turnos de una sede y que sean validos JDNJ.
     * @param turnosedeid Es el identificador unico de la sede.
     * @return  Retorna una lista con los turnos validos correspondientes a la sede.
     */
    public List<Turno> getTurnosBySede(String turnosedeid){
        String sql = "SELECT * FROM TURNO WHERE turnosedeid = ? and valido = true";
        List<Turno> allTurnosSede = new ArrayList<Turno>();
        try{
            getConnection();
            PreparedStatement pstmt = c.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, turnosedeid);
            ResultSet r = pstmt.executeQuery();
            c.close();
            while(r.next()){
                t = new Turno(r.getString("identifier"), r.getString("tipo"), r.getBoolean("valido"), r.getString("fecha"), r.getString("turnouserid"), r.getString("turnosedeid"),r.getString("modulo"));
                allTurnosSede.add(t);
                turnoTotal.add(t); //JD
            }
            pstmt.close();
        } catch(Exception ex){
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null,ex);
        }
        return allTurnosSede;
    }




    public List<Turno> getTurnoByFecha(String fecha) {
        System.out.println("eturnitydb");
        String sql = "SELECT * FROM turno WHERE fecha = ?";
        List<Turno> allTurnosFecha = new ArrayList<Turno>();
        try {
            getConnection();
            PreparedStatement pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, fecha);
            ResultSet r = pstmt.executeQuery();
            c.close();
            while (r.next()) {
                t = new Turno(r.getString("identifier"), r.getString("tipo"), r.getBoolean("valido"), r.getString("fecha"), r.getString("turnouserid"), r.getString("turnosedeid"),r.getString("modulo"));
                allTurnosFecha.add(t);
            }
            pstmt.close();
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allTurnosFecha;

    }

    public List<Turno> getAllTurnosValidos(boolean valido) {
        String sql = "Select * from turno where valido = true";
        List<Turno> allTurnosValidos = new ArrayList<Turno>();
        try {
            getConnection();
            c.setAutoCommit(false);
            PreparedStatement pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setPoolable(valido);
            ResultSet r = pstmt.executeQuery();
            c.close();
            while (r.next()) {
                t = new Turno(r.getString("identifier"), r.getString("tipo"), r.getBoolean("valido"), r.getString("fecha"), r.getString("turnouserid"), r.getString("turnosedeid"),r.getString("modulo"));
                allTurnosValidos.add(t);
            }
            pstmt.close();
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allTurnosValidos;
    }

    public void deleteTurnoByUsername(String identifier, String username) {
        System.out.println("Entre borrar turno ETURNITY DB");
        Statement pstmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            String sql = "DELETE FROM turno WHERE turnouserid = '" + username + "' AND identifier = '" + identifier + "'";
            pstmt = c.createStatement();
            pstmt.executeUpdate(sql);
            c.commit();
            c.close();
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*ENTIDAD*/
    public List<Entidad> getAllEntidades() {
        System.out.println("Entro4");
        List<Entidad> entidades = new ArrayList<Entidad>();
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            //System.out.println(c + "      conection");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM entidad;");
            c.close();
            while (rs.next()) {
                turnoTotal = new ArrayList<Turno>();  //JD
                System.out.println(rs.getString("nit"));
                e = new Entidad(rs.getString("nit"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("ciudad"), rs.getString("telefono"));
                entidades.add(e);
                getAllSedesByEntidad(e.getNit());
                e.setTurnos(turnoTotal);   //JD
            }
            stmt.close();
            rs.close();
            System.out.println(entidades);
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entidades;

    }

    public void createEntidad(Entidad e) {
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO entidad (nit,nombre,direccion,ciudad,telefono)" + "VALUES ('" + e.getNit() + "','" + e.getNombre() + "','" + e.getDireccion() + "','" + e.getCiudad() + "','" + e.getTelefono() + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteEntidad(String entidad) {
        Statement pstmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            pstmt = c.createStatement();
            String sql = "DELETE FROM entidad WHERE nit = '" + entidad + "'";
            pstmt = c.createStatement();
            pstmt.executeUpdate(sql);
            c.commit();
            c.close();
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Entidad getEntityByName(String nombre) {
        PreparedStatement pstmt = null;
        e = null;
        try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            String sql = "Select * from entidad where nombre = ?";
            pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();
            c.close();
            rs.next();
            turnoTotal=new ArrayList<Turno>();
            e = new Entidad(rs.getString("nit"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("ciudad"), rs.getString("telefono"));
            getAllSedesByEntidad(e.getNit());
            e.setTurnos(turnoTotal);
            pstmt.close();
            rs.close();
            return e;
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    public List<Sede> getAllSedesByEntidad(String identificador) {
        String SQL = "SELECT * FROM SEDE WHERE sedesentidadid = ?";
        List<Sede> allSedesEntidad = new ArrayList<Sede>();
        try {
            getConnection();
            PreparedStatement pstmt = c.prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, identificador);
            ResultSet rs = pstmt.executeQuery();
            c.close();
            while (rs.next()) {
                s = new Sede(rs.getString("id"), rs.getString("ciudad"), rs.getString("direccion"), rs.getString("horario"), rs.getString("sedesentidadid"));
                allSedesEntidad.add(s);
                s.setTurnos(getTurnosBySede(s.getIdentificador()));  //JD
            }
            e.setSedes(allSedesEntidad);
            pstmt.close();
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allSedesEntidad;
    }

}

	
    




	




    
