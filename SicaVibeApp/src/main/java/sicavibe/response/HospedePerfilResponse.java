package sicavibe.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.orm.PersistentException;
import sicavibe.*;

import java.sql.SQLException;
import java.util.Date;

public class HospedePerfilResponse {
    private int ID;
    private String email;
    private String password;
    private String nome;
    private String telemovel;
    private String morada;
    private String cc;
    private String nif;

    //@Schema(example = "dd/MM/yyyy")
    private Date dataNascimento;



    public HospedePerfilResponse (Hospede hospede) throws PersistentException, SQLException {
        this.ID = hospede.getID();
        this.email = hospede.getEmail();
        this.password = hospede.getPassword();
        this.nome = hospede.getNome();
        this.telemovel = hospede.getnTelemovel();
        this.morada = hospede.getMorada();
        this.cc = hospede.getCc();
        this.nif = hospede.getNif();
        this.dataNascimento = hospede.getDataNascimento();
    }


    public int getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getnTelemovel() {
        return telemovel;
    }

    public String getMorada() {
        return morada;
    }

    public String getCc() {
        return cc;
    }

    public String getNif() {
        return nif;
    }
}
