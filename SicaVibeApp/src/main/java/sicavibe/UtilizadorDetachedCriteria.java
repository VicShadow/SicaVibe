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

public class UtilizadorDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	public final StringExpression password;
	public final StringExpression salt;
	public final StringExpression nome;
	public final DateExpression dataNascimento;
	public final StringExpression nTelemovel;
	public final StringExpression morada;
	public final StringExpression cc;
	public final StringExpression nif;
	
	public UtilizadorDetachedCriteria() {
		super(sicavibe.Utilizador.class, sicavibe.UtilizadorCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		salt = new StringExpression("salt", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		dataNascimento = new DateExpression("dataNascimento", this.getDetachedCriteria());
		nTelemovel = new StringExpression("nTelemovel", this.getDetachedCriteria());
		morada = new StringExpression("morada", this.getDetachedCriteria());
		cc = new StringExpression("cc", this.getDetachedCriteria());
		nif = new StringExpression("nif", this.getDetachedCriteria());
	}
	
	public UtilizadorDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sicavibe.UtilizadorCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		salt = new StringExpression("salt", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		dataNascimento = new DateExpression("dataNascimento", this.getDetachedCriteria());
		nTelemovel = new StringExpression("nTelemovel", this.getDetachedCriteria());
		morada = new StringExpression("morada", this.getDetachedCriteria());
		cc = new StringExpression("cc", this.getDetachedCriteria());
		nif = new StringExpression("nif", this.getDetachedCriteria());
	}
	
	public Utilizador uniqueUtilizador(PersistentSession session) {
		return (Utilizador) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Utilizador[] listUtilizador(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Utilizador[]) list.toArray(new Utilizador[list.size()]);
	}
}

