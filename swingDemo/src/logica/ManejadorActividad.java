package logica;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ManejadorActividad {
	
	 private Map<String, Actividad> actividadesNombre;     // Coleccion
	 private static ManejadorActividad instancia = null;  // Instancia unica de manejador usando Singleton

	 private ManejadorActividad() {                       // Constructor privado
	    	actividadesNombre = new HashMap<String, Actividad>();
	 }
	 public static ManejadorActividad getinstance() {
	        if (instancia == null)
	            instancia = new ManejadorActividad();      // Constructor solo se llama de aca
	        return instancia;
	 }
	 public void addActividad(Actividad actividad) {
	      
	        // PERSISTENCIA
	     	EntityManagerFactory emf = Persistence.createEntityManagerFactory("swingDemo");
	     	EntityManager em = emf.createEntityManager();
	     	EntityTransaction tx = em.getTransaction();
	     	tx.begin();
	     	em.persist(actividad);
	     	tx.commit();
	     	em.close();
	     	emf.close();
	    }
	 
	 public Actividad obtenerActividad(String nombre) {    
		 
	    	// PERSISTENCIA
	 		EntityManagerFactory emf = Persistence.createEntityManagerFactory("swingDemo");
	 		EntityManager em = emf.createEntityManager();
	 		EntityTransaction tx = em.getTransaction();
	 		tx.begin();
	 		Actividad actividadNombre=em.find(Actividad.class,nombre);
	 		
	 		tx.commit();
	 		em.close();
	 		emf.close();
	    	return (actividadNombre);   			
	    }
}
