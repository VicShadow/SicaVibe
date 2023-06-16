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

public class FuncionarioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	public final StringExpression password;
	public final StringExpression nome;
	public final DateExpression dataNascimento;
	public final StringExpression nTelemovel;
	public final StringExpression morada;
	public final StringExpression cc;
	public final StringExpression nif;
	public final StringExpression estado;
	
	public FuncionarioDetachedCriteria() {
		super(sicavibe.Funcionario.class, sicavibe.FuncionarioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		dataNascimento = new DateExpression("dataNascimento", this.getDetachedCriteria());
		nTelemovel = new StringExpression("nTelemovel", this.getDetachedCriteria());
		morada = new StringExpression("morada", this.getDetachedCriteria());
		cc = new StringExpression("cc", this.getDetachedCriteria());
		nif = new StringExpression("nif", this.getDetachedCriteria());
		estado = new StringExpression("estado", this.getDetachedCriteria());
	}
	
	public FuncionarioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sicavibe.FuncionarioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		dataNascimento = new DateExpression("dataNascimento", this.getDetachedCriteria());
		nTelemovel = new StringExpression("nTelemovel", this.getDetachedCriteria());
		morada = new StringExpression("morada", this.getDetachedCriteria());
		cc = new StringExpression("cc", this.getDetachedCriteria());
		nif = new StringExpression("nif", this.getDetachedCriteria());
		estado = new StringExpression("estado", this.getDetachedCriteria());
	}
	
	public Funcionario uniqueFuncionario(PersistentSession session) {
		return (Funcionario) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Funcionario[] listFuncionario(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Funcionario[]) list.toArray(new Funcionario[list.size()]);
	}
}

