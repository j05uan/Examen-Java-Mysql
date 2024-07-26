package ciudad.application;

import java.util.List;

import ciudad.domain.entity.Ciudad;
import ciudad.domain.services.CiudadServices;

public class ListarCiudadUseCase {

    private final CiudadServices ciudadServices;

    public ListarCiudadUseCase(CiudadServices ciudadServices) {
        this.ciudadServices = ciudadServices;
    }

    public List<Ciudad> execute (){
       return ciudadServices.obtenerTodasLasCiudades();
    }

}
