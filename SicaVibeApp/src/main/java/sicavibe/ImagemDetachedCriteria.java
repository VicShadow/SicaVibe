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

public class ImagemDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final BlobExpression data;
	
	public ImagemDetachedCriteria() {
		super(sicavibe.Imagem.class, sicavibe.ImagemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		data = new BlobExpression("data", this.getDetachedCriteria());
	}
	
	public ImagemDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sicavibe.ImagemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		data = new BlobExpression("data", this.getDetachedCriteria());
	}
	
	public Imagem uniqueImagem(PersistentSession session) {
		return (Imagem) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Imagem[] listImagem(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Imagem[]) list.toArray(new Imagem[list.size()]);
	}
}

