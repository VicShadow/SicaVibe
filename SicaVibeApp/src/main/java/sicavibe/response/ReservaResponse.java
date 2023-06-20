package sicavibe.response;

import javassist.NotFoundException;
import org.orm.PersistentException;
import sicavibe.Quarto;
import sicavibe.Reserva;
import sicavibe.ServicoExtra;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservaResponse {

    private int ID;
    private int hospedeId;
    private String hospedeNome;
    private UtilizadorResponse hospede;
    private Date dataEntrada;
    private Date dataSaida;
    private float preco;
    private String estado;
    private List<QuartoResponse> quartos = new ArrayList<>();
    private List<ServicoExtraResponse> servicosExtras = new ArrayList<>();



    public ReservaResponse(Reserva reserva, boolean isAdmin) throws SQLException, IOException, PersistentException, NotFoundException {
        this.ID = reserva.getID();
        this.estado = reserva.getEstado();
        this.preco = reserva.getPreco();
        this.hospedeId = reserva.getHospede().getID();

        if (!isAdmin) this.hospedeNome = reserva.getHospede().getNome();
        if (isAdmin) this.hospede = new UtilizadorResponse(reserva.getHospede());
        else this.hospede = null;

        this.dataEntrada = reserva.getDataEntrada();
        this.dataSaida = reserva.getDataSaida();
        this.preco = reserva.getPreco();
        this.estado = reserva.getEstado();

        for (ServicoExtra servicoExtra : reserva.servicosExtras.toArray()){
            this.servicosExtras.add(new ServicoExtraResponse(servicoExtra));
        }
        for (Quarto quarto : reserva.quartos.toArray()){
            this.quartos.add(new QuartoResponse(quarto));
        }
    }


    public int getID() {
        return ID;
    }

    public int getHospedeId() {
        return hospedeId;
    }

    public String getHospedeNome() {
        return hospedeNome;
    }

    public UtilizadorResponse getHospede() {
        return hospede;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public float getPreco() {
        return preco;
    }

    public String getEstado() {
        return estado;
    }

    public List<QuartoResponse> getQuartos() {
        return quartos;
    }

    public List<ServicoExtraResponse> getServicosExtras() {
        return servicosExtras;
    }
}
