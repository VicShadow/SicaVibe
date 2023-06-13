package sicavibe.sicavibeapp;

import org.orm.PersistentException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sicavibe.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class SicaVibeListingController {

    @GetMapping(value = "/data/hoteis",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Hotel> getHoteis() throws PersistentException {
        return Arrays.stream(HotelDAO.listHotelByQuery(null,null)).toList();
    }

    @GetMapping(value = "/data/tipos-de-quarto",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TipoDeQuarto> getTiposDeQuarto() throws PersistentException {
        return Arrays.stream(TipoDeQuartoDAO.listTipoDeQuartoByQuery(null,null)).toList();
    }

    @GetMapping(value = "/data/servicos-extra",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ServicoExtra> getServicosExtra() throws PersistentException {
        return Arrays.stream(ServicoExtraDAO.listServicoExtraByQuery(null,null)).toList();
    }

}
