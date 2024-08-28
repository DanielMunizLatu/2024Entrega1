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
public class Actividad {
	private String nicknameEntrenador;
	  @Id
	  private String nombre;
	  private String descripcion;
	
	  @OneToMany(cascade = CascadeType.PERSIST)
	  private List<Clase> clases = new ArrayList<>();
	
	  public Actividad() {}
	  
	public Actividad(String nicknameEntrenador, String nombre, String descripcion) {
		super();
		this.nicknameEntrenador = nicknameEntrenador;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public String getNicknameEntrenador() {
		return nicknameEntrenador;
	}
	public void setNicknameEntrenador(String nicknameProveedor) {
		this.nicknameEntrenador = nicknameProveedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<Clase> getClases() {
		return clases;
	}
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	  
}
