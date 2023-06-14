package sicavibe;

import javassist.NotFoundException;
import org.orm.PersistentException;
import sicavibe.response.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public interface ISicaVibeFacade {

    public HotelResponse getHotel(int id) throws PersistentException, SQLException, IOException, NotFoundException;

    public Set<HotelResponse> getHoteis() throws PersistentException, SQLException, IOException;


}
