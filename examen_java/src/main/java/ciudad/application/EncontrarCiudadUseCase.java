package ciudad.application;

import ciudad.domain.services.CiudadServices;

public class EncontrarCiudadUseCase {

    private final CiudadServices ciudadServices;

    public EncontrarCiudadUseCase(CiudadServices ciudadServices) {
        this.ciudadServices = ciudadServices;
    }

    public void execute(Long id){
        ciudadServices.encontrarPorId(id);
    }

}
