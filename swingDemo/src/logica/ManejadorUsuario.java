package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

/**
 * Clase que conserva la coleccion global de los usuarios del sistema.
 * Los usuarios se identifican por su cedula de identidad.
 * Se implementa en base al patron Singleton.
 * 
 */ 
public class ManejadorUsuario {
    private Map<String, Usuario> usuariosCI;           // Coleccion
    private static ManejadorUsuario instancia = null;  // Instancia unica de manejador usando Singleton

    private ManejadorUsuario() {                       // Constructor privado
        usuariosCI = new HashMap<String, Usuario>();
    }

    public static ManejadorUsuario getinstance() {
        if (instancia == null)
            instancia = new ManejadorUsuario();      // Constructor solo se llama de aca
        return instancia;
    }

    public void addUsuario(Usuario usu) {
      //  String ci = usu.getCedulaIdentidad();    // Get de la cedula
      //  usuariosCI.put(ci, usu);                 // agrego al usuario a la coleccion
        
     // PERSISTENCIA
    	System.out.print("Hola persistencia");
     	EntityManagerFactory emf = Persistence.createEntityManagerFactory("swingDemo");
     	EntityManager em = emf.createEntityManager();
     	EntityTransaction tx = em.getTransaction();
     	tx.begin();
     	em.persist(usu);
     	tx.commit();
     	em.close();
     	emf.close();
    }

    public Usuario obtenerUsuario(String ci) {     // Recibo una cedula y devuelvo el objeto Usuario
       
    	// PERSISTENCIA
 		EntityManagerFactory emf = Persistence.createEntityManagerFactory("swingDemo");
 		EntityManager em = emf.createEntityManager();
 		EntityTransaction tx = em.getTransaction();
 		tx.begin();
 		Usuario usuarioCI=em.find(Usuario.class,ci);
 		//System.out.print(usuarioCI.getNombre());
 		tx.commit();
 		em.close();
 		emf.close();
    	return (usuarioCI);   		
    }

    public Usuario[] getUsuarios() {      // Devuelve la coleccion completa de los usuarios en array
      
    	// PERSISTENCIA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("swingDemo");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT u FROM Usuario u");
		//@SuppressWarnings("unchecked")
		
		Collection<Usuario> result = query.getResultList();
		
		Object[] o = result.toArray();                    // Devuelve los objetos a una array
		Usuario[] usuarios = new Usuario[o.length];     // Creo  un array de usuarios
		for (int i = 0; i < o.length; i++) {
            usuarios[i] = (Usuario) o[i];              // Cargo con la salida de toArray
        }
		em.close();
		emf.close();
		return usuarios;
    }

}
