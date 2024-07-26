package ciudad.domain.entity;

import region.domain.entity.Region;

public class Ciudad {
    private int id;
    private String nombre;
    private Region region;
    public Ciudad() {
    }
    public Ciudad(int id, String nombre, Region region) {
        this.id = id;
        this.nombre = nombre;
        this.region = region;
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
    public Region getRegion() {
        return region;
    }
    public void setRegion(Region region) {
        this.region = region;
    }

    
}
