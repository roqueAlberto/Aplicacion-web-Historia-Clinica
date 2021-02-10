/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ObraSocial;

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
public class ObraSocialDAOImpl implements ObraSocialDAO{

    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;

    // ==Conexion==
    private Connection getConnection() throws SQLException {

        return Pool.getConexion();
    }

    //OBTENER LAS OBRAS SOCIALES
    @Override
    public List listar() {

        List l_osocial = new ArrayList<>();

        Obra_Social o_social;

        String sql = "SELECT * FROM obra_social";

        try {

            conexion = getConnection();

            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                o_social = new Obra_Social();

                o_social.setId_social(rs.getInt(1));
                o_social.setDesc_social(rs.getString(2));

                l_osocial.add(o_social);

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

        return l_osocial;

    }

}
