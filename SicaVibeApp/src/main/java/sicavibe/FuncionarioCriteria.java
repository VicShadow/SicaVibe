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

public class FuncionarioCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	public final StringExpression password;
	public final StringExpression nome;
	public final DateExpression dataNascimento;
	public final StringExpression numTelemovel;
	public final StringExpression morada;
	public final StringExpression cc;
	public final StringExpression nif;
	public final StringExpression estado;
	
	public FuncionarioCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		email = new StringExpression("email", this);
		password = new StringExpression("password", this);
		nome = new StringExpression("nome", this);
		dataNascimento = new DateExpression("dataNascimento", this);
		numTelemovel = new StringExpression("numTelemovel", this);
		morada = new StringExpression("morada", this);
		cc = new StringExpression("cc", this);
		nif = new StringExpression("nif", this);
		estado = new StringExpression("estado", this);
	}
	
	public FuncionarioCriteria(PersistentSession session) {
		this(session.createCriteria(Funcionario.class));
	}
	
	public FuncionarioCriteria() throws PersistentException {
		this(sicavibe.SicaVibeMainVPPersistentManager.instance().getSession());
	}
	
	public Funcionario uniqueFuncionario() {
		return (Funcionario) super.uniqueResult();
	}
	
	public Funcionario[] listFuncionario() {
		java.util.List list = super.list();
		return (Funcionario[]) list.toArray(new Funcionario[list.size()]);
	}
}

