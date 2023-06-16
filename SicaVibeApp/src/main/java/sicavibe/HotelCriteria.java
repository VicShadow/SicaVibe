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

public class HotelCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression imgId;
	public final AssociationExpression img;
	public final StringExpression nome;
	public final StringExpression descricao;
	public final StringExpression endereco;
	public final CollectionExpression listaReservas;
	public final CollectionExpression listaQuartos;
	public final CollectionExpression listaFuncionarios;
	public final CollectionExpression listaServicosExtra;
	
	public HotelCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		imgId = new IntegerExpression("img.ID", this);
		img = new AssociationExpression("img", this);
		nome = new StringExpression("nome", this);
		descricao = new StringExpression("descricao", this);
		endereco = new StringExpression("endereco", this);
		listaReservas = new CollectionExpression("ORM_ListaReservas", this);
		listaQuartos = new CollectionExpression("ORM_ListaQuartos", this);
		listaFuncionarios = new CollectionExpression("ORM_ListaFuncionarios", this);
		listaServicosExtra = new CollectionExpression("ORM_ListaServicosExtra", this);
	}
	
	public HotelCriteria(PersistentSession session) {
		this(session.createCriteria(Hotel.class));
	}
	
	public HotelCriteria() throws PersistentException {
		this(sicavibe.SicaVibeMainVPPersistentManager.instance().getSession());
	}
	
	public ImagemCriteria createImgCriteria() {
		return new ImagemCriteria(createCriteria("img"));
	}
	
	public sicavibe.ReservaCriteria createListaReservasCriteria() {
		return new sicavibe.ReservaCriteria(createCriteria("ORM_ListaReservas"));
	}
	
	public sicavibe.QuartoCriteria createListaQuartosCriteria() {
		return new sicavibe.QuartoCriteria(createCriteria("ORM_ListaQuartos"));
	}
	
	public sicavibe.FuncionarioCriteria createListaFuncionariosCriteria() {
		return new sicavibe.FuncionarioCriteria(createCriteria("ORM_ListaFuncionarios"));
	}
	
	public sicavibe.ServicoExtraCriteria createListaServicosExtraCriteria() {
		return new sicavibe.ServicoExtraCriteria(createCriteria("ORM_ListaServicosExtra"));
	}
	
	public Hotel uniqueHotel() {
		return (Hotel) super.uniqueResult();
	}
	
	public Hotel[] listHotel() {
		java.util.List list = super.list();
		return (Hotel[]) list.toArray(new Hotel[list.size()]);
	}
}

