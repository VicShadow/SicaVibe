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

public class QuartoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression tipoDeQuartoId;
	public final AssociationExpression tipoDeQuarto;
	public final IntegerExpression nPorta;
	public final StringExpression estado;
	
	public QuartoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		tipoDeQuartoId = new IntegerExpression("tipoDeQuarto.ID", this);
		tipoDeQuarto = new AssociationExpression("tipoDeQuarto", this);
		nPorta = new IntegerExpression("nPorta", this);
		estado = new StringExpression("estado", this);
	}
	
	public QuartoCriteria(PersistentSession session) {
		this(session.createCriteria(Quarto.class));
	}
	
	public QuartoCriteria() throws PersistentException {
		this(sicavibe.SicaVibeMainVPPersistentManager.instance().getSession());
	}
	
	public TipoDeQuartoCriteria createTipoDeQuartoCriteria() {
		return new TipoDeQuartoCriteria(createCriteria("tipoDeQuarto"));
	}
	
	public Quarto uniqueQuarto() {
		return (Quarto) super.uniqueResult();
	}
	
	public Quarto[] listQuarto() {
		java.util.List list = super.list();
		return (Quarto[]) list.toArray(new Quarto[list.size()]);
	}
}

