package persons.infraestructure.in;

import java.util.List;
import java.util.Scanner;

import ciudad.domain.entity.Ciudad;
import ciudad.infraestructure.out.CiudadRepository;
import genero.domain.entity.Genero;
import genero.infraestructure.out.GeneroRepository;
import persons.application.ActualizarPersonaUSeCase;
import persons.application.CreatePersonUseCase;
import persons.application.EliminarPersonaUSeCase;
import persons.domain.entity.Persona;
import persons.domain.services.PersonaServices;
import persons.infraestructure.out.PersonaRepository;
import utils.*;

public class PersonaControlador {
    private final Scanner scanner = new Scanner(System.in);
    private final PersonaServices personaServices;
    private final PersonaRepository personaRepository;
    private final EliminarPersonaUSeCase eliminarPersona;
    private final ActualizarPersonaUSeCase actualizarPersonaUSeCase;
    private final CreatePersonUseCase createPersonUseCase;
    private final GeneroRepository generoRepository;
    private final CiudadRepository ciudadRepository;

    
    public PersonaControlador(PersonaServices personaServices, EliminarPersonaUSeCase eliminarPersona,
            ActualizarPersonaUSeCase actualizarPersonaUSeCase, CreatePersonUseCase createPersonUseCase,
            GeneroRepository generoRepository, CiudadRepository ciudadRepository) {
        this.personaServices = personaServices;
        this.personaRepository = new PersonaRepository();
        this.eliminarPersona = eliminarPersona;
        this.actualizarPersonaUSeCase = actualizarPersonaUSeCase;
        this.createPersonUseCase = createPersonUseCase;
        this.generoRepository = generoRepository;
        this.ciudadRepository = ciudadRepository;
    }

    public void start() {
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (opcion) {
                case 1:
                    cleanScreen();
                    
                    break;
                case 2:
                    cleanScreen();
                    
                    break;
                case 3:
                    cleanScreen();
                    
                    break;
                case 4:
                    cleanScreen();
                    
                    break;
                case 5:
                    cleanScreen();
                    
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }

        } while (opcion != 6);
    }

    private void mostrarMenu() {
        System.out.println("---- Menu de Opciones de Persona ----");
        System.out.println("1. Registrar Persona");
        System.out.println("2. Asignar una Habilidad");
        System.out.println("3. Consultar Persona por Habilidad");
        System.out.println("4. Actualizar Informacion de Persona");
        System.out.println("5. Eliminar Persona");
        System.out.println("6. Salir");
        System.out.println("Seleccione una opción:");
    }

    public void RegistrarPersona(){
        Persona persona = new Persona();
        System.out.println( "Ingrese el nombre de la persona");
        String nombre = scanner.nextLine();
        persona.setNombre(nombre);
        System.out.println("Ingrese el apellido ");
        String apellido = scanner.nextLine();
        persona.setApellido(apellido);
        System.out.println("Ingrese la direccion: ");
        String direccion = scanner.nextLine();
        persona.setDireccion(direccion);
        System.out.println("Ingrese la edad: ");
        int edad = scanner.nextInt();
        persona.setEdad(edad);;
        System.out.println("Ingrese el correo electronico");
        String email = scanner.nextLine();
        persona.setCorreoElectronico(email);
        List<Genero> generos = new GeneroRepository().obtenerTodosLGeneros();
        System.out.println("Seleccione el genero");
        mostrarGenero(generos);
        int opcionGenero = Consola.optionValidation("Ingrese el numero del genero", 1, generos.size());
        Genero generoSeleccionado = generos.get(opcionGenero -1);
        List<Ciudad> ciudades = new CiudadRepository().obtenerTodasLasCiudades();
        System.out.println("Selecione la ciudad");
        mostrarCiudad(ciudades);
        int opcionCiudad =  Consola.optionValidation("Ingrese el numero de la ciudad");
        Ciudad ciudadSeleccionada = ciudades.get(opcionCiudad -1 );

        persona.setGenero(generoSeleccionado);
        persona.setCiudad(ciudadSeleccionada);

        personaRepository.crearPersona(persona);

        System.out.println("Persona Creada con exito");

    }

    




    private void mostrarGenero(List<Genero> generos) {
        for (int i = 0; i < generos.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, generos.get(i).getName());
        }
    }
    private void mostrarCiudad(List<Ciudad> ciudades) {
        for (int i = 0; i < ciudades.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, ciudades.get(i).getNombre());
        }
    }

}
