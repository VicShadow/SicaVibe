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

public class Quarto {
	public Quarto() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == sicavibe.ORMConstants.KEY_QUARTO_TIPODEQUARTO) {
			this.tipoDeQuarto = (sicavibe.TipoDeQuarto) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private sicavibe.TipoDeQuarto tipoDeQuarto;
	
	private int nPorta;
	
	private String estado;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setnPorta(int value) {
		this.nPorta = value;
	}
	
	public int getnPorta() {
		return nPorta;
	}
	
	public void setEstado(String value) {
		this.estado = value;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setTipoDeQuarto(sicavibe.TipoDeQuarto value) {
		this.tipoDeQuarto = value;
	}
	
	public sicavibe.TipoDeQuarto getTipoDeQuarto() {
		return tipoDeQuarto;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
