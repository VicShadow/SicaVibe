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
import sicavibe.response.UtilizadorResponse;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static sicavibe.sicavibeapp.SicaVibeAuthController.setUserInfo;

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
    @GetMapping(value = "/funcionario/list-reservations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservaResponse> listReservas (@RequestHeader Map<String, Object> headers, @RequestBody Map<String,Object> body) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token","page","pagesize"),headers);
            int id = SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.FUNCIONARIO);

            //PARSE PAGES
            int page = Integer.parseInt(headers.get("page").toString());
            int pageSize = Integer.parseInt(headers.get("pagesize").toString());
            if (page < 1 || pageSize < 1) throw new NumberFormatException();

            //CHECK OPTIONAL ARGUMENTS
            String reservaType = headers.get("tipo").toString();
            String hospedeCC = headers.get("hospedecc").toString();
            String hospedeNome = headers.get("hospedenome").toString();
            boolean filtroTipo = false; boolean filtroCC = false; boolean filtroName = false;
            if (reservaType != null) filtroTipo = true;
            if (hospedeCC != null) filtroCC = true;
            if (hospedeNome != null) filtroName = true;
            if (filtroTipo && !reservaType.equals("MARCADA") && !reservaType.equals("TERMINADA")
            && !reservaType.equals("A_DECORRER") && !reservaType.equals("CANCELADA"))
                throw new InvalidObjectException("Filter Type '"+reservaType+"' invalid");

            int hotelID = FuncionarioDAO.getFuncionarioByORMID(id).getMyWorkHotel().getID();
            String condition = "HotelId = "+hotelID;
            if(filtroTipo) condition+= " AND Estado = '"+reservaType+"'";
            Reserva[] reservaList = ReservaDAO.listReservaByQuery("condition","DataEntrada DESC");

            //AGR TEM Q SE FILTRAR POR HOSPEDE AHAHAHHAHAHAH

            return null;




        } catch (ResponseStatusException e) {
            throw e;
        } catch (NumberFormatException | PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

}
