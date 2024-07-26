package genero.application;

import genero.domain.services.GeneroServices;

public class EncontrarGeneroUseCase {

    private final GeneroServices generoServices;

    public EncontrarGeneroUseCase(GeneroServices generoServices) {
        this.generoServices = generoServices;
    }

    public void execute(Long id){
        generoServices.encontrarPorId(id);
    }

}
