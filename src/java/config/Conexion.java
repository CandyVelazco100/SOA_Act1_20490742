package config;

import java.sql.*;
/**
 *
 * @author Candy Nohemi
 */
public class Conexion {
    private static Connection con = null;
    private static final String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private static final String user = "root";
    private static final String pass = "root";
    
    
    public static Connection StartCon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }catch(ClassNotFoundException | SQLException e){
            System.err.println("Error conexion: "+ e.toString());
        }
        return con;
    }     
}