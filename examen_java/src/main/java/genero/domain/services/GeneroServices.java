package genero.domain.services;

import java.util.List;

import genero.domain.entity.Genero;

public interface GeneroServices {

    Genero encontrarPorId (Long id);
    List<Genero> obtenerTodosLGeneros();

    

}
