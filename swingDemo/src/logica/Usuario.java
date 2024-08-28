package logica;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;

/**Representa a un usuario en el sistema con nombre, apellido y cedula de identidad. */
@Entity
//@Inheritance
//@DiscriminatorColumn(name = "TYPE")
public class Usuario {

	
    private String nombre;
    private String apellido;
    @Id
    private String cedulaIdentidad;
    
    public Usuario() {
      
    }
    
    public Usuario(String n, String ap, String ci) {
        this.nombre = n;
        this.apellido = ap;
        this.cedulaIdentidad = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedulaIdentidad() {
        return cedulaIdentidad;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public void setApellido(String ap) {
        apellido = ap;
    }

    public void setCedulaIdentidad(String ci) {
        cedulaIdentidad = ci;
    }

}
