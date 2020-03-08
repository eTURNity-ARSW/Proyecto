package arsw.proyecto.eTURNity.Persistence.impl;
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
}
