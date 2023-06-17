package sicavibe.sicavibeapp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.orm.PersistentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sicavibe.Hospede;
import sicavibe.HospedeDAO;
import sicavibe.Reserva;
import sicavibe.ReservaDAO;
import sicavibe.response.HospedePerfilResponse;
import sicavibe.response.ReservaResponse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static sicavibe.sicavibeapp.SicaVibeAuthController.setUserInfo;

@RestController
public class SicaVibeHospedeController {

    @Operation(summary = "Obter informacao de um Hospede", tags = {"Hospede"})
    @GetMapping(value = "/hospede", produces = MediaType.APPLICATION_JSON_VALUE)
    public HospedePerfilResponse getHospede (@RequestHeader Map<String, Object> headers) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"),headers);
            int id = SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.HOSPEDE);

            return new HospedePerfilResponse(HospedeDAO.getHospedeByORMID(id));

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getMessage(), e);
        } catch (PersistentException | SQLException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }

    }


    @Operation(summary = "Obter Reservas de um Hospede", tags = {"Hospede"})
    @GetMapping(value = "/hospede/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservaResponse> getHospedeReservas (@RequestHeader Map<String, Object> headers) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"),headers);
            int id = SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.HOSPEDE);

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



    // EDIT HOSPEDE PROFILE
    @Operation(summary = "Editar perfil de um Hospede", tags = {"Hospede"},requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(implementation = HospedePerfilResponse.class))))
    @PostMapping(value = "/hospede/edit-account", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Hospede editHospedeProfile (@RequestHeader Map<String, Object> headers, @RequestBody Map<String,Object> body) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"),headers);
            int id = SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.HOSPEDE);

            SicaVibeAppAux.checkRequestContent(List.of("email","password","nome","dataNascimento", "nTelemovel", "morada","cc","nif"), body);

            Hospede h = HospedeDAO.getHospedeByORMID(id);
            setUserInfo(h,body);
            HospedeDAO.update(h);
            return HospedeDAO.getHospedeByORMID(id);

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getMessage(), e);
        } catch (PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }




    // DELETE HOSPEDE ACCOUNT
    @Operation(summary = "Eliminar conta de um Hospede", tags = {"Hospede"})
    @PostMapping(value = "/hospede/delete-account", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteHospedeAccount (@RequestHeader Map<String, Object> headers) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"),headers);
            int id = SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.HOSPEDE);

            HospedeDAO.delete(HospedeDAO.getHospedeByORMID(id));

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getMessage(), e);
        } catch (PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

}
