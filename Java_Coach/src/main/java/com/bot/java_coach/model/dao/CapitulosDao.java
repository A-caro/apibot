package com.bot.java_coach.model.dao;

import com.bot.java_coach.model.dto.CapitulosDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CapitulosDao {
    private Connection con;
    private Connection connection;

    public CapitulosDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Connection(jdbcURL, jdbcUsername, jdbcPassword);
    }


    // listar todos los productos
    public List<CapitulosDto> listarCapitulosDto() throws SQLException {

        List<CapitulosDto> listaCapitulosDto = new ArrayList<CapitulosDto>();
        String sql = "SELECT * FROM capitulos";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            int id_capitulo = resulSet.getInt("id_capitulo");
            int numeroCapitulo = resulSet.getInt("numeroCapitulo");
            String nombreCapitulo = resulSet.getString("nombreCapitulo");
            int id_nivel = resulSet.getInt("id_nivel");

            CapitulosDto capitulosDto = new CapitulosDto(id_capitulo, numeroCapitulo, nombreCapitulo, id_nivel);
            listaCapitulosDto.add(capitulosDto);
        }
        con.desconectar();
        return listaCapitulosDto;
    }

    // obtener por id
    public CapitulosDto obtenerPorId(int id_capitulo) throws SQLException {
       CapitulosDto capitulosDto = null;

        String sql = "SELECT * FROM capitulos";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id_capitulo);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            capitulosDto = new CapitulosDto(res.getInt("id_capitulo"), res.getInt("numeroCapitulo"), res.getString("nombreCapitulo"),
                    res.getInt("id_nivel"));
        }
        res.close();
        con.desconectar();

        return capitulosDto;
    }

    // actualizar
    public boolean actualizar(CapitulosDto capitulosDto) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE capitulos SET numeroCapitulo=?,nombreCapitulo=?, id_nivel=? WHERE id_capitulo=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, capitulosDto.getNumeroCapitulo());
        statement.setString(2, capitulosDto.getNombreCapitulo());
        statement.setInt(3, capitulosDto.getId_nivel());
        statement.setInt(4, capitulosDto.getId_capitulo());
        rowActualizar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowActualizar;
    }

}


