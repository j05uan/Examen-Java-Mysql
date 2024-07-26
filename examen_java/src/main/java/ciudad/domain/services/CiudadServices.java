package ciudad.domain.services;

import java.util.List;

import ciudad.domain.entity.Ciudad;

public interface CiudadServices {
    List<Ciudad> obtenerTodasLasCiudades();
    Ciudad encontrarPorId(Long id);
}
