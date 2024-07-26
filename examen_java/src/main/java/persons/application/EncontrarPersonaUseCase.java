package persons.application;

import persons.domain.services.PersonaServices;

public class EncontrarPersonaUseCase {

    private final PersonaServices personaServices;

    public EncontrarPersonaUseCase(PersonaServices personaServices) {
        this.personaServices = personaServices;
    }

    public void execute (Long id){
        personaServices.encontrarPorId(id);
    }
}
