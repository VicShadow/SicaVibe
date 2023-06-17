package sicavibe.response;

import org.orm.PersistentException;
import sicavibe.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class HospedePerfilResponse {
    private int ID;
    private String email;
    private String nome;
    private Date dataNascimento;
    private String nTelemovel;
    private String morada;
    private String cc;
    private String nif;


    public HospedePerfilResponse (Hospede hospede) throws PersistentException, SQLException, IOException {
        this.ID = hospede.getID();
        this.email = hospede.getEmail();
        this.nome = hospede.getNome();
        this.dataNascimento = hospede.getDataNascimento();
        this.nTelemovel = hospede.getnTelemovel();
        this.morada = hospede.getMorada();
        this.cc = hospede.getCc();
        this.nif = hospede.getNif();
    }


    public int getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getnTelemovel() {
        return nTelemovel;
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
