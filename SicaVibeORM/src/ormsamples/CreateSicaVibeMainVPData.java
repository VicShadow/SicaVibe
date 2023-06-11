/**
 * Licensee: vicshadow(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
import sicavibe.FuncionarioSetCollection;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

public class CreateSicaVibeMainVPData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().beginTransaction();
		try {

			//TIPO DE QUARTO
			sicavibe.TipoDeQuarto sicaVibeTipoDeQuarto = sicavibe.TipoDeQuartoDAO.createTipoDeQuarto();
			sicaVibeTipoDeQuarto.setNome("Vibe a Dois");
			sicaVibeTipoDeQuarto.setDescricao("Duas camas individuais");
			sicaVibeTipoDeQuarto.setCapacidade(2);
			sicaVibeTipoDeQuarto.setPreco(30);
			sicaVibeTipoDeQuarto.setImgUrl("");
			sicavibe.TipoDeQuartoDAO.save(sicaVibeTipoDeQuarto);

			//SERVICO EXTRA
			sicavibe.ServicoExtra sicaVibeServicoExtra = sicavibe.ServicoExtraDAO.createServicoExtra();
			sicaVibeServicoExtra.setNome("Jacuzzi");
			sicaVibeServicoExtra.setPreco(10);
			sicavibe.ServicoExtraDAO.save(sicaVibeServicoExtra);

			//HOSPEDE
			sicavibe.Hospede sicaVibeHospede = sicavibe.HospedeDAO.createHospede();
			sicaVibeHospede.setNome("Vic");
			sicaVibeHospede.setDataNascimento(Date.valueOf(LocalDate.now()));
			sicaVibeHospede.setCc("222");
			sicaVibeHospede.setNif("333");
			sicaVibeHospede.setEmail("vic@gmail.com");
			sicaVibeHospede.setMorada("No mundo");
			sicaVibeHospede.setPassword("123456");
			sicavibe.HospedeDAO.save(sicaVibeHospede);

			sicavibe.Hotel sicaVibeHotel = sicavibe.HotelDAO.createHotel();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : listaTipoDeQuarto, listaServicosExtra, listaFuncionarios, listaQuartos, listaReservas
			sicaVibeHotel.setNome("SicaVibe Braga");
			sicaVibeHotel.setDescricao("Braga");
			sicaVibeHotel.setEndereco("Braga");
			sicaVibeHotel.setImgUrl("");
			sicaVibeHotel.listaTipoDeQuarto.add(sicaVibeTipoDeQuarto);
			sicaVibeHotel.listaServicosExtra.add(sicaVibeServicoExtra);
			sicavibe.HotelDAO.save(sicaVibeHotel);


			sicavibe.Quarto sicaVibeQuarto = sicavibe.QuartoDAO.createQuarto();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : estado, nPorta, tipoDeQuarto
			sicaVibeQuarto.setTipoDeQuarto(sicaVibeTipoDeQuarto);
			sicaVibeQuarto.setEstado(1);
			sicaVibeQuarto.setnPorta(100);
			sicaVibeHotel.listaQuartos.add(sicaVibeQuarto);
			sicavibe.QuartoDAO.save(sicaVibeQuarto);


			sicavibe.Reserva sicaVibeReserva = sicavibe.ReservaDAO.createReserva();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : servicosExtras, quartos, hospede
			sicaVibeReserva.setHospede(sicaVibeHospede);
			sicaVibeReserva.setPreco(200);
			sicaVibeReserva.setDataEntrada(Date.valueOf(LocalDate.of(2021,6,10)));
			sicaVibeReserva.setDataSaida(Date.valueOf(LocalDate.of(2021,6,15)));
			sicaVibeReserva.setDataCheckIn(Date.valueOf(LocalDate.of(2021,6,10)));
			sicaVibeReserva.setDataCheckout(Date.valueOf(LocalDate.of(2021,6,15)));
			sicaVibeReserva.quartos.add(sicaVibeQuarto);
			sicaVibeReserva.servicosExtras.add(sicaVibeServicoExtra);
			sicaVibeHotel.listaReservas.add(sicaVibeReserva);
			sicavibe.ReservaDAO.save(sicaVibeReserva);


			sicavibe.Funcionario sicaVibeFuncionario = sicavibe.FuncionarioDAO.createFuncionario();
			// Initialize the properties of the persistent object here
			sicaVibeFuncionario.setNome("Vic");
			sicaVibeFuncionario.setDataNascimento(Date.valueOf(LocalDate.now()));
			sicaVibeFuncionario.setnTelemovel("132312");
			sicaVibeFuncionario.setEmail("vic@gmail.com");
			sicaVibeFuncionario.setMorada("No mundo");
			sicaVibeFuncionario.setPassword("123456");
			sicaVibeHotel.listaFuncionarios.add(sicaVibeFuncionario);
			sicavibe.FuncionarioDAO.save(sicaVibeFuncionario);

			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateSicaVibeMainVPData createSicaVibeMainVPData = new CreateSicaVibeMainVPData();
			try {
				createSicaVibeMainVPData.createTestData();
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
