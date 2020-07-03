/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Usuario;
import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Usuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL 1
 */
public class UsuarioDAO2 {
    ConexionDB conn;
    
    public UsuarioDAO2(){
           //Llama al factoryh para ejeuctar secuencias SQL
          this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
    }
    public Usuarios VerLogin(String email, String password)throws SQLException,ClassNotFoundException{
       String jdbcURL = "jdbc:mysql://localhost:3306/bd_inventario";
		String dbUser = "root";
		String dbPassword = "";

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		String sql = "SELECT * FROM tb_usuario WHERE correo = ? and clave = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, email);
		statement.setString(2, password);

		ResultSet result = statement.executeQuery();

		Usuarios user = null;

		if (result.next()) {
			user = new Usuarios();
			//user.(result.getString("fullname"));
			user.setCorreo(result.getString("correo"));
                        user.setNombre(result.getString("nombre"));
                        user.setApellido(result.getString("apellido"));
		}

                
                
		connection.close();

		return user;
    
    }
    
    
    
}
