
package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Usuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pregunta {
    ConexionDB conn;
    public pregunta(){
           //Llama al factoryh para ejeuctar secuencias SQL
          this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
    }
    public Usuarios verPreg (String Pregunta, String Repuesta) throws SQLException, ClassNotFoundException{
        String jdbcURL = "jdbc:mysql://localhost:3306/bd_inventario";
        
            String dbUser = "root";
	    String dbPassword = "";
            
            Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		String sql = "SELECT * FROM tb_usuario WHERE pregunta = ? AND respuesta = ? ";
                System.out.println("Consulta utilizada " + sql);
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, Pregunta);
		statement.setString(2, Repuesta);
        
       ResultSet result = statement.executeQuery();

		Usuarios user = null;

		if (result.next()) {
			user = new Usuarios();
			//user.(result.getString("fullname"));
			user.setCorreo(result.getString("correo"));
                        user.setNombre(result.getString("nombre"));
                        user.setClave(result.getString("clave"));
		}

                
                
		connection.close();

		return user;
    
    }
}
