package persons.application;

import persons.domain.services.PersonaServices;

public class ActualizarPersonaUSeCase {

    private final PersonaServices personaServices;

    public ActualizarPersonaUSeCase(PersonaServices personaServices) {
        this.personaServices = personaServices;
    }

    public void execute(){
        personaServices.actualizarPersona(null);
    }

}
