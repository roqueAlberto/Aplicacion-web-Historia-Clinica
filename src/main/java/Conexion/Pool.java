package Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Roque
 */
public class Pool {
    

  private static BasicDataSource ds = null;

    public static DataSource getDataSource() {

        if (ds == null) {

            ds = new BasicDataSource();
            ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
            ds.setUsername("root");
            ds.setPassword("");
            ds.setUrl("jdbc:mysql://localhost:3306/dr_billordo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

            ds.setMaxTotal(20);
            ds.setMinIdle(5);  //CANTIDAD MINIMA DE CONEXIONES INACTIVAS
            ds.setMaxIdle(10);  //CANTIDAD MAXIMAS DE CONEXIONES INACTIVAS
            ds.setMaxWaitMillis(-1); //TIEMPO DE ESPERA PARA EL USUARIO, PARA TENER UNA CONEXION
        }

        return ds;
    }

  

    public static Connection getConexion() throws SQLException {

        return getDataSource().getConnection();
    }

    public static void closeConexion(Connection conexion) throws SQLException {

        conexion.close();

    }
    
}