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

public class TipoDeQuartoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression imgId;
	public final AssociationExpression img;
	public final StringExpression nome;
	public final IntegerExpression capacidade;
	public final FloatExpression preco;
	public final StringExpression descricao;
	
	public TipoDeQuartoDetachedCriteria() {
		super(sicavibe.TipoDeQuarto.class, sicavibe.TipoDeQuartoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		imgId = new IntegerExpression("img.ID", this.getDetachedCriteria());
		img = new AssociationExpression("img", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		capacidade = new IntegerExpression("capacidade", this.getDetachedCriteria());
		preco = new FloatExpression("preco", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
	}
	
	public TipoDeQuartoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sicavibe.TipoDeQuartoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		imgId = new IntegerExpression("img.ID", this.getDetachedCriteria());
		img = new AssociationExpression("img", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		capacidade = new IntegerExpression("capacidade", this.getDetachedCriteria());
		preco = new FloatExpression("preco", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
	}
	
	public ImagemDetachedCriteria createImgCriteria() {
		return new ImagemDetachedCriteria(createCriteria("img"));
	}
	
	public TipoDeQuarto uniqueTipoDeQuarto(PersistentSession session) {
		return (TipoDeQuarto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public TipoDeQuarto[] listTipoDeQuarto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (TipoDeQuarto[]) list.toArray(new TipoDeQuarto[list.size()]);
	}
}

