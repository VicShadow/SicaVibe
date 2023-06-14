package sicavibe.response;
import sicavibe.*;
public class ServicoExtraResponse {

    private int ID;

    private String nome;

    private float preco;

    public ServicoExtraResponse(ServicoExtra servicoExtra){
        this.ID = servicoExtra.getID();
        this.nome = servicoExtra.getNome();
        this.preco = servicoExtra.getPreco();
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }
}
