package System.Models;

public class PersonaModel {
    private String nombre;
    private String apellido;
    private Integer telefono;
    private String descripcion;

    public PersonaModel(String nombre, String apellido,Integer telefono, String descripcion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        npellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setTelefono(Integer telefono) {
        telefono = telefono;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setDescripcion(String descripcion) {
        descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
