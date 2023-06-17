package sicavibe.response;

import sicavibe.Quarto;

import java.io.IOException;
import java.sql.SQLException;

public class QuartoResponse {
    private int id;
    private int tipoQuartoID;
    private String tipoQuartoNome;
    private int nPorta;
    private String estado;

    public QuartoResponse(Quarto quarto) throws SQLException, IOException {
        this.id = quarto.getID();
        this.tipoQuartoID = quarto.getTipoDeQuarto().getID();
        this.tipoQuartoNome = quarto.getTipoDeQuarto().getNome();
        this.nPorta = quarto.getnPorta();
        this.estado = quarto.getEstado();
    }

    public int getId() {
        return id;
    }

    public int getTipoQuartoID() {
        return tipoQuartoID;
    }

    public String getTipoQuartoNome() {
        return tipoQuartoNome;
    }

    public int getnPorta() {
        return nPorta;
    }

    public String getEstado() {
        return estado;
    }
}