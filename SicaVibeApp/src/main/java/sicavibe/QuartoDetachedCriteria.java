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

public class QuartoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression tipoDeQuartoId;
	public final AssociationExpression tipoDeQuarto;
	public final IntegerExpression nPorta;
	public final StringExpression estado;
	
	public QuartoDetachedCriteria() {
		super(sicavibe.Quarto.class, sicavibe.QuartoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		tipoDeQuartoId = new IntegerExpression("tipoDeQuarto.ID", this.getDetachedCriteria());
		tipoDeQuarto = new AssociationExpression("tipoDeQuarto", this.getDetachedCriteria());
		nPorta = new IntegerExpression("nPorta", this.getDetachedCriteria());
		estado = new StringExpression("estado", this.getDetachedCriteria());
	}
	
	public QuartoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sicavibe.QuartoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		tipoDeQuartoId = new IntegerExpression("tipoDeQuarto.ID", this.getDetachedCriteria());
		tipoDeQuarto = new AssociationExpression("tipoDeQuarto", this.getDetachedCriteria());
		nPorta = new IntegerExpression("nPorta", this.getDetachedCriteria());
		estado = new StringExpression("estado", this.getDetachedCriteria());
	}
	
	public TipoDeQuartoDetachedCriteria createTipoDeQuartoCriteria() {
		return new TipoDeQuartoDetachedCriteria(createCriteria("tipoDeQuarto"));
	}
	
	public Quarto uniqueQuarto(PersistentSession session) {
		return (Quarto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Quarto[] listQuarto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Quarto[]) list.toArray(new Quarto[list.size()]);
	}
}

