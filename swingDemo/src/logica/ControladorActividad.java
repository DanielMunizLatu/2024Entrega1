package logica;

import excepciones.ActividadRepetidaException;


public class ControladorActividad implements IControladorActividad {
	
	public ControladorActividad() {
		
	}
		 
	public void registrarActividad(String nickE, String nombre, String desc) throws ActividadRepetidaException 
	{
	      ManejadorActividad ma = ManejadorActividad.getinstance();
	      Actividad a = ma.obtenerActividad(nombre);  // Lo voy a buscar a la coleccion
		        if (a != null)  // Si lo encontre es porque ya existe
		            throw new ActividadRepetidaException("La actividad " + nombre + " ya esta registrada");

		        a = new Actividad(nickE, nombre, desc);  // Creo el objeto con el contructor de la clase Usuario
		        ma.addActividad(a);
		    
	 }
	        

}
