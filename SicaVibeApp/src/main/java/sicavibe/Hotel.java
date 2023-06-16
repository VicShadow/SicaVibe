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

import java.util.Map;
import java.util.Set;

public class Hotel {
	public Hotel() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == sicavibe.ORMConstants.KEY_HOTEL_LISTARESERVAS) {
			return ORM_listaReservas;
		}
		else if (key == sicavibe.ORMConstants.KEY_HOTEL_LISTAQUARTOS) {
			return ORM_listaQuartos;
		}
		else if (key == sicavibe.ORMConstants.KEY_HOTEL_LISTAFUNCIONARIOS) {
			return ORM_listaFuncionarios;
		}
		else if (key == sicavibe.ORMConstants.KEY_HOTEL_LISTASERVICOSEXTRA) {
			return ORM_listaServicosExtra;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private sicavibe.Imagem img;
	
	private String nome;
	
	private String descricao;
	
	private String endereco;
	
	private java.util.Set ORM_listaReservas = new java.util.HashSet();
	
	private java.util.Set ORM_listaQuartos = new java.util.HashSet();
	
	private java.util.Set ORM_listaFuncionarios = new java.util.HashSet();
	
	private java.util.Set ORM_listaServicosExtra = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setDescricao(String value) {
		this.descricao = value;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setEndereco(String value) {
		this.endereco = value;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	private void setORM_ListaReservas(java.util.Set value) {
		this.ORM_listaReservas = value;
	}
	
	private java.util.Set getORM_ListaReservas() {
		return ORM_listaReservas;
	}
	
	public final sicavibe.ReservaSetCollection listaReservas = new sicavibe.ReservaSetCollection(this, _ormAdapter, sicavibe.ORMConstants.KEY_HOTEL_LISTARESERVAS, sicavibe.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_ListaQuartos(java.util.Set value) {
		this.ORM_listaQuartos = value;
	}
	
	private java.util.Set getORM_ListaQuartos() {
		return ORM_listaQuartos;
	}
	
	public final sicavibe.QuartoSetCollection listaQuartos = new sicavibe.QuartoSetCollection(this, _ormAdapter, sicavibe.ORMConstants.KEY_HOTEL_LISTAQUARTOS, sicavibe.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_ListaFuncionarios(java.util.Set value) {
		this.ORM_listaFuncionarios = value;
	}
	
	private java.util.Set getORM_ListaFuncionarios() {
		return ORM_listaFuncionarios;
	}
	
	public final sicavibe.FuncionarioSetCollection listaFuncionarios = new sicavibe.FuncionarioSetCollection(this, _ormAdapter, sicavibe.ORMConstants.KEY_HOTEL_LISTAFUNCIONARIOS, sicavibe.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_ListaServicosExtra(java.util.Set value) {
		this.ORM_listaServicosExtra = value;
	}
	
	private java.util.Set getORM_ListaServicosExtra() {
		return ORM_listaServicosExtra;
	}
	
	public final sicavibe.ServicoExtraSetCollection listaServicosExtra = new sicavibe.ServicoExtraSetCollection(this, _ormAdapter, sicavibe.ORMConstants.KEY_HOTEL_LISTASERVICOSEXTRA, sicavibe.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setImg(sicavibe.Imagem value) {
		this.img = value;
	}
	
	public sicavibe.Imagem getImg() {
		return img;
	}
	
	public Set<TipoDeQuarto> getTiposDeQuarto() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public Map<Integer, Integer> checkDisponibilidade(java.util.Date dataEntrada, java.util.Date dataSaida) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void ocupaQuartos(Map<Integer, Integer> listaTiposDeQuarto) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
