/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Paciente;

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
public class PacienteDAOImpl implements IPacienteDAO{

    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;

    ArrayList<Paciente> nacimiento_p;

    // ==Conexion==
    private Connection getConnection() throws SQLException {

        return Pool.getConexion();
    }

   

    

    //CALCULA EDAD DEL PACIENTE MEDIANTE SU FECHA DE NACIMIENTO
    @Override
    public int calcularEdad(String f_nac) {

        String sql = "SELECT TIMESTAMPDIFF(YEAR,?,CURDATE())";

        int edad = 0;

        try {

            conexion = getConnection();

            ps = conexion.prepareStatement(sql);

            ps.setString(1, f_nac);
            rs = ps.executeQuery();

            if (rs.next()) {

                edad = rs.getInt(1);

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

        return edad;

    }

    //AGREGAR PACIENTE A LA BD
    @Override
    public void agregar(Paciente pac) {

        String sql = "INSERT INTO paciente(apellido,nombre,dni,fecha_nacimiento,edad,celular,domicilio,lugar_trabajo,"
                + "antecedentes,alergico,medicamentos,responsable,rela_sexo,rela_obrasocial) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            conexion = getConnection();

            ps = conexion.prepareStatement(sql);

            ps.setString(1, pac.getApellido());
            ps.setString(2, pac.getNombre());
            ps.setString(3, pac.getDni());
            ps.setString(4, pac.getFecha_nac());
            ps.setInt(5, pac.getEdad());
            ps.setString(6, pac.getCelular());
            ps.setString(7, pac.getDomicilio());
            ps.setString(8, pac.getLugar_trabajo());
            ps.setString(9, pac.getAntecedentes());
            ps.setString(10, pac.getAlergia());
            ps.setString(11, pac.getMedicamento());
            ps.setString(12, pac.getResponsable());
            ps.setInt(13, pac.getId_sexo());
            ps.setInt(14, pac.obra_social.getId_social());

            ps.executeUpdate();

        } catch (SQLException e) {

        } finally {

            try {

                ps.close();

                Pool.closeConexion(conexion);

            } catch (SQLException e) {

            }

        }

    } 
    
    // BUSQUEDA DE PACIENTE MEDIANTE DNI
    @Override
    public Paciente getPaciente(String dni) {

        Paciente paciente = new Paciente();

        String sql = "Select apellido,nombre, id_paciente,dni,edad From paciente where dni = ?";

        try {

            conexion = getConnection();

            ps = conexion.prepareStatement(sql);

            ps.setString(1, dni);
            rs = ps.executeQuery();

            if (rs.next()) {

                paciente.setApellido(rs.getString(1));
                paciente.setNombre(rs.getString(2));
                paciente.setId_paciente(rs.getInt(3));
                paciente.setDni(rs.getString(4));
                paciente.setEdad(rs.getInt(5));

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

        return paciente;

    }

    //OBTENER EL PACIENTE PARA MOSTRAR EN LA FICHA
    @Override
    public Paciente getPaciente(int id) {

        Paciente paci = new Paciente();

        String sql = "SELECT apellido,nombre,dni,fecha_nacimiento,celular,domicilio,lugar_trabajo,antecedentes,alergico,medicamentos,responsable,"
                + "rela_sexo,rela_obrasocial FROM paciente WHERE id_paciente = ? ";

        try {

            conexion = getConnection();

            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {

                paci.setApellido(rs.getString(1));
                paci.setNombre(rs.getString(2));

                paci.setDni(rs.getString(3));
                paci.setFecha_nac(rs.getString(4));
                paci.setCelular(rs.getString(5));
                paci.setDomicilio(rs.getString(6));
                paci.setLugar_trabajo(rs.getString(7));
                paci.setAntecedentes(rs.getString(8));
                paci.setAlergia(rs.getString(9));
                paci.setMedicamento(rs.getString(10));
                paci.setResponsable(rs.getString(11));
                paci.setId_sexo(rs.getInt(12));
                paci.obra_social.setId_social(rs.getInt(13));

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

        return paci;
    }

    //ACTUALIZAR LOS DATOS DEL PACIENTE
    @Override
    public void update(Paciente p) {

        String sql = "UPDATE paciente SET apellido = ?, nombre = ?, dni= ?, fecha_nacimiento = ?, edad = ?, celular =?,"
                + "domicilio =?, lugar_trabajo =?, antecedentes=?, alergico=?, medicamentos=?,"
                + " responsable=?, rela_sexo=?,rela_obrasocial=? WHERE id_paciente = ?";

        try {

            conexion = getConnection();

            ps = conexion.prepareStatement(sql);
            ps.setString(1, p.getApellido());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getDni());
            ps.setString(4, p.getFecha_nac());
            ps.setInt(5, p.getEdad());
            ps.setString(6, p.getCelular());
            ps.setString(7, p.getDomicilio());
            ps.setString(8, p.getLugar_trabajo());
            ps.setString(9, p.getAntecedentes());
            ps.setString(10, p.getAlergia());
            ps.setString(11, p.getMedicamento());
            ps.setString(12, p.getResponsable());
            ps.setInt(13, p.getId_sexo());
            ps.setInt(14, p.obra_social.getId_social());

            ps.setInt(15, p.getId_paciente());

            ps.executeUpdate();

        } catch (SQLException e) {

        } finally {

            try {

                ps.close();

                Pool.closeConexion(conexion);

            } catch (SQLException e) {

            }

        }

    }

    //CONTADOR DE VISITAS REALIZADAS POR EL PACIENTE
    @Override
    public int contarVisitas(int id) {

        int visitas = 0;

        String sql = "SELECT COUNT(*) FROM consulta c INNER JOIN paciente p on c.rela_paciente = p.id_paciente where P.id_paciente = ? ";

        try {

            conexion = getConnection();

            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {

                visitas = rs.getInt(1);

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

        return visitas;
    }

    //OBTENER LA FECHA DE NACIMIENTO DE PACIENTES PARA CALCULAR LA EDAD
    @Override
    public void getFechaNacimiento() {

        nacimiento_p = new ArrayList<>();
        Paciente paci;

        String sql = "SELECT id_paciente,fecha_nacimiento FROM paciente";

        try {

            conexion = getConnection();

            ps = conexion.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                paci = new Paciente();
                paci.setId_paciente(rs.getInt(1));
                paci.setFecha_nac(rs.getString(2));

                nacimiento_p.add(paci);

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

    }

    //ACTUALIZAR EDAD DE TODOS LOS PACIENTES
    @Override
    public void actualizarEdad() {
        String sql;
        try {

            conexion = getConnection();

            for (int i = 0; i < nacimiento_p.size(); i++) {

                sql = "UPDATE paciente set edad = (SELECT TIMESTAMPDIFF(YEAR,'" + nacimiento_p.get(i).getFecha_nac() + "',CURDATE())) WHERE id_paciente = '" + nacimiento_p.get(i).getId_paciente() + "'";

                ps = conexion.prepareStatement(sql);

                ps.executeUpdate();

            }
        } catch (SQLException e) {

        } finally {

            try {

                ps.close();
                Pool.closeConexion(conexion);

            } catch (SQLException e) {

            }

        }

    }

    //LISTAR TODOS LOS PACIENTES
    @Override
    public ArrayList<Paciente> listar() {

        ArrayList<Paciente> listar_p = new ArrayList<>();

        Paciente p;

        String sql = "SELECT p.apellido,p.nombre,p.dni,p.edad,p.celular,p.id_paciente FROM paciente p ";

        try {

            conexion = getConnection();

            ps = conexion.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                p = new Paciente();

                p.setApellido(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setDni(rs.getString(3));
                p.setEdad(rs.getInt(4));
                p.setCelular(rs.getString(5));
              
                p.setId_paciente(rs.getInt(6));

                listar_p.add(p);

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

        return listar_p;

    }
    
    // CONTAR MUJERES Y VARONES
    @Override
    public int contarMujeres(){
        
        
        int cantidad = 0;
        
        String sql = "select count(rela_sexo) from paciente where rela_sexo = 1";
        
         try {

            conexion = getConnection();

            ps = conexion.prepareStatement(sql);

            rs = ps.executeQuery();

            if (rs.next()) {

                cantidad = rs.getInt(1);
               
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
         
        return cantidad;
    }
    
    @Override
    public int contarVarones(){
        
        
        int cantidad = 0;
        
        String sql = "select count(rela_sexo) from paciente where rela_sexo = 2";
        
         try {

            conexion = getConnection();

            ps = conexion.prepareStatement(sql);

            rs = ps.executeQuery();

            if (rs.next()) {

                cantidad = rs.getInt(1);
               
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
         
        return cantidad;
    }
    
    
    @Override
        public List listarSexo() {

        List l_sexo = new ArrayList<>();
        Paciente paciente;

        String sql = "SELECT * FROM sexo";

        try {

            conexion = getConnection();

            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                paciente = new Paciente();

                paciente.setId_sexo(rs.getInt(1));
                paciente.setDesc_sexo(rs.getString(2));

                l_sexo.add(paciente);

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
