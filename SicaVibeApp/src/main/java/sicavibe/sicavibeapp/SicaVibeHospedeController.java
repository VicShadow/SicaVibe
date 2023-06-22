package sicavibe.sicavibeapp;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

import static sicavibe.sicavibeapp.SicaVibeAuthController.setUserInfo;

@RestController
public class SicaVibeHospedeController {

    private static ReentrantLock lock = new ReentrantLock();

    public static class MakeReservaBody{

        public int hotelid;
        public Date dataentrada;
        public Date datasaida;
        public Map<Integer,Integer> quartos;
        public List<Integer> servicosextra;

        public int getHotelid() {return hotelid;}
        public Date getDataentrada() {return dataentrada;}
        public Date getDatasaida() {return datasaida;}
        public Map<Integer, Integer> getQuartos() {return quartos;}
        public List<Integer> getServicosextra() {return servicosextra;}
    }

    @Operation(summary = "Obter informacao de um Hospede", tags = {"Hospede"},parameters = {
            @Parameter(in= ParameterIn.HEADER,required = true,name = "token",description = "Token de Autorização")},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(implementation = UtilizadorResponse.class))))
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

    @Operation(summary = "Obter Reservas de um Hospede", tags = {"Hospede"},parameters = {
            @Parameter(in= ParameterIn.HEADER,required = true,name = "token",description = "Token de Autorização")})
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
    @Operation(summary = "Editar perfil de um Hospede", tags = {"Hospede"},
            parameters = { @Parameter(in= ParameterIn.HEADER,required = true,name = "token",description = "Token de Autorização")})
    @PostMapping(value = "/hospede/edit-account", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Hospede editHospedeProfile (@RequestHeader Map<String, Object> headers, @RequestBody Map<String,Object> body) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"),headers);
            int id = SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.HOSPEDE);

            SicaVibeAppAux.checkRequestContent(List.of("email","nome","dataNascimento", "numTelemovel", "morada","cc","nif"), body);

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
    @Operation(summary = "Eliminar conta de um Hospede", tags = {"Hospede"},parameters = {
            @Parameter(in= ParameterIn.HEADER,required = true,name = "token",description = "Token de Autorização")})
    @PostMapping(value = "/hospede/delete-account", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteHospedeAccount (@RequestHeader Map<String, Object> headers) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"),headers);
            int id = SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.HOSPEDE);

            Reserva[] hospedeReservas = ReservaDAO.listReservaByQuery("UtilizadorID = " + id, null);
            for (Reserva r : hospedeReservas) ReservaDAO.delete(r);

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
            @Parameter(in= ParameterIn.HEADER, required = true, name = "token",description = "Token de Autorização"),
            @Parameter(in= ParameterIn.HEADER, required = true, name = "hotelid",description = "ID do Hotel a verificar a disponibilidade"),
            @Parameter(in= ParameterIn.HEADER, required = true, name = "dataentrada",description = "Data de entrada da potencial reserva"),
            @Parameter(in= ParameterIn.HEADER, required = true, name = "datasaida",description = "Data de saída da potencial reserva"),
    })
    @GetMapping(value = "/hospede/check-availability", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<Integer,Integer> checkRoomsAvailability (@RequestHeader Map<String, Object> headers) {
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



    @Operation(summary = "Marcar uma reserva", tags = {"Hospede"},
            parameters = { @Parameter(in= ParameterIn.HEADER,required = true,name = "token",description = "Token de Autorização")},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(implementation = MakeReservaBody.class))))
    @PostMapping(value = "/hospede/make-reservation", consumes = MediaType.APPLICATION_JSON_VALUE)
    public float makeReservation (@RequestHeader Map<String, Object> headers,@RequestBody Map<String, Object> body) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"),headers);
            SicaVibeAppAux.checkRequestContent(List.of("hotelid","dataentrada","datasaida","quartos","servicosextra"),body);
            int id = SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.HOSPEDE);

            //Parse Dates
            Date reservaDataEntrada = new SimpleDateFormat("dd/MM/yyyy").parse(body.get("dataentrada").toString());
            Date reservaDataSaida = new SimpleDateFormat("dd/MM/yyyy").parse(body.get("datasaida").toString());

            //Parse JSON Object & Convert
            String jsonStr = body.get("quartos").toString();
            jsonStr = jsonStr.replace("=",":");
            System.out.println(jsonStr);
            JSONObject quartosDesejadosJSON = new JSONObject(jsonStr);
            Map<Integer,Integer> quartosDesejados = new HashMap<>();
            for (Map.Entry<String,Object> entry : quartosDesejadosJSON.toMap().entrySet()){
                quartosDesejados.put(Integer.parseInt(entry.getKey()),Integer.parseInt(entry.getValue().toString()));
            }

            //Parse JSON Array & Convert
            System.out.println(body.get("servicosextra").toString());
            JSONArray servicosExtraDesejadosJSON = new JSONArray(body.get("servicosextra").toString());
            List<Integer> servicosExtraDesejados = new ArrayList<>();
            for (Object obj : servicosExtraDesejadosJSON.toList()){
                servicosExtraDesejados.add(Integer.parseInt(obj.toString()));
            }

            //Get Hotel ID for operation
            int hotelID = Integer.parseInt(body.get("hotelid").toString());
            Hotel hotel = HotelDAO.getHotelByORMID(hotelID);

            try{
                lock.lock();
                return hotel.marcaReserva(id,quartosDesejados,servicosExtraDesejados,reservaDataEntrada,reservaDataSaida);
            } finally {
                lock.unlock();
            }

        } catch (ResponseStatusException e) {
            throw e;
        } catch (NumberFormatException | InvalidObjectException | ParseException | PersistentException | JSONException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }


    @Operation(summary = "Cancelar uma Reserva", tags = {"Hospede"}, parameters = {
            @Parameter(in= ParameterIn.HEADER,required = true,name = "token",description = "Token de Autorização"),
            @Parameter(in= ParameterIn.HEADER,required = true,name = "reservaid",description = "ID da Reserva a Cancelar")})
    @PostMapping(value = "/hospede/reservation-cancel", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void cancelReservation (@RequestHeader Map<String, Object> headers,@RequestBody Map<String, Object> body) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"),headers);
            SicaVibeAppAux.checkRequestContent(List.of("reservaid"),body);
            SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.HOSPEDE);
            int reservaID = Integer.parseInt(body.get("reservaid").toString());

            Reserva reserva = ReservaDAO.getReservaByORMID(reservaID);
            if (reserva == null)
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"No Reservation with id '"+reservaID+"'");

            if (!reserva.getEstado().equals("MARCADA"))
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Cannot perform the cancelation. State '"+reserva.getEstado()+"' can't be cancelled");

            reserva.setEstado("CANCELADA");
            ReservaDAO.save(reserva);

        } catch (ResponseStatusException e) {
            throw e;
        } catch (NumberFormatException | PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

}
