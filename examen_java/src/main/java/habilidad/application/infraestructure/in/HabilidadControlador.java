package habilidad.application.infraestructure.in;

import java.util.Scanner;

import habilidad.application.infraestructure.out.HabilidadRepository;
import habilidad.domain.entity.Habilidad;

public class HabilidadControlador {

    private final Scanner scanner = new Scanner(System.in);
    private final HabilidadRepository habilidadRepository;
    public HabilidadControlador(HabilidadRepository habilidadRepository) {
        this.habilidadRepository = habilidadRepository;
    }

    public void start(){
        int opcion;

        do{
            mostrarMenu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }

            
        } while (opcion != 3);
    }    

    private void mostrarMenu() {
        System.out.println("---- Menu de Opciones de Habilidades ----");
        System.out.println("1. Crear Habilidad");
        System.out.println("2. Listar Todos las Habilidades");
        System.out.println("3. Salir");
        System.out.println("Seleccione una opción:");
    }

    public void crearHabilidad(){
        System.out.println("Ingrese el nombre de la nueva habilidad");
        String habilidad = scanner.nextLine();

        Habilidad nuevaHabilidad = new Habilidad();
        nuevaHabilidad.setNombre(habilidad);

        habilidadRepository.crearHabilidad(nuevaHabilidad);

        System.out.println("Habilidad Creada con exito." + nuevaHabilidad.getId());

    }
}
