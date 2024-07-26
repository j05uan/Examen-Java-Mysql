package habilidad.application;

import java.util.List;

import habilidad.domain.entity.Habilidad;
import habilidad.domain.services.HabilidadServices;

public class ListarHabilidadesUseCase {

    private final HabilidadServices habilidadServices;

    public ListarHabilidadesUseCase(HabilidadServices habilidadServices) {
        this.habilidadServices = habilidadServices;
    }

    public List<Habilidad> execute(){
        return habilidadServices.listaHabilidades();
    }

}
