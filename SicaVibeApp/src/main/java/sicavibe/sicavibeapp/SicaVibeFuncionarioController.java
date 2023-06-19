package sicavibe.sicavibeapp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.orm.PersistentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sicavibe.*;
import sicavibe.response.ReservaResponse;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.sql.SQLException;
import java.util.*;

import static sicavibe.sicavibeapp.SicaVibeAppAux.paging;


@RestController
public class SicaVibeFuncionarioController {

    @Operation(summary = "Listar Reservas", tags = {"Funcionario"},parameters = {
            @Parameter(in= ParameterIn.HEADER,required = true,name = "token",description = "Token de Autorização"),
            @Parameter(in= ParameterIn.HEADER,required = false,name = "tipo",description = "Filtro de tipagem de Reserva"),
            @Parameter(in= ParameterIn.HEADER,required = false,name = "hospedecc",description = "CC do Hóspede"),
            @Parameter(in= ParameterIn.HEADER,required = false,name = "hospedenome",description = "Nome do Hóspede"),
            @Parameter(in= ParameterIn.HEADER,required = true,name = "page",description = "Número da página (>0)"),
            @Parameter(in= ParameterIn.HEADER,required = true,name = "pagesize",description = "Tamanho da Página (>0)"),
    })
    @GetMapping(value = "/funcionario/list-reservations", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservaResponse> listReservas (@RequestHeader Map<String, Object> headers) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token","page","pagesize"),headers);
            int id = SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.FUNCIONARIO);

            //PARSE PAGES
            int page = Integer.parseInt(headers.get("page").toString());
            int pageSize = Integer.parseInt(headers.get("pagesize").toString());
            if (page < 1 || pageSize < 1) throw new NumberFormatException();

            //CHECK OPTIONAL ARGUMENTS
            String reservaType = "";
            Object reservaTypeObj = headers.get("tipo");
            String hospedeCC;
            Object hospedeCCObj = headers.get("hospedecc");
            String hospedeNome;
            Object hospedeNomeObj = headers.get("hospedenome");

            boolean filtroTipo = false; boolean filtroCC = false; boolean filtroName = false;
            if (reservaTypeObj != null) {
                filtroTipo = true;
                reservaType = reservaTypeObj.toString();
            }
            if (hospedeCCObj != null) {
                filtroCC = true;
                hospedeCC = hospedeCCObj.toString();
            } else hospedeCC = "";
            if (hospedeNomeObj != null) {
                filtroName = true;
                hospedeNome = hospedeNomeObj.toString();
            } else hospedeNome = "";

            if (filtroTipo && !reservaType.equals("MARCADA") && !reservaType.equals("TERMINADA")
            && !reservaType.equals("A_DECORRER") && !reservaType.equals("CANCELADA"))
                throw new InvalidObjectException("Filter Type '"+reservaType+"' invalid");

            int hotelID = FuncionarioDAO.getFuncionarioByORMID(id).getMyWorkHotel().getID();
            String condition = "HotelId = "+hotelID;
            if(filtroTipo) condition+= " AND Estado = '"+reservaType+"'";
            Reserva[] reservaList = ReservaDAO.listReservaByQuery(condition,"DataEntrada DESC");
            List<Reserva> reservasFiltered = Arrays.stream(reservaList).toList();


            if (filtroCC) {
                Hospede[] hospede = HospedeDAO.listHospedeByQuery("Cc = " + hospedeCC, null);
                if (hospede.length == 0) throw new InvalidObjectException("Invalid Hospede CC number: " +hospedeCC);

                reservasFiltered = reservasFiltered.stream().filter(reserva -> reserva.getHospede().getCc().equals(hospedeCC)).toList();
            }

            if (filtroName) {
                Hospede[] hospedes = HospedeDAO.listHospedeByQuery("Nome LIKE '%" + hospedeNome + "%'", null);
                if (hospedes.length == 0) throw new InvalidObjectException("Invalid Hospede Name: " + hospedeNome);

                List<Integer> hospedesIDs = Arrays.stream(hospedes).map(Utilizador::getID).toList();
                reservasFiltered = reservasFiltered.stream().filter(reserva -> hospedesIDs.contains(reserva.getHospede().getID())).toList();
            }


            List<ReservaResponse> res = new ArrayList<>();

            reservasFiltered = paging(reservasFiltered, page, pageSize);

            reservasFiltered.forEach(r -> {
                try {
                    res.add(new ReservaResponse(r, false));
                } catch (SQLException | IOException e) {
                    throw new RuntimeException(e);
                }
            });
            return res;




        } catch (ResponseStatusException e) {
            throw e;
        } catch (NumberFormatException | PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }



    private static class EstadoReserva {
        private int reservaID;
        private String reservaType;

        public int getReservaID() {
            return reservaID;
        }

        public String getReservaType() {
            return reservaType;
        }
    }

    @Operation(summary = "Alterar Estado Reserva", tags = {"Funcionario"}, parameters = {
            @Parameter(in= ParameterIn.HEADER,required = true,name = "token",description = "Token de Autorização")},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json",
                    schema = @Schema(implementation = EstadoReserva.class))))
    @PostMapping(value = "/funcionario/alter-reservation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservaResponse setCheckedIn (@RequestHeader Map<String, Object> headers, @RequestBody Map<String, Object> body) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"),headers);
            SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.FUNCIONARIO);

            SicaVibeAppAux.checkRequestContent(List.of("reservaID","reservaType"),body);

            int reservaID = (int) body.get("reservaID");

            String reservaType = (String) body.get("reservaType");
            if (!reservaType.equals("MARCADA") && !reservaType.equals("TERMINADA") && !reservaType.equals("A_DECORRER") && !reservaType.equals("CANCELADA"))
                throw new InvalidObjectException("Filter Type '"+reservaType+"' invalid");

            Reserva reserva = ReservaDAO.getReservaByORMID(reservaID);
            if (reserva == null) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Reservation with id '"+reservaID+"' nor found");

            // Check validity of state change
            String estado = reserva.getEstado();
            if (estado.equals("TERMINADA")) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Reservation has already ended!");
            if (estado.equals("MARCADA") && reservaType.equals("TERMINADA")) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Reservation has not been checked-in yet!");
            if (estado.equals("A_DECORRER") && (reservaType.equals("CANCELADA") || reservaType.equals("MARCADA"))) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Reservation has already been initiated!");


            String estadoQuartos = reservaType.equals("A_DECORRER") ? "OCUPADO" : "POR_LIMPAR";
            Quarto[] quartos = reserva.quartos.toArray();
            for (Quarto quarto : quartos) {
                quarto.setEstado(estadoQuartos);
                QuartoDAO.save(quarto);
            }

            reserva.setEstado(reservaType);
            ReservaDAO.save(reserva);

            return new ReservaResponse(reserva, false);

        } catch (ResponseStatusException e) {
            throw e;
        } catch (NumberFormatException | PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }




    private static class QuartoState {
        private int[] quartosIDS;

        public int[] getQuartosIDS() {
            return quartosIDS;
        }
    }
    @Operation(summary = "Alterar Estado Quarto Para LIVRE", tags = {"Funcionario"}, parameters = {
            @Parameter(in= ParameterIn.HEADER,required = true,name = "token",description = "Token de Autorização")},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json",
                    schema = @Schema(implementation = QuartoState.class))))
    @PostMapping(value = "/funcionario/set-quarto-state", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void setQuartoState (@RequestHeader Map<String, Object> headers, @RequestBody Map<String, Object> body) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"),headers);
            SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.FUNCIONARIO);

            SicaVibeAppAux.checkRequestContent(List.of("quartosID"),body);
            int[] quartosID = (int[]) body.get("quartosID");

            for (int id : quartosID) {
                Quarto quarto = QuartoDAO.getQuartoByORMID(id);
                if (quarto == null) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Room with id '"+id+"' not found");
                quarto.setEstado("LIVRE");
                QuartoDAO.save(quarto);
            }


        } catch (ResponseStatusException e) {
            throw e;
        } catch (NumberFormatException | PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }



    }

}
