package habilidad.domain.entity;

public class Habilidad {
    private Long id;
    private String nombre;

    public Habilidad(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Habilidad() {
        
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
