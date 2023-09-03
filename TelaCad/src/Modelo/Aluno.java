package Modelo;

public class Aluno {
    private String nome;
    private String CPF;
    private String matricula;
    private String dataNascimento;


    public Aluno(String nome, String CPF, String matricula, String dataNascimento) {
        this.nome = nome;
        this.CPF = CPF;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;

    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

}
