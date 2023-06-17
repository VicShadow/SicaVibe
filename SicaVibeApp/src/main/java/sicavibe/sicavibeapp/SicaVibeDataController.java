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


    @Operation(summary = "Obter informação simples de todos Hoteis",tags = {"No Auth"})
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

    @Operation(summary = "Obter informação completa de um Hotel",tags = {"No Auth"})
    @GetMapping(value = "/data/hotel/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HotelResponse getHotel(@PathVariable("id") int id){
        try {
            Hotel res = HotelDAO.getHotelByORMID(id);
            if (res == null)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Hotel '"+id+"' not found");
            return new HotelResponse(res,true);

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

    @Operation(summary = "Obter o conteúdo de uma imagem",tags = {"No Auth"})
    @GetMapping(value = "/imagem/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImagem(@PathVariable("id") int id) {
        try{
            Imagem img = ImagemDAO.getImagemByORMID(id);
            if (img == null)
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Image '"+id+"' not found");
            return img.getData().getBinaryStream().readAllBytes();

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

}
