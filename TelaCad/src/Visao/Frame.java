package Visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Aluno;
import Modelo.Disciplina;
import Modelo.Professor;
import Controle.PainelControle;

public class Frame extends JFrame {

    private JPanel currentPanel;
    private PainelControle controller;

    public Frame(PainelControle controller) {
        this.controller = controller;
        setTitle("Tela Cadastro");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        showMenuPanel();
    }

    public void showMenuPanel() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setBackground(Color.BLACK);

        JButton btnCadAluno = new JButton("Cadastrar Aluno");
        btnCadAluno.setBounds(0, 0, 250, 50);
        btnCadAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.showCadAlunoPanel();
            }
        });
        menuPanel.add(btnCadAluno);

        JButton btnCadDisciplina = new JButton("Cadastrar Disciplina");
        btnCadDisciplina.setBounds(0, 75, 250, 50);
        btnCadDisciplina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.showCadDisciplinaPanel();
            }
        });
        menuPanel.add(btnCadDisciplina);

        JButton btnCadProfessor = new JButton("Cadastrar Professor");
        btnCadProfessor.setBounds(0, 150, 250, 50);
        btnCadProfessor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.showCadProfessorPanel();
            }
        });
        menuPanel.add(btnCadProfessor);

        menuPanel.setBounds(0, 0, 250, 250);
        setPanel(menuPanel);
    }

    private JButton createBtnVoltar() {
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMenuPanel();
            }
        });
        return btnVoltar;
    }

    private JButton createBtnCadastrar(String buttonText, ActionListener listener) {
        JButton btnCadastrar = new JButton(buttonText);
        btnCadastrar.addActionListener(listener);
        return btnCadastrar;
    }

    public void showCadAlunoPanel() {
        JPanel cadAlunoPanel = new JPanel();
        setTitle("Cadastro Aluno");
        cadAlunoPanel.setLayout(new GridLayout(5, 2));

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblCPF = new JLabel("CPF:");
        JTextField txtCPF = new JTextField();
        JLabel lblMatricula = new JLabel("Matrícula:");
        JTextField txtMatricula = new JTextField();
        JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
        JTextField txtDataNascimento = new JTextField();

        JButton btnCadastrar = createBtnCadastrar("Cadastrar", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String CPF = txtCPF.getText();
                String matricula = txtMatricula.getText();
                String dataNascimento = txtDataNascimento.getText();

                Aluno aluno = new Aluno(nome, CPF, matricula, dataNascimento);
                controller.salvarInformacoesAluno(aluno);
            }
        });

        JButton btnVoltar = createBtnVoltar();

        cadAlunoPanel.add(lblNome);
        cadAlunoPanel.add(txtNome);
        cadAlunoPanel.add(lblCPF);
        cadAlunoPanel.add(txtCPF);
        cadAlunoPanel.add(lblMatricula);
        cadAlunoPanel.add(txtMatricula);
        cadAlunoPanel.add(lblDataNascimento);
        cadAlunoPanel.add(txtDataNascimento);
        cadAlunoPanel.add(btnVoltar);
        cadAlunoPanel.add(btnCadastrar);

        cadAlunoPanel.setBounds(0, 1, 300, 150);
        setPanel(cadAlunoPanel);
    }

    public void showCadDisciplinaPanel() {
        JPanel cadDisciplinaPanel = new JPanel();
        setTitle("Cadastro Disciplina");
        cadDisciplinaPanel.setLayout(new GridLayout(4, 2));

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblnumero = new JLabel("Numero:");
        JTextField txtnumero = new JTextField();
        JLabel lblDepartamento = new JLabel("Departamento:");
        JTextField txtDepartamento = new JTextField();

        JButton btnCadastrar = createBtnCadastrar("Cadastrar", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String numero = txtnumero.getText();
                String Departamento = txtDepartamento.getText();

                Disciplina disciplina = new Disciplina(nome, numero, Departamento);
                controller.salvarInformacoesDisciplina(disciplina);
            }
        });

        JButton btnVoltar = createBtnVoltar();

        cadDisciplinaPanel.add(lblNome);
        cadDisciplinaPanel.add(txtNome);
        cadDisciplinaPanel.add(lblnumero);
        cadDisciplinaPanel.add(txtnumero);
        cadDisciplinaPanel.add(lblDepartamento);
        cadDisciplinaPanel.add(txtDepartamento);
        cadDisciplinaPanel.add(btnVoltar);
        cadDisciplinaPanel.add(btnCadastrar);

        cadDisciplinaPanel.setBounds(0, 1, 300, 150);
        setPanel(cadDisciplinaPanel);
    }

    public void showCadProfessorPanel() {
        JPanel cadProfessorPanel = new JPanel();
        setTitle("Cadadastro Professor");
        cadProfessorPanel.setLayout(new GridLayout(5, 2));

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblDepartamento = new JLabel("Departamento:");
        JTextField txtDepartamento = new JTextField();
        JLabel lblMatricula = new JLabel("Matricula:");
        JTextField txtMatricula = new JTextField();
        JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
        JTextField txtDataNascimento = new JTextField();

        JButton btnCadastrar = createBtnCadastrar("Cadastrar", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String Departamento = txtDepartamento.getText();
                String matricula = txtMatricula.getText();
                String dataNascimento = txtDataNascimento.getText();

                Professor professor = new Professor(nome, Departamento, matricula, dataNascimento);
                controller.salvarInformacoesProfessor(professor);
            }
        });

        JButton btnVoltar = createBtnVoltar();

        cadProfessorPanel.add(lblNome);
        cadProfessorPanel.add(txtNome);
        cadProfessorPanel.add(lblDepartamento);
        cadProfessorPanel.add(txtDepartamento);
        cadProfessorPanel.add(lblMatricula);
        cadProfessorPanel.add(txtMatricula);
        cadProfessorPanel.add(lblDataNascimento);
        cadProfessorPanel.add(txtDataNascimento);
        cadProfessorPanel.add(btnVoltar);
        cadProfessorPanel.add(btnCadastrar);

        cadProfessorPanel.setBounds(0, 1, 300, 150);
        setPanel(cadProfessorPanel);
    }

    private void setPanel(JPanel panel) {
        if (currentPanel != null) {
            remove(currentPanel);
        }

        currentPanel = panel;
        add(currentPanel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        PainelControle controller = new PainelControle();
        Frame frame = new Frame(controller);
        controller.setFrameMenu(frame);
        frame.setVisible(true);
    }
}
