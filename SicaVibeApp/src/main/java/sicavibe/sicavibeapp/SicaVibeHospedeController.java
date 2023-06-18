package sicavibe.sicavibeapp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.orm.PersistentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sicavibe.*;
import sicavibe.response.ReservaResponse;
import sicavibe.response.UtilizadorResponse;

import java.io.InvalidObjectException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.format.DateTimeParseException;
import java.util.*;

import static sicavibe.sicavibeapp.SicaVibeAuthController.setUserInfo;

@RestController
public class SicaVibeHospedeController {

    @Operation(summary = "Obter informacao de um Hospede", tags = {"Hospede"})
    @GetMapping(value = "/hospede", produces = MediaType.APPLICATION_JSON_VALUE)
    public UtilizadorResponse getHospede (@RequestHeader Map<String, Object> headers) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"),headers);
            int id = SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.HOSPEDE);

            return new UtilizadorResponse(HospedeDAO.getHospedeByORMID(id));

        } catch (ResponseStatusException e) {
            throw e;
        } catch (PersistentException e) {
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
            throw e;
        } catch (PersistentException | SQLException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }

    }



    // EDIT HOSPEDE PROFILE
    @Operation(summary = "Editar perfil de um Hospede", tags = {"Hospede"},requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(implementation = UtilizadorResponse.class))))
    @PostMapping(value = "/hospede/edit-account", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Hospede editHospedeProfile (@RequestHeader Map<String, Object> headers, @RequestBody Map<String,Object> body) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"),headers);
            int id = SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.HOSPEDE);

            SicaVibeAppAux.checkRequestContent(List.of("email","password","nome","dataNascimento", "nTelemovel", "morada","cc","nif"), body);

            Hospede h = HospedeDAO.getHospedeByORMID(id);
            setUserInfo(h,body);
            HospedeDAO.save(h);
            return HospedeDAO.getHospedeByORMID(id);

        } catch (ResponseStatusException e) {
            throw e;
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
            throw e;
        } catch (PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }


    @Operation(summary = "Verifcar a disponibilidade de Quartos", tags = {"Hospede"},parameters = {
            @Parameter(in= ParameterIn.HEADER,name = "token",description = "Token de Autorização"),
            @Parameter(in= ParameterIn.HEADER,name = "hotelid",description = "ID do Hotel a verificar a disponibilidade"),
            @Parameter(in= ParameterIn.HEADER,name = "dataentrada",description = "Data de entrada da potencial reserva"),
            @Parameter(in= ParameterIn.HEADER,name = "datasaida",description = "Data de saída da potencial reserva"),
    })
    @GetMapping(value = "/hospede/check-availability", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<Integer,Integer> checkRoomsDisponibility (@RequestHeader Map<String, Object> headers) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token","hotelid","dataentrada","datasaida"),headers);
            SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.HOSPEDE);

            Date reservaDataEntrada = new SimpleDateFormat("dd/MM/yyyy").parse(headers.get("dataentrada").toString());
            Date reservaDataSaida = new SimpleDateFormat("dd/MM/yyyy").parse(headers.get("datasaida").toString());
            int hotelID = Integer.parseInt(headers.get("hotelid").toString());
            Hotel hotel = HotelDAO.getHotelByORMID(hotelID);

            return hotel.checkDisponibilidade(reservaDataEntrada,reservaDataSaida);

        } catch (ResponseStatusException e) {
            throw e;
        } catch (NumberFormatException | InvalidObjectException | ParseException | PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

}
