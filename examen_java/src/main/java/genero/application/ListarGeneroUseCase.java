package genero.application;

import java.util.List;

import genero.domain.entity.Genero;
import genero.domain.services.GeneroServices;

public class ListarGeneroUseCase {

    private final GeneroServices generoServices;

    public ListarGeneroUseCase(GeneroServices generoServices) {
        this.generoServices = generoServices;
    }

    public List<Genero> execute(){
        return generoServices.obtenerTodosLGeneros();
    }
    
}
