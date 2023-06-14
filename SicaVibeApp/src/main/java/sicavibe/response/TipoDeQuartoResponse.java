package sicavibe.response;
import sicavibe.*;

import java.io.IOException;
import java.sql.SQLException;

public class TipoDeQuartoResponse {

    private int ID;

    private String nome;

    private int capacidade;

    private float preco;

    private String descricao;

    private byte[] img;

    public TipoDeQuartoResponse(TipoDeQuarto tipoDeQuarto) throws SQLException, IOException {
        this.ID = tipoDeQuarto.getID();
        this.nome = tipoDeQuarto.getNome();
        this.descricao = tipoDeQuarto.getDescricao();
        this.capacidade = tipoDeQuarto.getCapacidade();
        this.preco = tipoDeQuarto.getPreco();
        this.img = tipoDeQuarto.getImg().getBinaryStream().readAllBytes();
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public float getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public byte[] getImg() {
        return img;
    }
}
