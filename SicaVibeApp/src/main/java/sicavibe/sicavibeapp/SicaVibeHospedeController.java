package sicavibe.sicavibeapp;

import org.orm.PersistentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import sicavibe.HospedeDAO;
import sicavibe.Reserva;
import sicavibe.ReservaDAO;
import sicavibe.response.HospedePerfilResponse;
import sicavibe.response.ReservaResponse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class SicaVibeHospedeController {

    //@Operation(summary = "Obter informação de um Hóspede", tags = {"Hospede"})
    @GetMapping(value = "/hospede", produces = MediaType.APPLICATION_JSON_VALUE)
    public HospedePerfilResponse getHospede (@RequestHeader Map<String, Object> headers) {
        try {
            //SicaVibeAppAux.checkRequestContent(List.of("token"),headers);
            //int id = SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.HOSPEDE);
            int id = 1;
            return new HospedePerfilResponse(HospedeDAO.getHospedeByORMID(id));

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getMessage(), e);
        } catch (PersistentException | SQLException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }

    }


    //@Operation(summary = "Obter informação de um Hóspede", tags = {"Hospede"})
    @GetMapping(value = "/hospede/reservas", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservaResponse> getHospedeReservas (@RequestHeader Map<String, Object> headers) {
        try {
            //SicaVibeAppAux.checkRequestContent(List.of("token"),headers);
            //int id = SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.HOSPEDE);
            int id = 1;

            List<ReservaResponse> reservas = new ArrayList<>();
            for (Reserva res : ReservaDAO.listReservaByQuery("UtilizadorID = " + id, null))
                reservas.add(new ReservaResponse(res, false));

            return reservas;

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getMessage(), e);
        } catch (PersistentException | SQLException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }

    }
}
