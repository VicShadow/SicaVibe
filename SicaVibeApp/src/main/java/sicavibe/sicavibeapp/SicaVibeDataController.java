package sicavibe.sicavibeapp;


import javassist.NotFoundException;
import org.orm.PersistentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import sicavibe.*;
import sicavibe.response.*;

import java.io.IOException;
import java.sql.SQLException;
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
    }



    @GetMapping(value = "/runImg",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] test() throws PersistentException, SQLException, IOException {
        return HotelDAO.getHotelByORMID(1).getImg().getBinaryStream().readAllBytes();
    }

}
