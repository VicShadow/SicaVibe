package sicavibe.sicavibeapp;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sicavibe.*;
import sicavibe.response.*;

import java.util.*;

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
        } catch (ResponseStatusException e){
            throw e;
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

        } catch (ResponseStatusException e){
            throw e;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

    @Operation(summary = "Obter os tipos de quartos disponíveis num hotel",tags = {"No Auth"})
    @GetMapping(value = "/data/hotel/{id}/tipos-de-quartos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TipoDeQuartoResponse> getHotelTiposDeQuartos(@PathVariable("id") int id){
        try {
            Hotel h = HotelDAO.getHotelByORMID(id);
            if (h == null)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Hotel '"+id+"' not found");

            List<TipoDeQuartoResponse> res = new ArrayList<>();
            for (TipoDeQuarto tipo : h.getTiposDeQuarto()){
                res.add(new TipoDeQuartoResponse(tipo));
            }

            return res;

        } catch (ResponseStatusException e){
            throw e;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

    @Operation(summary = "Obter a informação de um tipo de quarto",tags = {"No Auth"})
    @GetMapping(value = "/data/tipo-de-quarto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TipoDeQuartoResponse getTipoDeQuarto(@PathVariable("id") int id){
        try {
            TipoDeQuarto tipo = TipoDeQuartoDAO.getTipoDeQuartoByORMID(id);
            if (tipo == null)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Tipo de Quarto '"+id+"' not found");

            return new TipoDeQuartoResponse(tipo);

        } catch (ResponseStatusException e){
            throw e;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }


    @Operation(summary = "Obter os serviços extra num hotel",tags = {"No Auth"})
    @GetMapping(value = "/data/hotel/{id}/servicos-extra", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ServicoExtraResponse> getHotelServicosExtra(@PathVariable("id") int id){
        try {
            Hotel h = HotelDAO.getHotelByORMID(id);
            if (h == null)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Hotel '"+id+"' not found");

            List<ServicoExtraResponse> res = new ArrayList<>();
            for (ServicoExtra serv : h.listaServicosExtra.toArray()){
                res.add(new ServicoExtraResponse(serv));
            }

            return res;

        } catch (ResponseStatusException e){
            throw e;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

    @Operation(summary = "Obter a informação de um serviço extra",tags = {"No Auth"})
    @GetMapping(value = "/data/servico-extra/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServicoExtraResponse getServicoExtra(@PathVariable("id") int id){
        try {
            ServicoExtra serv = ServicoExtraDAO.getServicoExtraByORMID(id);
            if (serv == null)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Serviço Extra '"+id+"' not found");

            return new ServicoExtraResponse(serv);

        } catch (ResponseStatusException e){
            throw e;
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

        } catch (ResponseStatusException e){
            throw e;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

}
