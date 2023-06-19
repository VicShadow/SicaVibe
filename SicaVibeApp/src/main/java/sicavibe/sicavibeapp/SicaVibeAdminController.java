package sicavibe.sicavibeapp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import sicavibe.*;
import sicavibe.response.UtilizadorResponse;

import java.util.*;

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
}
