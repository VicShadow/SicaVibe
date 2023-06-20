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

public class Reserva {
	public Reserva() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == sicavibe.ORMConstants.KEY_RESERVA_QUARTOS) {
			return ORM_quartos;
		}
		else if (key == sicavibe.ORMConstants.KEY_RESERVA_SERVICOSEXTRAS) {
			return ORM_servicosExtras;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == sicavibe.ORMConstants.KEY_RESERVA_HOSPEDE) {
			this.hospede = (sicavibe.Hospede) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private sicavibe.Hospede hospede;
	
	private java.util.Date dataEntrada;
	
	private java.util.Date dataSaida;
	
	private java.sql.Timestamp dataCheckIn;
	
	private java.sql.Timestamp dataCheckout;
	
	private float preco;
	
	private String estado;
	
	private java.util.Set ORM_quartos = new java.util.HashSet();
	
	private java.util.Set ORM_servicosExtras = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDataEntrada(java.util.Date value) {
		this.dataEntrada = value;
	}
	
	public java.util.Date getDataEntrada() {
		return dataEntrada;
	}
	
	public void setDataSaida(java.util.Date value) {
		this.dataSaida = value;
	}
	
	public java.util.Date getDataSaida() {
		return dataSaida;
	}
	
	public void setDataCheckIn(java.sql.Timestamp value) {
		this.dataCheckIn = value;
	}
	
	public java.sql.Timestamp getDataCheckIn() {
		return dataCheckIn;
	}
	
	public void setDataCheckout(java.sql.Timestamp value) {
		this.dataCheckout = value;
	}
	
	public java.sql.Timestamp getDataCheckout() {
		return dataCheckout;
	}
	
	public void setPreco(float value) {
		this.preco = value;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setEstado(String value) {
		this.estado = value;
	}
	
	public String getEstado() {
		return estado;
	}
	
	private void setORM_Quartos(java.util.Set value) {
		this.ORM_quartos = value;
	}
	
	private java.util.Set getORM_Quartos() {
		return ORM_quartos;
	}
	
	public final sicavibe.QuartoSetCollection quartos = new sicavibe.QuartoSetCollection(this, _ormAdapter, sicavibe.ORMConstants.KEY_RESERVA_QUARTOS, sicavibe.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_ServicosExtras(java.util.Set value) {
		this.ORM_servicosExtras = value;
	}
	
	private java.util.Set getORM_ServicosExtras() {
		return ORM_servicosExtras;
	}
	
	public final sicavibe.ServicoExtraSetCollection servicosExtras = new sicavibe.ServicoExtraSetCollection(this, _ormAdapter, sicavibe.ORMConstants.KEY_RESERVA_SERVICOSEXTRAS, sicavibe.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setHospede(sicavibe.Hospede value) {
		this.hospede = value;
	}
	
	public sicavibe.Hospede getHospede() {
		return hospede;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
