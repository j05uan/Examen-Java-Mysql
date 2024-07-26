package habilidad.application;

import habilidad.domain.entity.Habilidad;
import habilidad.domain.services.HabilidadServices;

public class EncontrarPorIdUSeCase {

    private final HabilidadServices habilidadServices;

    public EncontrarPorIdUSeCase(HabilidadServices habilidadServices) {
        this.habilidadServices = habilidadServices;
    }

    public void execute(Long id){
        habilidadServices.encontrarHabilidad(id);
    }

}
