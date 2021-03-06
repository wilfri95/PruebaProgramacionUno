/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package orm;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class JefeadministracionCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression personaId;
	public final AssociationExpression persona;
	public final CollectionExpression sueldo;
	
	public JefeadministracionCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		personaId = new IntegerExpression("persona.id", this);
		persona = new AssociationExpression("persona", this);
		sueldo = new CollectionExpression("ORM_Sueldo", this);
	}
	
	public JefeadministracionCriteria(PersistentSession session) {
		this(session.createCriteria(Jefeadministracion.class));
	}
	
	public JefeadministracionCriteria() throws PersistentException {
		this(orm.DiagramaetpmPersistentManager.instance().getSession());
	}
	
	public PersonaCriteria createPersonaCriteria() {
		return new PersonaCriteria(createCriteria("persona"));
	}
	
	public SueldoCriteria createSueldoCriteria() {
		return new SueldoCriteria(createCriteria("ORM_Sueldo"));
	}
	
	public Jefeadministracion uniqueJefeadministracion() {
		return (Jefeadministracion) super.uniqueResult();
	}
	
	public Jefeadministracion[] listJefeadministracion() {
		java.util.List list = super.list();
		return (Jefeadministracion[]) list.toArray(new Jefeadministracion[list.size()]);
	}
}

