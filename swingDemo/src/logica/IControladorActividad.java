package logica;

import excepciones.ActividadRepetidaException;

public interface IControladorActividad {
	
	public abstract void registrarActividad(String nickE, String nombre, String desc) throws ActividadRepetidaException;

}
