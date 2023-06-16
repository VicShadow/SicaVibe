package sicavibe.sicavibeapp;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.json.JSONString;

public class JwtToken {

    public static enum TipoUtilizador {
        HOSPEDE,
        FUNCIONARIO,
        ADMINISTRADOR
    }

    private int id;
    private TipoUtilizador tipoUtilizador;

    public JwtToken(int id,TipoUtilizador tipoUtilizador){
        this.id = id;
        this.tipoUtilizador = tipoUtilizador;
    }

    public int getId() {
        return id;
    }

    public TipoUtilizador getTipoUtilizador() {
        return tipoUtilizador;
    }

    public String toString() {
        JSONObject obj = new JSONObject();
        obj.put("id",this.id);
        obj.put("tipoUtilizador",this.tipoUtilizador);
        return obj.toString();
    }
}
