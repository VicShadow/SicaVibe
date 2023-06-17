package sicavibe.response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import sicavibe.*;

public class HotelResponse {

    private int ID;
    private String nome;
    private String descricao;
    private int imgID;
    private String endereco;
    private java.util.Set<ServicoExtraResponse> servicoExtraSet = new java.util.HashSet();
    private java.util.Set<TipoDeQuartoResponse> tipoDeQuartoSet = new java.util.HashSet();


    public HotelResponse(Hotel hotel,boolean completeInfo) throws SQLException, IOException {
        this.ID = hotel.getID();
        this.nome = hotel.getNome();
        this.descricao = hotel.getDescricao();
        this.imgID = hotel.getImg().getID();
        this.endereco = hotel.getEndereco();
        if (completeInfo){
            for (ServicoExtra servicoExtra : hotel.listaServicosExtra.toArray()){
                servicoExtraSet.add(new ServicoExtraResponse(servicoExtra));
            }
            for (TipoDeQuarto tipoDeQuarto : hotel.getTiposDeQuarto()){
                tipoDeQuartoSet.add(new TipoDeQuartoResponse(tipoDeQuarto));
            }
        }

    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getImgID() {
        return imgID;
    }

    public String getEndereco() {
        return endereco;
    }

    public Set<ServicoExtraResponse> getServicoExtraSet() {
        return servicoExtraSet;
    }

    public Set<TipoDeQuartoResponse> getTipoDeQuartoSet() {
        return tipoDeQuartoSet;
    }
}
