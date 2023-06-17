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

import javassist.NotFoundException;
import org.orm.PersistentException;

public class Funcionario extends sicavibe.Utilizador {
	public Funcionario() {
	}
	
	private String estado;
	
	public void setEstado(String value) {
		this.estado = value;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public String toString() {
		return super.toString();
	}

	public Hotel getMyWorkHotel() throws NotFoundException, PersistentException {
		for (Hotel h : HotelDAO.listHotelByQuery(null,null)){
			for (Funcionario func : h.listaFuncionarios.toArray()){
				if (func.getID() == this.getID()) return h;
			}
		}
		throw new NotFoundException("Employer '"+this.getID()+"' has no working hotel");
	}
	
}
