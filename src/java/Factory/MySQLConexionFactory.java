
package Factory;

import java.sql.Connection;

/**
 *
 * @author castr
 */


import java.sql.Connection;
import java.sql.DriverManager;


public  final  class MySQLConexionFactory extends ConexionDB {

    public MySQLConexionFactory(String[]  criterios){
    this.parametros= criterios; //PASAR LOS CRITERIOS AL ARRAY  DE LA CLASE PADRE PARAMETROS
    this.open();//LLAMAR EL METODO OPEN
    
    }
    
    
    
@Override
Connection open() {
try{
Class.forName("com.mysql.jdbc.Driver");

//EN THIS PARAMETER IRAN LOS DATOS RESPECTIVOS DE NOMBRE DE LA BD USUARIO Y CLASE
this.conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+this.parametros[0], this.parametros[1], this.parametros[2]);


    
}catch(Exception ex){
    
ex.printStackTrace();

}
return this.conexion;
}
}
    




