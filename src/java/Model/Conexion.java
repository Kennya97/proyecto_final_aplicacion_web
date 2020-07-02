package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("(jdbc:mysql://localhost:3306/bd_inventario?zeroDateTimeBehavior=convertToNull [root on Default schema]"); 
        } catch (ClassNotFoundException | SQLException e){
        }
        return con;
    }
}



