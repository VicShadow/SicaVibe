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

public class Funcionario {

	public static final String estadoATIVO = "ATIVO";
	public static final String estadoINATIVO = "INATIVO";
	public static final String estadoEM_PAUSA = "EM_PAUSA";
	public Funcionario() {
	}
	
	private int ID;
	
	private String email;
	
	private String password;
	
	private String nome;
	
	private java.util.Date dataNascimento;
	
	private String morada;
	
	private String nTelemovel;
	
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
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setDataNascimento(java.util.Date value) {
		this.dataNascimento = value;
	}
	
	public java.util.Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setMorada(String value) {
		this.morada = value;
	}
	
	public String getMorada() {
		return morada;
	}
	
	public void setnTelemovel(String value) {
		this.nTelemovel = value;
	}
	
	public String getnTelemovel() {
		return nTelemovel;
	}
	
	public void setEstado(String value) {
		this.estado = value;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
