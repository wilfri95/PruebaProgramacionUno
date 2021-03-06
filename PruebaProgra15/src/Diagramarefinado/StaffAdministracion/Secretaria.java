package Diagramarefinado.StaffAdministracion;

import org.orm.PersistentException;

import Diagramarefinado.Persona.*;
/**
 * 
 * @author Alfredo
 *
 */
public class Secretaria extends Persona {

	public Secretaria(String nombre, String apellido, String rut) {
		super(nombre, apellido, rut);
		// TODO Auto-generated constructor stub
	}


	/**
	 * Este m�todo permite agregar una nueva secretaria a la base de datos
	 * @param nuevaPer
	 * @return
	 */
	public static String agregarSecretaria(Persona nuevaPer) {
		// TODO Initialize the properties of the persistent object here, the
		// following properties must be initialized before saving : matricula,
		// estudiante_curso
		try {
			/*
			 * se busca en la base de datos que la persona que se quiere agregar
			 * no haya sido ingresada anteriormente, esto se
			 * hace a trav�s de rut de la persona
			 */
			String rutSecretaria = "rut='" + nuevaPer.getRut() + "'";
			orm.Persona buscarPorRut = orm.PersonaDAO.loadPersonaByQuery(rutSecretaria, null);
			/**
			 * si no se encontr� el rut de la persona, es decir, la persona no
			 * exist�a, se crea una persona y se setean los atributos de la
			 * clase 'Persona'. Finlamente se guardan los datos.
			 */
			if (buscarPorRut == null) {
				orm.Persona lormPersona = orm.PersonaDAO.createPersona();
				lormPersona.setNombre(nuevaPer.getNombre());
				lormPersona.setApellido(nuevaPer.getApellido());
				lormPersona.setRut(nuevaPer.getRut());
				orm.PersonaDAO.save(lormPersona);
				/*
				 * una vez que se guadaron los datos en lormPersona, se
				 * instancia un lormSecretaria y se le pasa lormPersona
				 */
				orm.Secretaria lormSecretaria = orm.SecretariaDAO.createSecretaria();
				lormSecretaria.setPersona(lormPersona);
				orm.SecretariaDAO.save(lormSecretaria);
				return "se ingres� la secretaria con exito";
			} else {
				return "no se pudo ingresar a la secretaria";
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}