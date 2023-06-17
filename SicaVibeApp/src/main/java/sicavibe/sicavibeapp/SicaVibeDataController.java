package sicavibe.sicavibeapp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import javassist.NotFoundException;
import org.orm.PersistentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sicavibe.*;
import sicavibe.response.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
public class SicaVibeDataController {


    @Operation(summary = "GET Informação simples de todos Hoteis",tags = {"No Auth"})
    @GetMapping(value = "/data/hoteis", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<HotelResponse> getHoteis() {
        try {
            Set<HotelResponse> res = new HashSet<>();
            for (Hotel hotel : HotelDAO.listHotelByQuery(null,null)){
                res.add(new HotelResponse(hotel,false));
            }
            return res;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

    @Operation(summary = "GET Informação completa de um Hotel",tags = {"No Auth"})
    @GetMapping(value = "/data/hotel/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HotelResponse getHotel(@PathVariable("id") int id){
        try {
            Hotel res = HotelDAO.getHotelByORMID(id);
            if (res == null) throw new NotFoundException("Hotel '"+id+"' not found");
            return new HotelResponse(res,true);

        } catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }



    @GetMapping(value = "/runImg", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] test() throws PersistentException, SQLException, IOException {
        return HotelDAO.getHotelByORMID(1).getImg().getData().getBinaryStream().readAllBytes();
    }

    @PostMapping(value = "/jwt", consumes = MediaType.APPLICATION_JSON_VALUE)
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


    @GetMapping(value = "/imagem/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImagem(@PathVariable("id") int id) throws PersistentException, SQLException, IOException {
        return ImagemDAO.getImagemByORMID(id).getData().getBinaryStream().readAllBytes();
    }

}
