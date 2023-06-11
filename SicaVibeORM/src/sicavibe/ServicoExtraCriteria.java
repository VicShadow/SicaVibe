/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: vicshadow(Universidade do Minho)
 * License Type: Academic
 */
package sicavibe;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ServicoExtraCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final FloatExpression preco;
	
	public ServicoExtraCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nome = new StringExpression("nome", this);
		preco = new FloatExpression("preco", this);
	}
	
	public ServicoExtraCriteria(PersistentSession session) {
		this(session.createCriteria(ServicoExtra.class));
	}
	
	public ServicoExtraCriteria() throws PersistentException {
		this(sicavibe.SicaVibeMainVPPersistentManager.instance().getSession());
	}
	
	public ServicoExtra uniqueServicoExtra() {
		return (ServicoExtra) super.uniqueResult();
	}
	
	public ServicoExtra[] listServicoExtra() {
		java.util.List list = super.list();
		return (ServicoExtra[]) list.toArray(new ServicoExtra[list.size()]);
	}
}

