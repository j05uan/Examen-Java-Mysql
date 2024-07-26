package persons.domain.services;

import java.util.List;

import persons.domain.entity.Persona;

public interface PersonaServices {
    void crearPersona (Persona persona);
    Persona encontrarPorId (Long id);
    void actualizarPersona ( Persona persona);
    void eliminarPersona (Long id);
    List<Persona> listaPersonas();

}
