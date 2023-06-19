package sicavibe.sicavibeapp;

import org.orm.PersistentException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import sicavibe.Hotel;
import sicavibe.HotelDAO;
import sicavibe.Quarto;
import sicavibe.response.QuartoResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.*;

public class SicaVibeAppAux {

    public static class BaseHeader{
        String token;

        public String getToken() {
            return token;
        }
    }

    public static void checkRequestContent(List<String> desiredKeySet, Map<String,Object> content){
        for (String s : desiredKeySet){
            if (!content.containsKey(s)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Key-value '"+s+"' missing.");
            }
        }
    }

    public static <T> List<T> paging(List<T> globalList, int page,int pageSize){

        if(page <= 0 || pageSize <= 0)
            throw new NumberFormatException("Invalid Page or PageSize");

        int startIndex = (page-1) * pageSize;
        int endIndex = startIndex + pageSize;
        int listSize = globalList.size();

        if (startIndex > listSize-1) startIndex = listSize;
        if (endIndex > listSize) endIndex = listSize;

        return globalList.subList(startIndex,endIndex);
    }


    public static class QuartosHotel {
        private Map<Integer, List<QuartoResponse>> quartosPorHotel;

        public Map<Integer, List<QuartoResponse>> getQuartosPorHotel() {
            return quartosPorHotel;
        }
    }

    public static QuartosHotel getListQuartos (int hotelID, int tipoQuarto) throws PersistentException, SQLException, IOException {
        QuartosHotel res = new QuartosHotel();
        res.quartosPorHotel = new HashMap<>();

        boolean hotelFilter = hotelID != -1;

        if (hotelFilter) { // quartos de um hotel específico
            Hotel h = HotelDAO.getHotelByORMID(hotelID);
            if (h == null) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Hotel id '"+hotelID+"' not found!");
            List<QuartoResponse> quartos = filterQuartoByTipo(tipoQuarto, h.listaQuartos.toArray());
            res.quartosPorHotel.put(hotelID, quartos);
        }

       else {  // todos os quartos de todos os hóteis
            Hotel[] hoteis = HotelDAO.listHotelByQuery(null,null);
            for (Hotel hotel : hoteis) {
                List<QuartoResponse> quartos = filterQuartoByTipo(tipoQuarto, hotel.listaQuartos.toArray());
                res.quartosPorHotel.put(hotel.getID(), quartos);
            }

        }

        return res;
    }

    public static List<QuartoResponse> filterQuartoByTipo (int tipo, Quarto[] quartos) throws SQLException, IOException {
        List<QuartoResponse> res = new ArrayList<>();

        if (tipo == -1) {
            for (Quarto q : quartos) res.add(new QuartoResponse(q));
            return res;
        }

        for (Quarto quarto : quartos) {
            if (quarto.getTipoDeQuarto().getID() == tipo) res.add(new QuartoResponse(quarto));
        }

        return res;
    }


}
