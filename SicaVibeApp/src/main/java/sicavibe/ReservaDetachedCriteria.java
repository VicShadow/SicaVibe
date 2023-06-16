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

public class ReservaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression hospedeId;
	public final AssociationExpression hospede;
	public final DateExpression dataEntrada;
	public final DateExpression dataSaida;
	public final FloatExpression preco;
	public final StringExpression estado;
	public final CollectionExpression quartos;
	public final CollectionExpression servicosExtras;
	
	public ReservaDetachedCriteria() {
		super(sicavibe.Reserva.class, sicavibe.ReservaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		hospedeId = new IntegerExpression("hospede.ID", this.getDetachedCriteria());
		hospede = new AssociationExpression("hospede", this.getDetachedCriteria());
		dataEntrada = new DateExpression("dataEntrada", this.getDetachedCriteria());
		dataSaida = new DateExpression("dataSaida", this.getDetachedCriteria());
		preco = new FloatExpression("preco", this.getDetachedCriteria());
		estado = new StringExpression("estado", this.getDetachedCriteria());
		quartos = new CollectionExpression("ORM_Quartos", this.getDetachedCriteria());
		servicosExtras = new CollectionExpression("ORM_ServicosExtras", this.getDetachedCriteria());
	}
	
	public ReservaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sicavibe.ReservaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		hospedeId = new IntegerExpression("hospede.ID", this.getDetachedCriteria());
		hospede = new AssociationExpression("hospede", this.getDetachedCriteria());
		dataEntrada = new DateExpression("dataEntrada", this.getDetachedCriteria());
		dataSaida = new DateExpression("dataSaida", this.getDetachedCriteria());
		preco = new FloatExpression("preco", this.getDetachedCriteria());
		estado = new StringExpression("estado", this.getDetachedCriteria());
		quartos = new CollectionExpression("ORM_Quartos", this.getDetachedCriteria());
		servicosExtras = new CollectionExpression("ORM_ServicosExtras", this.getDetachedCriteria());
	}
	
	public HospedeDetachedCriteria createHospedeCriteria() {
		return new HospedeDetachedCriteria(createCriteria("hospede"));
	}
	
	public sicavibe.QuartoDetachedCriteria createQuartosCriteria() {
		return new sicavibe.QuartoDetachedCriteria(createCriteria("ORM_Quartos"));
	}
	
	public sicavibe.ServicoExtraDetachedCriteria createServicosExtrasCriteria() {
		return new sicavibe.ServicoExtraDetachedCriteria(createCriteria("ORM_ServicosExtras"));
	}
	
	public Reserva uniqueReserva(PersistentSession session) {
		return (Reserva) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Reserva[] listReserva(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Reserva[]) list.toArray(new Reserva[list.size()]);
	}
}

