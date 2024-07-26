package genero.infraestructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ciudad.domain.entity.Ciudad;
import genero.domain.entity.Genero;
import genero.domain.services.GeneroServices;
import resource.ConfiguracionBaseDeDatos;

public class GeneroRepository  implements GeneroServices{

    @Override
    public Genero encontrarPorId(Long id) {

        String sql = "SELECT * FROM gender WHERE id = ?";
        Genero genero = null;

        try (Connection connection = ConfiguracionBaseDeDatos.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    genero = new Genero();
                    genero.setId(resultSet.getInt("id"));
                    genero.setName(resultSet.getString("nombre"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genero;
        
    }

    @Override
    public List<Genero> obtenerTodosLGeneros() {
        List<Genero> generos = new ArrayList<>();
        String sql = "SELECT * FROM gender";

        try (Connection connection = ConfiguracionBaseDeDatos.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Genero genero = new Genero();
                    genero.setId(resultSet.getInt("id"));
                    genero.setName(resultSet.getString("nombre"));
                    generos.add(genero);
                    
                }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generos; 
    }

}
