package usuario.app.agenda.model;

/**
 * Created by Administrador on 27/06/2016.
 */
public class Contatos {
    private int Id;
    private String Nome;
    private String Fone;
    private String Email;
    private String Observacao;
    public static int idPassado =0;

    public Contatos() {
    }
    public Contatos(String nome, String fone, String email, String observacao) {
        this.Nome = nome;
        this.Fone = fone;
        this.Email = email;
        this.Observacao = observacao;
    }
    public Contatos(String nome, String fone ) {
        this.Nome = nome;
        this.Fone = fone;
    }
    public  Contatos(String nome, String fone, String email) {
        this.Nome = nome;
        this.Fone = fone;
        this.Email = email;
    }


    public static Contatos createContatos() {
        return new Contatos();
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getFone() {
        return Fone;
    }

    public void setFone(String fone) {
        Fone = fone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String observacao) {
        Observacao = observacao;
    }

}
