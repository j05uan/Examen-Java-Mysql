package habilidad.application;

import habilidad.domain.entity.Habilidad;
import habilidad.domain.services.HabilidadServices;

public class CrearHabilidadUseCase {

    private final HabilidadServices habilidadServices;

    public CrearHabilidadUseCase(HabilidadServices habilidadServices) {
        this.habilidadServices = habilidadServices;
    }

    public void execute (Habilidad habilidad){
        habilidadServices.crearHabilidad(habilidad);
    }

}
