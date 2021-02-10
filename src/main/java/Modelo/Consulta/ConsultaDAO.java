package Modelo.Consulta;

import java.util.List;

/**
 *
 * @author Roque
 */
public interface ConsultaDAO {

    //METODOS
    public List listar(int id);

    public void agregar(Consulta con);

}
