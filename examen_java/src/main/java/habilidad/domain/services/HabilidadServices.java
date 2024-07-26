package habilidad.domain.services;

import java.util.List;

import habilidad.domain.entity.Habilidad;

public interface HabilidadServices {

    void crearHabilidad (Habilidad habilidad);
    Habilidad encontrarHabilidad(Long id);
    List<Habilidad> listaHabilidades();
    

}
