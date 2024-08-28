package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Clase {
	@Id
	  private String nombre;
	  private Date fecha;
	 
	  private String nombreActividad;
	 // @OneToMany(cascade = CascadeType.PERSIST)
	 // private List<Inscripcion> inscripciones = new ArrayList<>();

	public Clase() {}  
	
	public Clase(String nombre, Date fecha, String nombreActividad) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.nombreActividad = nombreActividad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombreActividad() {
		return nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}
   
}
