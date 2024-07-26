package ciudad.infraestructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ciudad.domain.entity.Ciudad;
import ciudad.domain.services.CiudadServices;
import resource.ConfiguracionBaseDeDatos;

public class CiudadRepository implements CiudadServices{

    @Override
    public List<Ciudad> obtenerTodasLasCiudades() {
    
        List<Ciudad> ciudades = new ArrayList<>();
        String sql = "SELECT * FROM city";

        try (Connection connection = ConfiguracionBaseDeDatos.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setId(resultSet.getInt("id"));
                ciudad.setNombre(resultSet.getString("nombre"));
                ciudades.add(ciudad);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ciudades;
        
    }

    @Override
    public Ciudad encontrarPorId(Long id) {
        String sql = "SELECT * FROM city WHERE id = ?";
        Ciudad ciudad = null;

        try (Connection connection = ConfiguracionBaseDeDatos.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    ciudad = new Ciudad();
                    ciudad.setId(resultSet.getInt("id"));
                    ciudad.setNombre(resultSet.getString("nombre"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ciudad;
    }
    



}
