
package Factory;

/**
 *
 * @author castr
 */

public class FactoryConexionDB {
//PODEMOS DEFINIR LA CONFIGURACION PARA DIFERENTES BASES DE DATOS

public static final int MySQL = 1;  //PARA CONECTAR A MYSQL
public static String[] configMySQL = {"bd_inventario", "root", ""};


public static ConexionDB open (int tipoDB){
switch (tipoDB){
    
case FactoryConexionDB.MySQL:
return new MySQLConexionFactory(configMySQL);
default:
return null;
}
}
}
