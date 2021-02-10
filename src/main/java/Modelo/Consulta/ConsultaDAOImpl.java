/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Consulta;


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
public class ConsultaDAOImpl implements ConsultaDAO{
    
    Connection conexion;
    PreparedStatement ps;
    ResultSet rs =null;
    
    // ==Conexion==
    private Connection getConnection() throws SQLException {

        return Pool.getConexion();
    }
    
    @Override
    public void agregar(Consulta con){
        
        String sql = "INSERT INTO consulta(motivo,fecha,observacion,receta,rela_paciente) values (?,?,?,?,?)";
        
         try {

            conexion = getConnection();
            ps = conexion.prepareStatement(sql);
            
            ps.setString(1, con.getMotivo());
            ps.setString(2, con.getFecha());
            ps.setString(3,con.getObservacion());
            ps.setString(4, con.getReceta());
            ps.setInt(5, con.getRela_pac());
            
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
    
    @Override
    public List listar(int id){
        
        List <Consulta> l_historial = new ArrayList<>();
        Consulta con;
        
       String consulta = "SELECT fecha,motivo,observacion,receta FROM consulta c"
               + " INNER JOIN paciente p on c.rela_paciente = p.id_paciente AND p.id_paciente = ?";
        
          try {

            conexion = getConnection();
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, id);
           
            
            rs = ps.executeQuery();
            
              while (rs.next()) { 
                  
                  con = new Consulta();
                  
                  
                  con.setFecha(rs.getString(1));
                  con.setMotivo(rs.getString(2));
                  con.setObservacion(rs.getString(3));
                  con.setReceta(rs.getString(4));
                  
                  l_historial.add(con);
                  
                  
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
        
          return l_historial;
        
    }
    
   
    
}
