package persons.application;

import persons.domain.services.PersonaServices;

public class EliminarPersonaUSeCase {

    private final PersonaServices personaServices;

    public EliminarPersonaUSeCase(PersonaServices personaServices) {
        this.personaServices = personaServices;
    }

    public void execute(Long ig){
        personaServices.eliminarPersona(ig);
    }

}
