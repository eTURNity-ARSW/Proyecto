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
                t = new Turno(r.getString("tipo"), r.getString("fecha"), r.getString("turnouserid"), r.getString("turnosedeid"));
                t.setIdentifier(r.getString("identifier"));
                t.setValido(r.getBoolean("valido"));
                t.setId(r.getInt("id"));
                t.setModulo(r.getString("modulo"));
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
            String sql = "INSERT INTO turno (identifier,tipo,valido,fecha,turnouserid,turnosedeid,modulo,id)"
                    + "VALUES ('" + t.getIdentifier() + "','" + t.getTipo() + "','" + t.isValido()
                    + "','" + t.getFecha() + "','" + t.getTurnouserid()+ "','" + t.getTurnosedeid()+ "','" + t.getModulo()+ "','" + t.getId()+ "');";
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
                t = new Turno(r.getString("tipo"), r.getString("fecha"), r.getString("turnouserid"), r.getString("turnosedeid"));
                t.setIdentifier(r.getString("identifier"));
                t.setValido(r.getBoolean("valido"));
                t.setModulo(r.getString("modulo"));
                t.setId(r.getInt("id"));
                t.setSede(getSedeById(t.getTurnosedeid()));
                t.setEntidad(getEntidadByNit(t.getSede().getEntidad()));
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
     * Metodo que permite consultar una entidad por su nit
     * @param nit Es el nit de la entidad 
     * @return Retorna la entidad asociada a ese nit.
     */
    public Entidad getEntidadByNit(String nit) {
        PreparedStatement pstmt = null;
        e = null;
        try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            String sql = "Select * from entidad where nit = ?";
            pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, nit);
            ResultSet rs = pstmt.executeQuery();
            c.close();
            if (rs.next()){
                e = new Entidad(rs.getString("nit"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("ciudad"), rs.getString("telefono"));
            }
            pstmt.close();
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    /**
     * Metodo que permite consultar los turnos de una sede y que sean validos 
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
                t = new Turno(r.getString("tipo"), r.getString("fecha"), r.getString("turnouserid"), r.getString("turnosedeid"));
                t.setIdentifier(r.getString("identifier"));
                t.setValido(r.getBoolean("valido"));
                t.setModulo(r.getString("modulo"));
                allTurnosSede.add(t);
                t.setId(r.getInt("id"));
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
                t = new Turno(r.getString("tipo"), r.getString("fecha"), r.getString("turnouserid"), r.getString("turnosedeid"));
                t.setIdentifier(r.getString("identifier"));
                t.setValido(r.getBoolean("valido"));
                t.setModulo(r.getString("modulo"));
                t.setId(r.getInt("id"));
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
                t = new Turno(r.getString("tipo"), r.getString("fecha"), r.getString("turnouserid"), r.getString("turnosedeid"));
                t.setIdentifier(r.getString("identifier"));
                t.setValido(r.getBoolean("valido"));
                t.setModulo(r.getString("modulo"));
                t.setId(r.getInt("id"));
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
    
    /**
     * Metodo que permite consultar el ultimo turno entregado por la sede.  
     * @param idSede Es el id de la sede donde se quiere consultar su turno actual.
     * @return  Retorna el ultimo turno entregado por la sede.
     */
    public int getTurnoActual(String idSede) {
        PreparedStatement pstmt = null;
        int ultimo = 0;
        try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            String sql = "select * from turno where id = (select max(id) from turno where turnosedeid = '"+idSede+"') and turnosedeid = '"+idSede+"'";
            pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                ultimo = rs.getInt("id");
            }
            c.close();
            pstmt.close();
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ultimo;
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
                System.out.println(rs.getString("nit"));
                e = new Entidad(rs.getString("nit"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("ciudad"), rs.getString("telefono"));
                entidades.add(e);
                getAllSedesByEntidad(e.getNit());
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
            e = new Entidad(rs.getString("nit"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("ciudad"), rs.getString("telefono"));
            getAllSedesByEntidad(e.getNit());
            pstmt.close();
            rs.close();
            return e;
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    //CONSULTAS SEDE
    
    
    /**
     * Metodo que permite consultar todas las sedes. 
     * @return  Retorna todas las sedes.
     */
    public List<Sede> getAllSedes() {
        String SQL = "SELECT * FROM SEDE ;";
        List<Sede> allSedesEntidad = new ArrayList<Sede>();
        try {
            getConnection();
            PreparedStatement pstmt = c.prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pstmt.executeQuery();
            c.close();
            while (rs.next()) {
                s = new Sede(rs.getString("nombre"), rs.getString("ciudad"), rs.getString("direccion"), rs.getString("horario"), rs.getString("sedesentidadid"));
                s.setIdentificador(rs.getString("id"));
                allSedesEntidad.add(s);
                s.setTurnos(getTurnosBySede(s.getIdentificador()));  //JD
            }
            pstmt.close();
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allSedesEntidad;
    }
    
    /**
     * Metodo que permite consultar todas las sedes de una entidad por ciudad.    
     * @param idEntidad Es el id de la entidad.
     * @param ciudad    Es el la ciudad donde se encuentra la sede
     * @return  Retorna todas las sedes de una entidad por ciudad.
     */
    public List<Sede> getSedesByEntidadYCiudad(String idEntidad, String ciudad) {
        String SQL = "SELECT * FROM SEDE WHERE sedesentidadid = '" + idEntidad + "' and ciudad = '"+ ciudad +"'";
        List<Sede> allSedesEntidad = new ArrayList<Sede>();
        try {
            getConnection();
            PreparedStatement pstmt = c.prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pstmt.executeQuery();
            c.close();
            while (rs.next()) {
                s = new Sede(rs.getString("nombre"), rs.getString("ciudad"), rs.getString("direccion"), rs.getString("horario"), rs.getString("sedesentidadid"));
                s.setIdentificador(rs.getString("id"));
                allSedesEntidad.add(s);
                s.setTurnos(getTurnosBySede(s.getIdentificador()));  //JD
            }
            pstmt.close();
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allSedesEntidad;
    }
    
    /**
     * Metodo que permite crear una nueva sede
     * @param sd Es la Sede que se va a agregar a la base de datos.
     */
    public void createSede(Sede sd) {
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO sede (id,ciudad,direccion,horario,sedesentidadid,nombre)" + "VALUES ('" + sd.getIdentificador() + "','" + sd.getCiudad() + "','" + sd.getDireccion() + "','" + sd.getHorario() + "','" + sd.getEntidad() + "','" + sd.getNombre() + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo que permite eliminar una sede
     * @param id
     */
    public void deleteSede(String id) {
        Statement pstmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            pstmt = c.createStatement();
            String sql = "DELETE FROM sede WHERE id = '" + id + "'";
            pstmt = c.createStatement();
            pstmt.executeUpdate(sql);
            c.commit();
            c.close();
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo que permite consultar una sede por su id. 
     * @param id    Es el id de la sede que se quiere buscar.
     * @return  Retorna la sede asociada a el identifier.
     */
    public Sede getSedeById(String id) {
        PreparedStatement pstmt = null;
        s = null;
        try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            String sql = "Select * from sede where id = ?";
            pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            c.close();
            if (rs.next()){
                s = new Sede(rs.getString("nombre"), rs.getString("ciudad"), rs.getString("direccion"), rs.getString("horario"), rs.getString("sedesentidadid"));
                s.setIdentificador(rs.getString("id"));
            }
            pstmt.close();
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(EturnityDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
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
                s = new Sede(rs.getString("nombre"), rs.getString("ciudad"), rs.getString("direccion"), rs.getString("horario"), rs.getString("sedesentidadid"));
                s.setIdentificador(rs.getString("id"));
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