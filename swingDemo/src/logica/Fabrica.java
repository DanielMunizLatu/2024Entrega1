package logica;

/** Fabrica para la construccion de un controlador de usuarios (uno distinto para cada invocacion).
  Se implementa en base al patron Singleton.
 
   El patr�n Singleton es un patr�n de dise�o creacional en el desarrollo de software que garantiza que una 
   clase tenga una �nica instancia y proporciona un punto de acceso global a esa instancia.
   El objetivo principal del patr�n Singleton es restringir la creaci�n de instancias de una clase a una sola
   instancia y proporcionar un mecanismo para acceder a esa �nica instancia desde cualquier parte del c�digo. 
   Esto puede ser �til en situaciones donde solo se necesita una �nica instancia de una clase para gestionar 
   recursos compartidos, configuraciones globales, controlar el acceso a una base de datos o para garantizar 
   que ciertos componentes del sistema se comporten de manera �nica y consistente.


 */
public class Fabrica {

	/* Con private static, digo no solo que es privado sino que el miembro pertenece a la clase en lugar 
	 de a las instancias individuales de la clase. Esto significa que solo hay una copia del atributo o m�todo 
	 para todas las instancias de la clase, en lugar de una copia por cada instancia creada.*/
   
	private static Fabrica instancia;

    private Fabrica() {  /* Constructor privado para evitar que otras clases puedan instanciarlo */
    };

    /*La primera vez que se llama a getInstance(), la instancia se crea y almacenada en la variable instance. 
     En llamadas posteriores, simplemente se devuelve la instancia ya creada.*/
    
    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();   // Solo de aca se puede llamar al contructor
        }
        return instancia;
    }
    /*Metodo publico para devolver el controlador*/
    public IControladorUsuario getIControladorUsuario() {
        return new ControladorUsuario();
    }

}
