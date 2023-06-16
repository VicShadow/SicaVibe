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

public class ReservaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression hospedeId;
	public final AssociationExpression hospede;
	public final DateExpression dataEntrada;
	public final DateExpression dataSaida;
	public final FloatExpression preco;
	public final StringExpression estado;
	public final CollectionExpression quartos;
	public final CollectionExpression servicosExtras;
	
	public ReservaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		hospedeId = new IntegerExpression("hospede.ID", this);
		hospede = new AssociationExpression("hospede", this);
		dataEntrada = new DateExpression("dataEntrada", this);
		dataSaida = new DateExpression("dataSaida", this);
		preco = new FloatExpression("preco", this);
		estado = new StringExpression("estado", this);
		quartos = new CollectionExpression("ORM_Quartos", this);
		servicosExtras = new CollectionExpression("ORM_ServicosExtras", this);
	}
	
	public ReservaCriteria(PersistentSession session) {
		this(session.createCriteria(Reserva.class));
	}
	
	public ReservaCriteria() throws PersistentException {
		this(sicavibe.SicaVibeMainVPPersistentManager.instance().getSession());
	}
	
	public HospedeCriteria createHospedeCriteria() {
		return new HospedeCriteria(createCriteria("hospede"));
	}
	
	public sicavibe.QuartoCriteria createQuartosCriteria() {
		return new sicavibe.QuartoCriteria(createCriteria("ORM_Quartos"));
	}
	
	public sicavibe.ServicoExtraCriteria createServicosExtrasCriteria() {
		return new sicavibe.ServicoExtraCriteria(createCriteria("ORM_ServicosExtras"));
	}
	
	public Reserva uniqueReserva() {
		return (Reserva) super.uniqueResult();
	}
	
	public Reserva[] listReserva() {
		java.util.List list = super.list();
		return (Reserva[]) list.toArray(new Reserva[list.size()]);
	}
}

