package persons.infraestructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ciudad.domain.entity.Ciudad;
import ciudad.infraestructure.out.CiudadRepository;
import genero.domain.entity.Genero;
import genero.infraestructure.out.GeneroRepository;
import persons.domain.entity.Persona;
import persons.domain.services.PersonaServices;
import resource.ConfiguracionBaseDeDatos;

public class PersonaRepository implements PersonaServices{

    @Override
    public void crearPersona(Persona persona) {
        
        String sql = "INSERT INTO persons(name, lastname, idcity, address, age, email, idgender) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConfiguracionBaseDeDatos.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){

                statement.setString(1, persona.getNombre());
                statement.setString(2, persona.getApellido());
                statement.setLong(3, persona.getCiudad().getId());
                statement.setString(4, persona.getDireccion());
                statement.setInt(5, persona.getEdad());
                statement.setString(6, persona.getCorreoElectronico());
                statement.setLong(7, persona.getGenero().getId());

                int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        persona.setId(generatedKeys.getLong(1));  // Establecer el ID generado
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Persona encontrarPorId(Long id) {
        
        String sql = "SELECT * FROM persons WHERE ud = ?";
        Persona person = null;
        try (Connection connection = ConfiguracionBaseDeDatos.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()) {
                    person = new Persona();
                    person.setId(resultSet.getLong("id"));
                    person.setNombre(resultSet.getString("nombre"));
                    person.setApellido(resultSet.getString("apellido"));
                    Ciudad ciudad = new CiudadRepository().encontrarPorId(resultSet.getLong("ciudad_Id"));
                    person.setCiudad(ciudad);
                    person.setDireccion(resultSet.getString("direccion"));
                    person.setEdad(resultSet.getInt("edad"));
                    person.setCorreoElectronico(resultSet.getString("email:"));
                    Genero genero = new GeneroRepository().encontrarPorId(resultSet.getLong("genero_id"));
                    person.setGenero(genero);
                }
            }
            } catch (SQLException e) {
            e.printStackTrace();
            }
            return person;
    }

    @Override
    public void actualizarPersona(Persona persona) {
        
        String sql = "UPDATE persons SET name = ?, lastname = ?, idcity = ?, age = ?, email = ?, idgender= ? WHERE id = ?";

        try (Connection connection = ConfiguracionBaseDeDatos.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, persona.getNombre());
                statement.setString(2, persona.getApellido());
                statement.setLong(3, persona.getCiudad().getId());
                statement.setString(4, persona.getDireccion());
                statement.setInt(5, persona.getEdad());
                statement.setString(6, persona.getCorreoElectronico());
                statement.setLong(7, persona.getGenero().getId());  

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarPersona(Long id) {

        String sql = "DELETE FROM persons WHERE id = ?";

        try (Connection connection = ConfiguracionBaseDeDatos.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setLong(1, id);
        statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Persona> listaPersonas(){
        String sql = "SELECT * FROM persons";
        List<Persona> personas = new ArrayList<>();

        try (Connection connection = ConfiguracionBaseDeDatos.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Persona person = new Persona();
                person.setId(resultSet.getLong("id"));
                person.setNombre(resultSet.getString("nombre"));
                person.setApellido(resultSet.getString("apellido"));
                Ciudad ciudad = new CiudadRepository().encontrarPorId(resultSet.getLong("ciudad_Id"));
                person.setCiudad(ciudad);
                person.setDireccion(resultSet.getString("direccion"));
                person.setEdad(resultSet.getInt("edad"));
                person.setCorreoElectronico(resultSet.getString("email:"));
                Genero genero = new GeneroRepository().encontrarPorId(resultSet.getLong("genero_id"));
                person.setGenero(genero);

                personas.add(person);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personas;

    }
    

    

}
