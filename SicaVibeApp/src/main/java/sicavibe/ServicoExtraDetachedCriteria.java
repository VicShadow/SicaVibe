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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ServicoExtraDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final FloatExpression preco;
	
	public ServicoExtraDetachedCriteria() {
		super(sicavibe.ServicoExtra.class, sicavibe.ServicoExtraCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		preco = new FloatExpression("preco", this.getDetachedCriteria());
	}
	
	public ServicoExtraDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sicavibe.ServicoExtraCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		preco = new FloatExpression("preco", this.getDetachedCriteria());
	}
	
	public ServicoExtra uniqueServicoExtra(PersistentSession session) {
		return (ServicoExtra) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ServicoExtra[] listServicoExtra(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ServicoExtra[]) list.toArray(new ServicoExtra[list.size()]);
	}
}

