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

import org.orm.PersistentException;
import sicavibe.response.TipoDeQuartoResponse;

import java.io.InvalidObjectException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
		//Collect Unique IDs
		List<Integer> uniqueIDs = new ArrayList<>();
		for (Quarto quarto: this.listaQuartos.toArray()){
			int tipoQuartoID = quarto.getTipoDeQuarto().getID();
			for(Integer id : uniqueIDs){
				if (tipoQuartoID == id) break;
			}
			uniqueIDs.add(tipoQuartoID);
		}

		//Collect TiposDeQuarto
		Set<TipoDeQuarto> tipoDeQuartos = new HashSet<>();
		for(Integer id : uniqueIDs){
			for (Quarto quarto: this.listaQuartos.toArray()){
				if (quarto.getTipoDeQuarto().getID() == id){
					tipoDeQuartos.add(quarto.getTipoDeQuarto());
					break;
				}
			}
		}

		return tipoDeQuartos;
	}

	public List<Quarto> getQuartosDisponiveis(Date reservaDataEntrada, Date reservaDataSaida) throws InvalidObjectException {

		//CHECK DATES GIVEN
		if (reservaDataSaida.before(reservaDataEntrada) || reservaDataSaida.equals(reservaDataEntrada))
			throw new InvalidObjectException("'Data de Entrada' must be before and different from 'Data de saída'");

		//GET ALL QUARTOS OCUPADOS
		List<Quarto> quartosOcupados = new ArrayList<>();
		for (Reserva reserva : this.listaReservas.toArray()){
			//CHECK STATE
			if (reserva.getEstado().equals("TERMINADA") || reserva.getEstado().equals("CANCELADA")) continue;

			//CHECK DATES
			if (reserva.getDataSaida().before(reservaDataEntrada) || reserva.getDataSaida().equals(reservaDataEntrada)
					|| reserva.getDataEntrada().after(reservaDataSaida) || reserva.getDataEntrada().equals(reservaDataEntrada)) continue;

			//ADD QUARTOS
			quartosOcupados.addAll(Arrays.asList(reserva.quartos.toArray()));
		}

		//GET QUARTOS LIVRES
		List<Quarto> res = new ArrayList<>();
		for (Quarto quartosHotel : this.listaQuartos.toArray()){

			boolean occupied = false;
			for (Quarto quartoOcupado : quartosOcupados){
				if (quartosHotel.getID() == quartoOcupado.getID()) {
					occupied = true;
					break;
				}
			}
			if(occupied) continue;

			res.add(quartosHotel);
		}
		return res;
	}
	
	public Map<Integer, Integer> checkDisponibilidade(Date reservaDataEntrada, Date reservaDataSaida) throws InvalidObjectException {

		//GET QUARTOS DISPONIVEIS
		List<Quarto> quartosDisponiveis = this.getQuartosDisponiveis(reservaDataEntrada,reservaDataSaida);

		//GET QUARTOS LIVRES
		Map<Integer,Integer> res = new HashMap<>();
		for (Quarto quarto : quartosDisponiveis){
			int idTipoQuarto = quarto.getTipoDeQuarto().getID();
			if(res.containsKey(idTipoQuarto)) res.put(idTipoQuarto,res.get(idTipoQuarto) + 1);
			else res.put(idTipoQuarto,1);
		}

		return res;
	}
	
	public float marcaReserva(int hospedeID, Map<Integer, Integer> tiposDeQuartoDesejados,
							  List<Integer> servicosExtraDesejados,Date dataEntrada,Date dataSaida)
			throws InvalidObjectException, PersistentException {

		long diffInMillies = Math.abs(dataSaida.getTime() - dataEntrada.getTime());
		long diasEstadia = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		float precoFinal = 0.0f;

		//CHECK DISPONIBILIDADE & ADD PRICE
		Map<Integer,Integer> quartosDisponiveis = this.checkDisponibilidade(dataEntrada,dataSaida);
		for (Map.Entry<Integer,Integer> entry : tiposDeQuartoDesejados.entrySet()){
			if (!quartosDisponiveis.containsKey(entry.getKey()))
				throw new InvalidObjectException("Tipo de Quarto '"+entry.getKey()+"' Unavailable");

			int numQuartosDisponiveis = quartosDisponiveis.get(entry.getKey());
			int numQuartosDesejados = entry.getValue();
			if (numQuartosDesejados > numQuartosDisponiveis)
				throw new InvalidObjectException("Tipo de Quarto '"+entry.getKey()+"' Unavailable");

			//QUARTOS DISPONÍVEIS, MARCA PREÇO
			precoFinal += TipoDeQuartoDAO.getTipoDeQuartoByORMID(entry.getKey()).getPreco() * numQuartosDesejados * diasEstadia;
		}

		//CHECK SERVICOS EXTRA & ADD PRICE
		for(Integer servicoID : servicosExtraDesejados){
			ServicoExtra serv = ServicoExtraDAO.getServicoExtraByORMID(servicoID);
			if (serv == null)
				throw new InvalidObjectException("Serviço Extra '"+servicoID+"' doesn't exist");
			precoFinal += serv.getPreco();
		}

		//------ MAKE RESERVA ---------
		//HOSPEDE
		Hospede hospede = HospedeDAO.getHospedeByORMID(hospedeID);
		if (hospede == null)
			throw new InvalidObjectException("Hospede '"+hospedeID+"' doesn't exist");

		//SET BASIC INFO
		Reserva reserva = ReservaDAO.createReserva();
		reserva.setDataEntrada(dataEntrada); reserva.setDataSaida(dataSaida);
		reserva.setPreco(precoFinal); reserva.setDataCheckIn(null); reserva.setDataCheckout(null);
		reserva.setEstado("MARCADA"); reserva.setHospede(hospede);

		//GET QUARTOS TO USE
		for(Map.Entry<Integer,Integer> entry : tiposDeQuartoDesejados.entrySet()){
			int quartosToGet = entry.getValue();
			for (Quarto quarto : this.getQuartosDisponiveis(dataEntrada,dataSaida)){
				if (quarto.getTipoDeQuarto().getID() == entry.getKey() && quartosToGet > 0){
					reserva.quartos.add(quarto);
					quartosToGet--;
				}

				if (quartosToGet == 0) break;
			}
		}

		//GET SERVICOS
		for(Integer servicoID : servicosExtraDesejados){
			ServicoExtra serv = ServicoExtraDAO.getServicoExtraByORMID(servicoID);
			reserva.servicosExtras.add(serv);
		}

		//FINALLY
		this.listaReservas.add(reserva);
		HotelDAO.save(this);
		ReservaDAO.save(reserva);
		return reserva.getPreco();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
