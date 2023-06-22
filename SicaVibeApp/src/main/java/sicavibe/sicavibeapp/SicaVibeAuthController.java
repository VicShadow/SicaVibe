package sicavibe.sicavibeapp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.orm.PersistentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import sicavibe.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class SicaVibeAuthController {


    private static class UserInfoBody{
        private String email;
        private String password;
        private String nome;
        @Schema(example = "dd/MM/yyyy")
        private String dataNascimento;
        private String numTelemovel;
        private String morada;
        private String cc;
        private String nif;

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getNome() {
            return nome;
        }

        public String getDataNascimento() {
            return dataNascimento;
        }

        public String getNumTelemovel() {
            return numTelemovel;
        }

        public String getMorada() {
            return morada;
        }

        public String getCc() {
            return cc;
        }

        public String getNif() {
            return nif;
        }
    }
    private static class FuncionarioInfoBody extends UserInfoBody{
        private int hotelID;

        public int getHotelID() {
            return hotelID;
        }
    }

    private static class LoginInfoBody{
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }



    @Operation(summary = "Login de Utilizador",tags = {"No Auth"},requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(implementation = LoginInfoBody.class))))
    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String jwt(@RequestBody Map<String,Object> body) {

        SicaVibeAppAux.checkRequestContent(List.of("email","password"),body);
        String email = body.get("email").toString();
        try{
            Utilizador usr = UtilizadorDAO.loadUtilizadorByQuery("Email='"+email+"'",null);
            if (usr == null)
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"No user with email '"+email+"' found");

            String pass = body.get("password").toString().concat(usr.getSalt());
            if (!SicaVibeAuthController.hashPassword(pass).equals(usr.getPassword()))
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Incorrect Password");

            if (usr instanceof Hospede)
                return SicaVibeAppApplication.jwtUtils.generateToken(new JwtToken(usr.getID(), JwtToken.TipoUtilizador.HOSPEDE));
            if (usr instanceof Funcionario)
                return SicaVibeAppApplication.jwtUtils.generateToken(new JwtToken(usr.getID(), JwtToken.TipoUtilizador.FUNCIONARIO));
            if (usr instanceof Administrador)
                return SicaVibeAppApplication.jwtUtils.generateToken(new JwtToken(usr.getID(), JwtToken.TipoUtilizador.ADMINISTRADOR));

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"UserStore '"+email+"' found and authorized, but no UserStore-Type found");
        } catch (PersistentException | NoSuchAlgorithmException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }

    }





    // REGISTER HOSPEDE
    @Operation(summary = "Registo de um novo Hospede",tags = {"No Auth"},requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(implementation = UserInfoBody.class))))
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String registerHospede (@RequestBody Map<String,Object> body) {
        try {

            Hospede h = HospedeDAO.createHospede();
            setUserInfo(h,body);
            HospedeDAO.save(h);
            HospedeDAO.refresh(h);
            return SicaVibeAppApplication.jwtUtils.generateToken(new JwtToken(h.getID(), JwtToken.TipoUtilizador.HOSPEDE));

        } catch (ResponseStatusException e) {
            throw e;
        } catch (PersistentException e) {

            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }




    // REGISTER FUNCIONARIO
    @Operation(summary = "Registo de um novo Funcionário",tags = {"Admin"},requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(implementation = FuncionarioInfoBody.class))))
    @PostMapping(value = "/admin/register-func", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void registerFuncionario (@RequestHeader Map<String, Object> headers, @RequestBody Map<String,Object> body) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"), headers);
            SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.ADMINISTRADOR);

            //Check Extra (Set Info ja verifica o resto)
            SicaVibeAppAux.checkRequestContent(List.of("hotelID"),body);
            Funcionario f = FuncionarioDAO.createFuncionario();
            setUserInfo(f,body);
            FuncionarioDAO.save(f);
            FuncionarioDAO.refresh(f);

            Hotel hotel = HotelDAO.getHotelByORMID((Integer) body.get("hotelID"));
            hotel.listaFuncionarios.add(f);
            HotelDAO.save(hotel);

        } catch (ResponseStatusException e) {
            throw e;
        } catch (PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }





    // REGISTER ADMIN
    @Operation(summary = "Registo de um novo Administrador",tags = {"Admin"},requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(implementation = SicaVibeAuthController.UserInfoBody.class))))
    @PostMapping(value = "/admin/register-admin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void registerAdmin (@RequestHeader Map<String, Object> headers, @RequestBody Map<String,Object> body) {
        try {
            SicaVibeAppAux.checkRequestContent(List.of("token"), headers);
            SicaVibeAuthController.readTokenAndCheckAuthLevel((String)headers.get("token"), JwtToken.TipoUtilizador.ADMINISTRADOR);

            Administrador admin = AdministradorDAO.createAdministrador();
            setUserInfo(admin,body);
            AdministradorDAO.save(admin);
            AdministradorDAO.refresh(admin);

        } catch (ResponseStatusException e) {
            throw e;
        } catch (PersistentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }




    public static void setUserInfo(Utilizador user,Map<String,Object> body) throws NoSuchAlgorithmException, ParseException {
        SicaVibeAppAux.checkRequestContent(List.of("email","nome","dataNascimento", "numTelemovel", "morada","cc","nif"), body);

        user.setEmail(body.get("email").toString());
        user.setNome(body.get("nome").toString());
        user.setNumTelemovel(body.get("numTelemovel").toString());
        user.setMorada(body.get("morada").toString());
        user.setCc(body.get("cc").toString());
        user.setNif(body.get("nif").toString());

        if (body.get("password") != null) {
            String basePass = body.get("password").toString();
            if(!SicaVibeAuthController.isAcceptablePassword(basePass))
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Password provided doesn't meet the criteria");
            String salt = SicaVibeAuthController.generateSalt();
            String hashed = SicaVibeAuthController.hashPassword(basePass.concat(salt));
            user.setPassword(hashed);
            user.setSalt(salt);
        }

        String stringDate = body.get("dataNascimento").toString();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
        user.setDataNascimento(date);
    }



    public static int readTokenAndCheckAuthLevel(String token,JwtToken.TipoUtilizador level){
        JwtToken jwtToken = SicaVibeAppApplication.jwtUtils.getInfoFromToken(token);

        if (jwtToken.getTipoUtilizador() == JwtToken.TipoUtilizador.ADMINISTRADOR ||
                jwtToken.getTipoUtilizador() == level)
            return jwtToken.getId();

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Token unauthorized for this action");
    }

    public static boolean isAcceptablePassword(String password) {
        final int MIN_LENGTH = 8;
        final int MAX_LENGTH = 32;
        final boolean REQUIRE_SPECIAL_CHARACTERS = true;
        final boolean REQUIRE_UPPERCASE = true;
        final boolean REQUIRE_LOWERCASE = true;

        if (password.length() < MIN_LENGTH) return false;
        if (password.length() > MAX_LENGTH) return false;
        if (REQUIRE_SPECIAL_CHARACTERS && !password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) return false;
        if (REQUIRE_UPPERCASE && !password.matches(".*[A-Z].*")) return false;
        if (REQUIRE_LOWERCASE && !password.matches(".*[a-z].*")) return false;

        return true;
    }

    private static String generateSalt(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 6;

        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static String hashPassword(String pass) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodedhash);
    }


    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
