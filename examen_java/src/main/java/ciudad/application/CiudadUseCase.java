package ciudad.application;

import java.util.List;

import ciudad.domain.entity.Ciudad;
import ciudad.domain.services.CiudadServices;

public class CiudadUseCase {

    private final CiudadServices ciudadServices;

    public CiudadUseCase(CiudadServices ciudadServices) {
        this.ciudadServices = ciudadServices;
    }

    public List<Ciudad> obtenerTodasLasCiudade(){
       return ciudadServices.obtenerTodasLasCiudades();
    }

}
