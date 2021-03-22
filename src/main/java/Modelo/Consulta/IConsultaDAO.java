package Modelo.Consulta;

import java.util.List;

/**
 *
 * @author Roque
 */
public interface IConsultaDAO {

    //METODOS
    public List listar(int id);

    public void agregar(Consulta con);

}
