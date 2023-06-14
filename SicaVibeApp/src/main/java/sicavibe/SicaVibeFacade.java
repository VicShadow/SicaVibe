package sicavibe;

import javassist.NotFoundException;
import org.orm.PersistentException;
import sicavibe.response.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class SicaVibeFacade implements ISicaVibeFacade{

    public HotelResponse getHotel(int id) throws PersistentException, SQLException, IOException, NotFoundException {
        Hotel res = HotelDAO.getHotelByORMID(id);
        if (res == null)
            throw new NotFoundException("Hotel '"+id+"' not found");

        return new HotelResponse(res,true);
    }

    public Set<HotelResponse> getHoteis() throws PersistentException, SQLException, IOException {
        Set<HotelResponse> res = new HashSet<>();
        for (Hotel hotel : HotelDAO.listHotelByQuery(null,null)){
            res.add(new HotelResponse(hotel,false));
        }
        return res;
    }
}
