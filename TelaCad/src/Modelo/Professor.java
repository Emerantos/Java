package Modelo;

public class Professor {
    private String nome;
    private String Departamento;
    private String matricula;
    private String dataNascimento;

    public Professor(String nome, String Departamento, String matricula, String dataNascimento){
        this.nome = nome;
        this.Departamento = Departamento;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public String getmatricula() {
        return matricula;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }


}
