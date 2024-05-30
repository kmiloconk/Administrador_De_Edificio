package System.Models;

public class PersonaModel {
    private String nombre;
    private String apellido;
    private Integer telefono;
    private String email;
    private String descripcion;

    public PersonaModel(String nombre, String apellido,Integer telefono, String email,String descripcion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
