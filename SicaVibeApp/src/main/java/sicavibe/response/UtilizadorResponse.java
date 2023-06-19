package sicavibe.response;

import javassist.NotFoundException;
import org.orm.PersistentException;
import org.springframework.web.server.ResponseStatusException;
import sicavibe.*;

import java.sql.SQLException;
import java.util.Date;

public class UtilizadorResponse {

    private final int ID;
    private final String email;
    private final String nome;
    private final String numTelemovel;
    private final String morada;
    private final String cc;
    private final String nif;
    private final Date dataNascimento;
    private String hotelName = null;



    public UtilizadorResponse (Utilizador utilizador) throws PersistentException, NotFoundException {
        this.ID = utilizador.getID();
        this.email = utilizador.getEmail();
        this.nome = utilizador.getNome();
        this.numTelemovel = utilizador.getNumTelemovel();
        this.morada = utilizador.getMorada();
        this.cc = utilizador.getCc();
        this.nif = utilizador.getNif();
        this.dataNascimento = utilizador.getDataNascimento();

        if (utilizador instanceof Funcionario) {
            Funcionario func = (Funcionario) utilizador;
            this.hotelName = func.getMyWorkHotel().getNome();
        }
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


    public String getMorada() {
        return morada;
    }

    public String getCc() {
        return cc;
    }

    public String getNif() {
        return nif;
    }

    public String getNumTelemovel() {
        return numTelemovel;
    }

    public String getHotelName() {
        return hotelName;
    }
}
