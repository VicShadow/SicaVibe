package sicavibe.sicavibeapp;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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



    // REGISTER HOSPEDE
    @PostMapping(value = "/hospede/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Hospede registerHospede (@RequestBody Map<String, Object> body) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("email","password","nome","dataNascimento", "nTelemovel", "morada","cc","nif"),body);

            Hospede h = HospedeDAO.createHospede();
            h.setEmail((String) body.get("email"));
            h.setNome((String) body.get("nome"));
            h.setnTelemovel((String) body.get("nTelemovel"));
            h.setMorada((String) body.get("morada"));
            h.setCc((String) body.get("cc"));
            h.setNif((String) body.get("nif"));

            String salt = SicaVibeAppAux.generateSalt();
            String hashed = SicaVibeAppAux.hashPassword(((String) body.get("password")).concat(salt));
            h.setPassword(hashed);
            h.setSalt(salt);

            String stringDate = (String) body.get("dataNascimento");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
            h.setDataNascimento(date);

            HospedeDAO.save(h);
            return h;
        } catch (PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }




    // REGISTER FUNCIONARIO
    @PostMapping(value = "/funcionario/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Funcionario registerFuncionario (@RequestHeader Map<String, Object> headers, @RequestBody Map<String, Object> body) {
        try {
            //SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.ADMINISTRADOR);

            SicaVibeAppAux.checkRequestContent(List.of("hotelID","email","password","nome","dataNascimento", "nTelemovel", "morada","cc","nif"),body);

            Funcionario f = FuncionarioDAO.createFuncionario();
            f.setEmail((String) body.get("email"));
            f.setNome((String) body.get("nome"));
            f.setnTelemovel((String) body.get("nTelemovel"));
            f.setMorada((String) body.get("morada"));
            f.setCc((String) body.get("cc"));
            f.setNif((String) body.get("nif"));
            f.setEstado("INATIVO");

            String salt = SicaVibeAppAux.generateSalt();
            String hashed = SicaVibeAppAux.hashPassword(((String) body.get("password")).concat(salt));
            f.setPassword(hashed);
            f.setSalt(salt);

            String stringDate = (String) body.get("dataNascimento");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
            f.setDataNascimento(date);


            FuncionarioDAO.save(f);
            Hotel hotel = HotelDAO.getHotelByORMID((Integer) body.get("hotelID"));
            hotel.listaFuncionarios.add(f);
            return f;

        } catch (PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }





    // REGISTER ADMIN
    @PostMapping(value = "/admin/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Administador registerAmin (@RequestHeader Map<String, Object> headers, @RequestBody Map<String, Object> body) {
        try {
            //SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.ADMINISTRADOR);

            SicaVibeAppAux.checkRequestContent(List.of("email","password","nome","dataNascimento", "nTelemovel", "morada","cc","nif"), body);

            Administador admin = AdministadorDAO.createAdministador();
            admin.setEmail((String) body.get("email"));
            admin.setNome((String) body.get("nome"));
            admin.setnTelemovel((String) body.get("nTelemovel"));
            admin.setMorada((String) body.get("morada"));
            admin.setCc((String) body.get("cc"));
            admin.setNif((String) body.get("nif"));

            String salt = SicaVibeAppAux.generateSalt();
            String hashed = SicaVibeAppAux.hashPassword(((String) body.get("password")).concat(salt));
            admin.setPassword(hashed);
            admin.setSalt(salt);

            String stringDate = (String) body.get("dataNascimento");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
            admin.setDataNascimento(date);

            AdministadorDAO.save(admin);
            return admin;
        } catch (PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

}
