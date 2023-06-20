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

public class ImagemCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final BlobExpression data;
	
	public ImagemCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nome = new StringExpression("nome", this);
		data = new BlobExpression("data", this);
	}
	
	public ImagemCriteria(PersistentSession session) {
		this(session.createCriteria(Imagem.class));
	}
	
	public ImagemCriteria() throws PersistentException {
		this(sicavibe.SicaVibeMainVPPersistentManager.instance().getSession());
	}
	
	public Imagem uniqueImagem() {
		return (Imagem) super.uniqueResult();
	}
	
	public Imagem[] listImagem() {
		java.util.List list = super.list();
		return (Imagem[]) list.toArray(new Imagem[list.size()]);
	}
}

