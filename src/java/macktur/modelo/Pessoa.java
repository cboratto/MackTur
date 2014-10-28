package macktur.modelo;

public class Pessoa {

    int id;
    String nome;
    String cpf;
    String dataNascimento;

    public Pessoa(String nome, int id, String cpf) {
        this.nome = nome;
        this.id = id;
        this.cpf = cpf;
    }

    public Pessoa() {

    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
