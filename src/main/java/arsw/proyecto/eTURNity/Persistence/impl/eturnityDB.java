package arsw.proyecto.eTURNity.Persistence.impl;
import arsw.proyecto.eTURNity.model.Usuario;

import java.sql.*;


public class eturnityDB {
    static String urlDatabase = "jdbc:postgresql://ec2-184-72-236-57.compute-1.amazonaws.com:5432/d3o1qavh7ob2us";
    static String usuarioDB= "gmxthezsiokoxr";
    static String passwordDB= "e09ee466adf0398707d90c0769454ddf9ceb4b82855b7ddcf5f411cccec35775";
    static Connection c = null;

    public void conexionDB() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(urlDatabase, usuarioDB, passwordDB);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarUsuario(Usuario user){
        Usuario u = user;
        Statement stmt = null;
        if(c==null){
            try{
                c=DriverManager.getConnection(urlDatabase,usuarioDB,passwordDB);
            }
            catch(Exception e){

            }
        }
        try{
            Class.forName("org.postgresql.Driver");
            stmt = c.createStatement();
            String sql = "INSERT INTO USUARIO (USERNAME,NOMBRE,CORREO,DOCUMENTO,CONTRASENA)"
                    + "VALUES ('camilavieda04', 'sarah vieda', 'camivi04@gmail.com','1032502827','1234');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        }catch(Exception e){
            System.exit(0);
        }
    }


}
