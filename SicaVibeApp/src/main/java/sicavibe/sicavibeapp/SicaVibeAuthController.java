package sicavibe.sicavibeapp;

import org.json.JSONObject;
import org.orm.PersistentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import sicavibe.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class SicaVibeAuthController {

    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String jwt(@RequestBody Map<String,Object> body) {

        SicaVibeAppAux.checkRequestContent(List.of("email","password"),body);
        String email = body.get("email").toString();
        try{
            Utilizador usr = UtilizadorDAO.loadUtilizadorByQuery("Email='"+email+"'",null);
            if (usr == null)
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"No user with email '"+email+"' found");

            String pass = body.get("password").toString().concat(usr.getSalt());
            if (!SicaVibeAppAux.hashPassword(pass).equals(usr.getPassword()))
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Incorrect Password");

            //if (Hospede.class.isAssignableFrom(Utilizador.class));

            if (HospedeDAO.getHospedeByORMID(usr.getID()) != null)
                return SicaVibeAppApplication.jwtUtils.generateToken(new JwtToken(usr.getID(), JwtToken.TipoUtilizador.HOSPEDE));
            if (FuncionarioDAO.getFuncionarioByORMID(usr.getID()) != null)
                return SicaVibeAppApplication.jwtUtils.generateToken(new JwtToken(usr.getID(), JwtToken.TipoUtilizador.FUNCIONARIO));
            if (AdministadorDAO.getAdministadorByORMID(usr.getID()) != null)
                return SicaVibeAppApplication.jwtUtils.generateToken(new JwtToken(usr.getID(), JwtToken.TipoUtilizador.ADMINISTRADOR));

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"User '"+email+"' found and authorized, but no User-Type found");
        } catch (PersistentException | NoSuchAlgorithmException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }

    }

    public static int readTokenAndCheckAuthLevel(String token,JwtToken.TipoUtilizador level){
        JwtToken jwtToken = SicaVibeAppApplication.jwtUtils.getInfoFromToken(token);

        if (jwtToken.getTipoUtilizador() == JwtToken.TipoUtilizador.ADMINISTRADOR ||
                jwtToken.getTipoUtilizador() == level)
            return jwtToken.getId();

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Token unauthorized for this action");
    }

}
