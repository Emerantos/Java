package Controle;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Modelo.Aluno;
import Modelo.Disciplina;
import Modelo.Professor;
import Visao.Frame;

public class PainelControle {

    private Frame frameMenu;

    public void setFrameMenu(Frame frameMenu) {
        this.frameMenu = frameMenu;
    }

    public void showCadAlunoPanel() {
        frameMenu.showCadAlunoPanel();
    }

    public void showCadProfessorPanel() {
        frameMenu.showCadProfessorPanel();
    }

    public void showCadDisciplinaPanel() {
        frameMenu.showCadDisciplinaPanel();
    }

    public void salvarInformacoesAluno(Aluno aluno) {
        String informacoes = "Nome: " + aluno.getNome() + "\n" +
                "CPF: " + aluno.getCPF() + "\n" +
                "Matrícula: " + aluno.getMatricula() + "\n" +
                "Data de Nascimento: " + aluno.getDataNascimento();

        salvarInformacoes(informacoes, "Cad_Aluno.txt");

        frameMenu.showMenuPanel();

    }

    public void salvarInformacoesDisciplina(Disciplina disciplina) {
        String informacoes = "Nome da Materia: " + disciplina.getNome() + "\n" +
                "Numero: " + disciplina.getnumero() + "\n" +
                "Departamento: " + disciplina.getdepartamento();

        salvarInformacoes(informacoes, "Cad_Disciplina.txt");

        frameMenu.showMenuPanel();

    }

    public void salvarInformacoesProfessor(Professor professor) {
        String informacoes = "Nome: " + professor.getNome() + "\n" +
                "Matricula: " + professor.getmatricula() + "\n" +
                "Departamento: " + professor.getDepartamento() + "\n" +
                "Data de Nascimento: " + professor.getDataNascimento();

        salvarInformacoes(informacoes, "Cad_Professor.txt");

        frameMenu.showMenuPanel();

    }

    private void salvarInformacoes(String informacoes, String fileName) {
        String filePath = System.getProperty("user.home") + "/Desktop/" + fileName;
        File file = new File(filePath);

        try {
            FileWriter writer = new FileWriter(file, true);

            if (!file.exists()) {
                file.createNewFile();
            } else {
                writer.write("\n\n");
            }

            writer.write(informacoes);
            writer.close();

            JOptionPane.showMessageDialog(frameMenu, "Informações salvas!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
