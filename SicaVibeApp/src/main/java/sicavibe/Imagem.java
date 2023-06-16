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

public class Imagem {
	public Imagem() {
	}
	
	private int ID;
	
	private String nome;
	
	private java.sql.Blob data;
	
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
	
	public void setData(java.sql.Blob value) {
		this.data = value;
	}
	
	public java.sql.Blob getData() {
		return data;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
