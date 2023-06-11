/**
 * Licensee: vicshadow(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateSicaVibeMainVPData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().beginTransaction();
		try {
			sicavibe.Hotel sicaVibeHotel = sicavibe.HotelDAO.loadHotelByQuery(null, null);
			// Update the properties of the persistent object
			sicavibe.HotelDAO.save(sicaVibeHotel);
			sicavibe.Hospede sicaVibeHospede = sicavibe.HospedeDAO.loadHospedeByQuery(null, null);
			// Update the properties of the persistent object
			sicavibe.HospedeDAO.save(sicaVibeHospede);
			sicavibe.TipoDeQuarto sicaVibeTipoDeQuarto = sicavibe.TipoDeQuartoDAO.loadTipoDeQuartoByQuery(null, null);
			// Update the properties of the persistent object
			sicavibe.TipoDeQuartoDAO.save(sicaVibeTipoDeQuarto);
			sicavibe.Quarto sicaVibeQuarto = sicavibe.QuartoDAO.loadQuartoByQuery(null, null);
			// Update the properties of the persistent object
			sicavibe.QuartoDAO.save(sicaVibeQuarto);
			sicavibe.Reserva sicaVibeReserva = sicavibe.ReservaDAO.loadReservaByQuery(null, null);
			// Update the properties of the persistent object
			sicavibe.ReservaDAO.save(sicaVibeReserva);
			sicavibe.Funcionario sicaVibeFuncionario = sicavibe.FuncionarioDAO.loadFuncionarioByQuery(null, null);
			// Update the properties of the persistent object
			sicavibe.FuncionarioDAO.save(sicaVibeFuncionario);
			sicavibe.ServicoExtra sicaVibeServicoExtra = sicavibe.ServicoExtraDAO.loadServicoExtraByQuery(null, null);
			// Update the properties of the persistent object
			sicavibe.ServicoExtraDAO.save(sicaVibeServicoExtra);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Hotel by HotelCriteria");
		sicavibe.HotelCriteria sicaVibeHotelCriteria = new sicavibe.HotelCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//sicaVibeHotelCriteria.ID.eq();
		System.out.println(sicaVibeHotelCriteria.uniqueHotel());
		
		System.out.println("Retrieving Hospede by HospedeCriteria");
		sicavibe.HospedeCriteria sicaVibeHospedeCriteria = new sicavibe.HospedeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//sicaVibeHospedeCriteria.ID.eq();
		System.out.println(sicaVibeHospedeCriteria.uniqueHospede());
		
		System.out.println("Retrieving TipoDeQuarto by TipoDeQuartoCriteria");
		sicavibe.TipoDeQuartoCriteria sicaVibeTipoDeQuartoCriteria = new sicavibe.TipoDeQuartoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//sicaVibeTipoDeQuartoCriteria.ID.eq();
		System.out.println(sicaVibeTipoDeQuartoCriteria.uniqueTipoDeQuarto());
		
		System.out.println("Retrieving Quarto by QuartoCriteria");
		sicavibe.QuartoCriteria sicaVibeQuartoCriteria = new sicavibe.QuartoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//sicaVibeQuartoCriteria.ID.eq();
		System.out.println(sicaVibeQuartoCriteria.uniqueQuarto());
		
		System.out.println("Retrieving Reserva by ReservaCriteria");
		sicavibe.ReservaCriteria sicaVibeReservaCriteria = new sicavibe.ReservaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//sicaVibeReservaCriteria.ID.eq();
		System.out.println(sicaVibeReservaCriteria.uniqueReserva());
		
		System.out.println("Retrieving Funcionario by FuncionarioCriteria");
		sicavibe.FuncionarioCriteria sicaVibeFuncionarioCriteria = new sicavibe.FuncionarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//sicaVibeFuncionarioCriteria.ID.eq();
		System.out.println(sicaVibeFuncionarioCriteria.uniqueFuncionario());
		
		System.out.println("Retrieving ServicoExtra by ServicoExtraCriteria");
		sicavibe.ServicoExtraCriteria sicaVibeServicoExtraCriteria = new sicavibe.ServicoExtraCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//sicaVibeServicoExtraCriteria.ID.eq();
		System.out.println(sicaVibeServicoExtraCriteria.uniqueServicoExtra());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateSicaVibeMainVPData retrieveAndUpdateSicaVibeMainVPData = new RetrieveAndUpdateSicaVibeMainVPData();
			try {
				retrieveAndUpdateSicaVibeMainVPData.retrieveAndUpdateTestData();
				//retrieveAndUpdateSicaVibeMainVPData.retrieveByCriteria();
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
