package Modelo.Sexo;



import Conexion.Pool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Roque
 */
public class SexoDaoImpl implements SexoDAO{
    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;
    
    // ==Conexion==
    private Connection getConnection() throws SQLException {

        return Pool.getConexion();
    }
    
    //LISTAR 
    @Override
    public List listar() {

        List l_sexo = new ArrayList<>();
        Sexo sexo;

        String sql = "SELECT * FROM sexo";

        try {

            conexion = getConnection();

            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                sexo = new Sexo();

                sexo.setId_sexo(rs.getInt(1));
                sexo.setDesc_sexo(rs.getString(2));

                l_sexo.add(sexo);

            }

        } catch (SQLException e) {

        } finally {

            try {

                ps.close();
                rs.close();
                Pool.closeConexion(conexion);

            } catch (SQLException e) {

            }

        }

        return l_sexo;

    }
    
}
