package persons.domain.entity;

import ciudad.domain.entity.Ciudad;
import genero.domain.entity.Genero;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private int edad;
    private String correoElectronico;
    private Genero genero;
    private Ciudad ciudad;
    public Persona() {
    }
    public Persona(int id, String nombre, String apellido, String direccion, int edad, String correoElectronico,
            Genero genero, Ciudad ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.genero = genero;
        this.ciudad = ciudad;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public Ciudad getCiudad() {
        return ciudad;
    }
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    

    

}
