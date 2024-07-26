package persons.application;

import persons.domain.entity.Persona;
import persons.domain.services.PersonaServices;

public class CreatePersonUseCase {

    private final PersonaServices personaServices;

    public CreatePersonUseCase(PersonaServices personaServices) {
        this.personaServices = personaServices;
    }

    public void execute (Persona persona){
        personaServices.crearPersona(persona);
    }

}
