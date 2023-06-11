/**
 * Licensee: vicshadow(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListSicaVibeMainVPData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Hotel...");
		sicavibe.Hotel[] sicaVibeHotels = sicavibe.HotelDAO.listHotelByQuery(null, null);
		int length = Math.min(sicaVibeHotels.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(sicaVibeHotels[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Hospede...");
		sicavibe.Hospede[] sicaVibeHospedes = sicavibe.HospedeDAO.listHospedeByQuery(null, null);
		length = Math.min(sicaVibeHospedes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(sicaVibeHospedes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing TipoDeQuarto...");
		sicavibe.TipoDeQuarto[] sicaVibeTipoDeQuartos = sicavibe.TipoDeQuartoDAO.listTipoDeQuartoByQuery(null, null);
		length = Math.min(sicaVibeTipoDeQuartos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(sicaVibeTipoDeQuartos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Quarto...");
		sicavibe.Quarto[] sicaVibeQuartos = sicavibe.QuartoDAO.listQuartoByQuery(null, null);
		length = Math.min(sicaVibeQuartos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(sicaVibeQuartos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Reserva...");
		sicavibe.Reserva[] sicaVibeReservas = sicavibe.ReservaDAO.listReservaByQuery(null, null);
		length = Math.min(sicaVibeReservas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(sicaVibeReservas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Funcionario...");
		sicavibe.Funcionario[] sicaVibeFuncionarios = sicavibe.FuncionarioDAO.listFuncionarioByQuery(null, null);
		length = Math.min(sicaVibeFuncionarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(sicaVibeFuncionarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing ServicoExtra...");
		sicavibe.ServicoExtra[] sicaVibeServicoExtras = sicavibe.ServicoExtraDAO.listServicoExtraByQuery(null, null);
		length = Math.min(sicaVibeServicoExtras.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(sicaVibeServicoExtras[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Hotel by Criteria...");
		sicavibe.HotelCriteria sicaVibeHotelCriteria = new sicavibe.HotelCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//sicaVibeHotelCriteria.ID.eq();
		sicaVibeHotelCriteria.setMaxResults(ROW_COUNT);
		sicavibe.Hotel[] sicaVibeHotels = sicaVibeHotelCriteria.listHotel();
		int length =sicaVibeHotels== null ? 0 : Math.min(sicaVibeHotels.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(sicaVibeHotels[i]);
		}
		System.out.println(length + " Hotel record(s) retrieved."); 
		
		System.out.println("Listing Hospede by Criteria...");
		sicavibe.HospedeCriteria sicaVibeHospedeCriteria = new sicavibe.HospedeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//sicaVibeHospedeCriteria.ID.eq();
		sicaVibeHospedeCriteria.setMaxResults(ROW_COUNT);
		sicavibe.Hospede[] sicaVibeHospedes = sicaVibeHospedeCriteria.listHospede();
		length =sicaVibeHospedes== null ? 0 : Math.min(sicaVibeHospedes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(sicaVibeHospedes[i]);
		}
		System.out.println(length + " Hospede record(s) retrieved."); 
		
		System.out.println("Listing TipoDeQuarto by Criteria...");
		sicavibe.TipoDeQuartoCriteria sicaVibeTipoDeQuartoCriteria = new sicavibe.TipoDeQuartoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//sicaVibeTipoDeQuartoCriteria.ID.eq();
		sicaVibeTipoDeQuartoCriteria.setMaxResults(ROW_COUNT);
		sicavibe.TipoDeQuarto[] sicaVibeTipoDeQuartos = sicaVibeTipoDeQuartoCriteria.listTipoDeQuarto();
		length =sicaVibeTipoDeQuartos== null ? 0 : Math.min(sicaVibeTipoDeQuartos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(sicaVibeTipoDeQuartos[i]);
		}
		System.out.println(length + " TipoDeQuarto record(s) retrieved."); 
		
		System.out.println("Listing Quarto by Criteria...");
		sicavibe.QuartoCriteria sicaVibeQuartoCriteria = new sicavibe.QuartoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//sicaVibeQuartoCriteria.ID.eq();
		sicaVibeQuartoCriteria.setMaxResults(ROW_COUNT);
		sicavibe.Quarto[] sicaVibeQuartos = sicaVibeQuartoCriteria.listQuarto();
		length =sicaVibeQuartos== null ? 0 : Math.min(sicaVibeQuartos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(sicaVibeQuartos[i]);
		}
		System.out.println(length + " Quarto record(s) retrieved."); 
		
		System.out.println("Listing Reserva by Criteria...");
		sicavibe.ReservaCriteria sicaVibeReservaCriteria = new sicavibe.ReservaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//sicaVibeReservaCriteria.ID.eq();
		sicaVibeReservaCriteria.setMaxResults(ROW_COUNT);
		sicavibe.Reserva[] sicaVibeReservas = sicaVibeReservaCriteria.listReserva();
		length =sicaVibeReservas== null ? 0 : Math.min(sicaVibeReservas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(sicaVibeReservas[i]);
		}
		System.out.println(length + " Reserva record(s) retrieved."); 
		
		System.out.println("Listing Funcionario by Criteria...");
		sicavibe.FuncionarioCriteria sicaVibeFuncionarioCriteria = new sicavibe.FuncionarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//sicaVibeFuncionarioCriteria.ID.eq();
		sicaVibeFuncionarioCriteria.setMaxResults(ROW_COUNT);
		sicavibe.Funcionario[] sicaVibeFuncionarios = sicaVibeFuncionarioCriteria.listFuncionario();
		length =sicaVibeFuncionarios== null ? 0 : Math.min(sicaVibeFuncionarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(sicaVibeFuncionarios[i]);
		}
		System.out.println(length + " Funcionario record(s) retrieved."); 
		
		System.out.println("Listing ServicoExtra by Criteria...");
		sicavibe.ServicoExtraCriteria sicaVibeServicoExtraCriteria = new sicavibe.ServicoExtraCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//sicaVibeServicoExtraCriteria.ID.eq();
		sicaVibeServicoExtraCriteria.setMaxResults(ROW_COUNT);
		sicavibe.ServicoExtra[] sicaVibeServicoExtras = sicaVibeServicoExtraCriteria.listServicoExtra();
		length =sicaVibeServicoExtras== null ? 0 : Math.min(sicaVibeServicoExtras.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(sicaVibeServicoExtras[i]);
		}
		System.out.println(length + " ServicoExtra record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListSicaVibeMainVPData listSicaVibeMainVPData = new ListSicaVibeMainVPData();
			try {
				listSicaVibeMainVPData.listTestData();
				//listSicaVibeMainVPData.listByCriteria();
			}
			finally {
				sicavibe.SicaVibeMainVPPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
