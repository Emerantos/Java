package Modelo;

public class Disciplina {
    private String nome;
    private String numero;
    private String departamento;
    
    public Disciplina(String nome, String numero, String departamento) {
        this.nome = nome;
        this.numero = numero;
        this.departamento = departamento;        
    }

    public String getNome() {
        return nome;
    }

    public String getnumero() {
        return numero;
    }

    public String getdepartamento() {
        return departamento;
    }    
}
