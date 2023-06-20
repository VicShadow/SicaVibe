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

public class TipoDeQuartoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression imgId;
	public final AssociationExpression img;
	public final StringExpression nome;
	public final IntegerExpression capacidade;
	public final FloatExpression preco;
	public final StringExpression descricao;
	
	public TipoDeQuartoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		imgId = new IntegerExpression("img.ID", this);
		img = new AssociationExpression("img", this);
		nome = new StringExpression("nome", this);
		capacidade = new IntegerExpression("capacidade", this);
		preco = new FloatExpression("preco", this);
		descricao = new StringExpression("descricao", this);
	}
	
	public TipoDeQuartoCriteria(PersistentSession session) {
		this(session.createCriteria(TipoDeQuarto.class));
	}
	
	public TipoDeQuartoCriteria() throws PersistentException {
		this(sicavibe.SicaVibeMainVPPersistentManager.instance().getSession());
	}
	
	public ImagemCriteria createImgCriteria() {
		return new ImagemCriteria(createCriteria("img"));
	}
	
	public TipoDeQuarto uniqueTipoDeQuarto() {
		return (TipoDeQuarto) super.uniqueResult();
	}
	
	public TipoDeQuarto[] listTipoDeQuarto() {
		java.util.List list = super.list();
		return (TipoDeQuarto[]) list.toArray(new TipoDeQuarto[list.size()]);
	}
}

