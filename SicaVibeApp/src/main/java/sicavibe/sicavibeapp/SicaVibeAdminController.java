package sicavibe.sicavibeapp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import javassist.NotFoundException;
import org.orm.PersistentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import sicavibe.*;
import sicavibe.response.QuartoResponse;
import sicavibe.response.ReservaResponse;
import sicavibe.response.UtilizadorResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import static sicavibe.sicavibeapp.SicaVibeAppAux.getListQuartos;

@RestController
public class SicaVibeAdminController {

    public class GetUsrListHeader extends SicaVibeAppAux.BaseHeader{
        String usertype;
        String page;
        String pageSize;

        public String getPage() {
            return page;
        }
        public String getPageSize() {
            return pageSize;
        }

        public String getUsertype() {
            return usertype;
        }
    }

    @Operation(summary = "Obter uma lista de um tipo de utilizador",tags = {"Admin"},parameters = {
            @Parameter(in= ParameterIn.HEADER,required = true,name = "token",description = "Token de Autorização"),
            @Parameter(in= ParameterIn.HEADER,required = true,name = "usertype",description = "Tipo de Utilizadores a ser devolvido ('HOSPEDE','FUNCIONARIO','ADMINISTRADOR')"),
            @Parameter(in= ParameterIn.HEADER,required = true,name = "page",description = "Número da página (>0)"),
            @Parameter(in= ParameterIn.HEADER,required = true,name = "pagesize",description = "Tamanho da Página (>0)"),
    })
    @GetMapping(value = "/admin/get-user-list",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UtilizadorResponse> getUserList(@RequestHeader() Map<String, Object> headers) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token","usertype","page","pagesize"),headers);
            SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.ADMINISTRADOR);

            String userType = headers.get("usertype").toString();
            int page = Integer.parseInt(headers.get("page").toString());
            int pageSize = Integer.parseInt(headers.get("pagesize").toString());
            if (page < 1 || pageSize < 1) throw new NumberFormatException();


            List<UtilizadorResponse> allUsers = new ArrayList<>();
            if (userType.equals("HOSPEDE")) {
                for (Hospede h : Arrays.stream(HospedeDAO.listHospedeByQuery(null, "Nome")).toList()) {
                    allUsers.add(new UtilizadorResponse(h));
                }
            }
            else if (userType.equals("FUNCIONARIO")){
                for (Funcionario f : Arrays.stream(FuncionarioDAO.listFuncionarioByQuery(null, "Nome")).toList()) {
                    allUsers.add(new UtilizadorResponse(f));
                }
            }
            else if (userType.equals("ADMINISTRADOR")){
                for (Administrador a : Arrays.stream(AdministradorDAO.listAdministradorByQuery(null, "Nome")).toList()) {
                    allUsers.add(new UtilizadorResponse(a));
                }
            }
            else {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"usertype provided is invalid");
            }

            return SicaVibeAppAux.paging(allUsers,page,pageSize);
        }catch (ResponseStatusException e){
            throw e;
        }catch (NumberFormatException e){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"page or pagesize is not a valid number");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }



    @Operation(summary = "Listar Quartos de Hoteis", tags = {"Admin"}, parameters = {
            @Parameter(in= ParameterIn.HEADER,required = true,name = "token",description = "Token de Autorização"),
            @Parameter(in= ParameterIn.HEADER, required = false, name = "hotelid", description = "ID do Hotel a Filtrar"),
            @Parameter(in= ParameterIn.HEADER,required = false,name = "tipoquarto",description = "Filtro de Tipo de Quarto (ID)")
    })
    @GetMapping(value = "/admin/get-quartos-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Integer, List<QuartoResponse>> getQuartosList (@RequestHeader Map<String, Object> headers) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"), headers);
            SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.ADMINISTRADOR);

            //CHECK OPTIONAL FILTER
            int filterTipo = -1;
            int hotelFilter = -1;

            Object filterTipoObj = headers.get("tipoquarto");
            if (filterTipoObj != null) filterTipo = Integer.parseInt(filterTipoObj.toString());
            Object filterHotelObj = headers.get("hotelid");
            if (filterHotelObj != null) hotelFilter = Integer.parseInt(filterHotelObj.toString());

            return getListQuartos(hotelFilter, filterTipo);

        } catch (ResponseStatusException e) {
            throw e;
        } catch (NumberFormatException | PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }



    @Operation(summary = "Listar Reservas de Hoteis", tags = {"Admin"}, parameters = {
            @Parameter(in= ParameterIn.HEADER,required = true,name = "token",description = "Token de Autorização"),
            @Parameter(in= ParameterIn.HEADER, required = false, name = "hotelid", description = "ID do Hotel a Filtrar")
    })
    @GetMapping(value = "/admin/get-reservation-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, List<ReservaResponse>> getReservasList (@RequestHeader Map<String, Object> headers) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"), headers);
            SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.ADMINISTRADOR);

            //CHECK OPTIONAL FILTER
            int hotelFilter = -1;

            Object filterHotelObj = headers.get("hotelid");
            if (filterHotelObj != null) hotelFilter = Integer.parseInt(filterHotelObj.toString());

            return getHotelReservas(hotelFilter);

        } catch (ResponseStatusException e) {
            throw e;
        } catch (NumberFormatException | PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }




    public static Map<String, List<ReservaResponse>> getHotelReservas (int hotelID) throws PersistentException, SQLException, IOException, NotFoundException {
        Map<String, List<ReservaResponse>> res = new HashMap<>();

        boolean hotelFilter = hotelID != -1;

        if (hotelFilter) { // reservas de um hotel específico
            Hotel h = HotelDAO.getHotelByORMID(hotelID);
            if (h == null) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Hotel id '"+hotelID+"' not found!");
            Reserva[] reservas = h.listaReservas.toArray();

            List<ReservaResponse> resHotel = new ArrayList<>();
            for (Reserva r : reservas) resHotel.add(new ReservaResponse(r, true));

            res.put(h.getNome(), resHotel);
            return res;
        }

        else {  // todos os quartos de todos os hóteis
            Hotel[] hoteis = HotelDAO.listHotelByQuery(null,null);
            for (Hotel hotel : hoteis) {
                List<ReservaResponse> resHotel = new ArrayList<>();
                for (Reserva r : hotel.listaReservas.toArray()) resHotel.add(new ReservaResponse(r, true));
                res.put(hotel.getNome(), resHotel);
            }
        }

        return res;
    }




    @Operation(summary = "Obter Reserva", tags = {"Admin"}, parameters = {
            @Parameter(in= ParameterIn.HEADER,required = true,name = "token",description = "Token de Autorização"),
            @Parameter(in= ParameterIn.HEADER,required = true,name = "reservaid",description = "ID da Reserva a pesquisar"),
    })
    @GetMapping(value = "/admin/reservation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservaResponse getReservaById (@RequestHeader Map<String, Object> headers) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token","reservaid"), headers);
            SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.ADMINISTRADOR);

            int reservaID = Integer.parseInt(headers.get("reservaid").toString());
            Reserva reserva = ReservaDAO.getReservaByORMID(reservaID);
            if (reserva == null) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Reservation with id '" + reservaID + "' not found!");

            return new ReservaResponse(reserva, false);

        } catch (ResponseStatusException e) {
            throw e;
        } catch (NumberFormatException | PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }





    @Operation(summary = "Obter informacao de um Admin", tags = {"Admin"},parameters = {
            @Parameter(in= ParameterIn.HEADER,required = true,name = "token",description = "Token de Autorização")},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(implementation = UtilizadorResponse.class))))
    @GetMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public UtilizadorResponse getHospede (@RequestHeader Map<String, Object> headers) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"),headers);
            int id = SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.ADMINISTRADOR);

            return new UtilizadorResponse(AdministradorDAO.getAdministradorByORMID(id));

        } catch (ResponseStatusException e) {
            throw e;
        } catch (PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }



}
