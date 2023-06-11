/**
 * Licensee: vicshadow(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteSicaVibeMainVPData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().beginTransaction();
		try {
			sicavibe.Hotel sicaVibeHotel = sicavibe.HotelDAO.loadHotelByQuery(null, null);
			// Delete the persistent object
			sicavibe.HotelDAO.delete(sicaVibeHotel);
			sicavibe.Hospede sicaVibeHospede = sicavibe.HospedeDAO.loadHospedeByQuery(null, null);
			// Delete the persistent object
			sicavibe.HospedeDAO.delete(sicaVibeHospede);
			sicavibe.TipoDeQuarto sicaVibeTipoDeQuarto = sicavibe.TipoDeQuartoDAO.loadTipoDeQuartoByQuery(null, null);
			// Delete the persistent object
			sicavibe.TipoDeQuartoDAO.delete(sicaVibeTipoDeQuarto);
			sicavibe.Quarto sicaVibeQuarto = sicavibe.QuartoDAO.loadQuartoByQuery(null, null);
			// Delete the persistent object
			sicavibe.QuartoDAO.delete(sicaVibeQuarto);
			sicavibe.Reserva sicaVibeReserva = sicavibe.ReservaDAO.loadReservaByQuery(null, null);
			// Delete the persistent object
			sicavibe.ReservaDAO.delete(sicaVibeReserva);
			sicavibe.Funcionario sicaVibeFuncionario = sicavibe.FuncionarioDAO.loadFuncionarioByQuery(null, null);
			// Delete the persistent object
			sicavibe.FuncionarioDAO.delete(sicaVibeFuncionario);
			sicavibe.ServicoExtra sicaVibeServicoExtra = sicavibe.ServicoExtraDAO.loadServicoExtraByQuery(null, null);
			// Delete the persistent object
			sicavibe.ServicoExtraDAO.delete(sicaVibeServicoExtra);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteSicaVibeMainVPData deleteSicaVibeMainVPData = new DeleteSicaVibeMainVPData();
			try {
				deleteSicaVibeMainVPData.deleteTestData();
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
