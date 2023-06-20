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

public class HotelDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public HotelDetachedCriteria() {
		super(sicavibe.Hotel.class, sicavibe.HotelCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		imgId = new IntegerExpression("img.ID", this.getDetachedCriteria());
		img = new AssociationExpression("img", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
		endereco = new StringExpression("endereco", this.getDetachedCriteria());
		listaReservas = new CollectionExpression("ORM_ListaReservas", this.getDetachedCriteria());
		listaQuartos = new CollectionExpression("ORM_ListaQuartos", this.getDetachedCriteria());
		listaFuncionarios = new CollectionExpression("ORM_ListaFuncionarios", this.getDetachedCriteria());
		listaServicosExtra = new CollectionExpression("ORM_ListaServicosExtra", this.getDetachedCriteria());
	}
	
	public HotelDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, sicavibe.HotelCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		imgId = new IntegerExpression("img.ID", this.getDetachedCriteria());
		img = new AssociationExpression("img", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
		endereco = new StringExpression("endereco", this.getDetachedCriteria());
		listaReservas = new CollectionExpression("ORM_ListaReservas", this.getDetachedCriteria());
		listaQuartos = new CollectionExpression("ORM_ListaQuartos", this.getDetachedCriteria());
		listaFuncionarios = new CollectionExpression("ORM_ListaFuncionarios", this.getDetachedCriteria());
		listaServicosExtra = new CollectionExpression("ORM_ListaServicosExtra", this.getDetachedCriteria());
	}
	
	public ImagemDetachedCriteria createImgCriteria() {
		return new ImagemDetachedCriteria(createCriteria("img"));
	}
	
	public sicavibe.ReservaDetachedCriteria createListaReservasCriteria() {
		return new sicavibe.ReservaDetachedCriteria(createCriteria("ORM_ListaReservas"));
	}
	
	public sicavibe.QuartoDetachedCriteria createListaQuartosCriteria() {
		return new sicavibe.QuartoDetachedCriteria(createCriteria("ORM_ListaQuartos"));
	}
	
	public sicavibe.FuncionarioDetachedCriteria createListaFuncionariosCriteria() {
		return new sicavibe.FuncionarioDetachedCriteria(createCriteria("ORM_ListaFuncionarios"));
	}
	
	public sicavibe.ServicoExtraDetachedCriteria createListaServicosExtraCriteria() {
		return new sicavibe.ServicoExtraDetachedCriteria(createCriteria("ORM_ListaServicosExtra"));
	}
	
	public Hotel uniqueHotel(PersistentSession session) {
		return (Hotel) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Hotel[] listHotel(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Hotel[]) list.toArray(new Hotel[list.size()]);
	}
}

