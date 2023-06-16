package sicavibe.sicavibeapp;


import javassist.NotFoundException;
import org.json.JSONObject;
import org.json.JSONString;
import org.orm.PersistentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sicavibe.*;
import sicavibe.response.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

@RestController
public class SicaVibeDataController {


    @GetMapping(value = "/data/hoteis",produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<HotelResponse> getHoteis() throws PersistentException {
        try {
            return SicaVibeAppApplication.sicaVibeFacade.getHoteis();
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

    @GetMapping(value = "/data/hotel/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public HotelResponse getHotel(@PathVariable("id") int id){
        try {
            return SicaVibeAppApplication.sicaVibeFacade.getHotel(id);
        } catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
        //ReservaDAO.createReserva().quartos.add();
    }



    @GetMapping(value = "/runImg",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] test() throws PersistentException, SQLException, IOException {
        return HotelDAO.getHotelByORMID(1).getImg().getData().getBinaryStream().readAllBytes();
    }

    @PostMapping(value = "/jwt",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jwt(@RequestHeader Map<String,Object> header) {
        JwtToken token = new JwtToken(1,JwtToken.TipoUtilizador.HOSPEDE);
        return SicaVibeAppApplication.jwtUtils.generateToken(token);
    }

    @PostMapping(value = "/jwtSend")
    public JwtToken jwtSend(@RequestBody Map<String,Object> body) {
        String token = body.get("token").toString();
        if (!SicaVibeAppApplication.jwtUtils.validateToken(token))
            return null;

        return SicaVibeAppApplication.jwtUtils.getInfoFromToken(token);
    }


}
