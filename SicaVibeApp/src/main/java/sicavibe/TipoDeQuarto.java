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

public class TipoDeQuarto {
	public TipoDeQuarto() {
	}
	
	private int ID;
	
	private sicavibe.Imagem img;
	
	private String nome;
	
	private int capacidade;
	
	private float preco;
	
	private String descricao;
	
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
	
	public void setCapacidade(int value) {
		this.capacidade = value;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
	
	public void setPreco(float value) {
		this.preco = value;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setDescricao(String value) {
		this.descricao = value;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setImg(sicavibe.Imagem value) {
		this.img = value;
	}
	
	public sicavibe.Imagem getImg() {
		return img;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
