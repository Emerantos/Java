package visao;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelBuscaPalavraChave extends JPanel {
    private JFileChooser fileChooser;
    private JTextField textFieldKey;
    private JButton buttonAddPalavraChave;
    private JList<String> listaPalavrasChave;
    private JButton buttonPesquisar;
    private JPanel panel;
    private JButton buttonRemover;
    private JRadioButton radioButtonE;
    private JRadioButton radioButtonOu;
    private JLabel tituloBusca;
    private JLabel tituloArquivo;
    private JTable tabela;

    public PanelBuscaPalavraChave() {
        super();
        this.setLayout(null);

        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(402, 51, 46, 698);
        add(separator);
        add(getFileChooser());
        add(getTextFieldKey());
        add(getButtonAddPalavraChave());
        add(getListaPalavrasChave());
        add(getButtonPesquisar());
        add(getPanel());
        add(getButtonRemover());
        add(getRadioButtonE());
        add(getRadioButtonOu());
        add(getTituloBusca());
        add(getTituloArquivo());
        add(getTabela());

    }

    public JFileChooser getFileChooser() {
        if (fileChooser == null) {
            fileChooser = new JFileChooser();
            fileChooser.setApproveButtonText("Abrir");
            fileChooser.setBounds(10, 81, 382, 273);
            fileChooser.setFileSelectionMode(2);
            fileChooser.setControlButtonsAreShown(false);
        }
        return fileChooser;
    }

    public JTextField getTextFieldKey() {
        if (textFieldKey == null) {
            textFieldKey = new JTextField();
            textFieldKey.setBorder(
                    new TitledBorder(null, "Palavra chave ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            textFieldKey.setBounds(10, 377, 264, 39);
            textFieldKey.setColumns(10);
        }
        return textFieldKey;
    }

    public JButton getButtonAddPalavraChave() {
        if (buttonAddPalavraChave == null) {
            buttonAddPalavraChave = new JButton("Adicionar ");
            buttonAddPalavraChave.setBounds(284, 377, 108, 39);
        }
        return buttonAddPalavraChave;
    }

    public JList<String> getListaPalavrasChave() {
        if (listaPalavrasChave == null) {
            listaPalavrasChave = new JList<>();
            listaPalavrasChave
                    .setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            listaPalavrasChave.setBounds(10, 427, 382, 119);
            listaPalavrasChave.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
        return listaPalavrasChave;
    }

    public JButton getButtonPesquisar() {
        if (buttonPesquisar == null) {
            buttonPesquisar = new JButton("Pesquisar");
            buttonPesquisar.setBounds(136, 643, 126, 39);
        }
        return buttonPesquisar;
    }

    public JPanel getPanel() {
        if (panel == null) {
            panel = new JPanel();
            panel.setBounds(426, 68, 772, 655);
            GroupLayout gl_panel = new GroupLayout(panel);
            gl_panel.setHorizontalGroup(
                    gl_panel.createParallelGroup(Alignment.LEADING)
                            .addGroup(gl_panel.createSequentialGroup()
                                    .addGap(27)
                                    .addContainerGap(25, Short.MAX_VALUE)));
            gl_panel.setVerticalGroup(
                    gl_panel.createParallelGroup(Alignment.LEADING)
                            .addGroup(gl_panel.createSequentialGroup()
                                    .addGap(59)
                                    .addContainerGap(170, Short.MAX_VALUE)));
            panel.setLayout(gl_panel);
        }
        return panel;
    }

    public JButton getButtonRemover() {
        if (buttonRemover == null) {
            buttonRemover = new JButton("Remover");
            buttonRemover.setBounds(274, 571, 118, 35);
        }
        return buttonRemover;
    }

    public JRadioButton getRadioButtonE() {
        if (radioButtonE == null) {
            radioButtonE = new JRadioButton("Pesquisar E");
            radioButtonE.setBounds(10, 578, 103, 21);
        }
        return radioButtonE;
    }

    public JRadioButton getRadioButtonOu() {
        if (radioButtonOu == null) {
            radioButtonOu = new JRadioButton("Pesquisar Ou");
            radioButtonOu.setBounds(10, 607, 103, 21);
        }
        return radioButtonOu;
    }

    public JLabel getTituloBusca() {
        if (tituloBusca == null) {
            tituloBusca = new JLabel("Buscar Arquivos");
            tituloBusca.setBounds(151, 22, 150, 20);
            tituloBusca.setFont(new Font("Segoe UI", Font.BOLD, 15));
        }
        return tituloBusca;
    }

    public JLabel getTituloArquivo() {
        if (tituloArquivo == null) {
            tituloArquivo = new JLabel("Arquivos Encontrados");
            tituloArquivo.setBounds(785, 22, 200, 20);
            tituloArquivo.setFont(new Font("Segoe UI", Font.BOLD, 15));
        }
        return tituloArquivo;
    }

    /*
     * Função para a crianação de uma tabela com duas colunas para o nome do arquivo
     * e as palavras encontradas.
     */
    public JTable getTabela() {
        if (tabela == null) {
            tabela = new JTable();
            tabela.setBounds(451, 100, 772, 655);
            tabela.setModel(new DefaultTableModel(
                    new Object[][] {},
                    new String[] { "Arquivo", "Palavras Encontradas" }));
            tabela.setFont(new Font("Arial", Font.PLAIN, 16));
        }
        return tabela;
    }

    /*
     * Função responsável por adicionar uma nova linha a tabela, passando o nome do
     * arquivo e as palavras encontradas, com as informações.
     */
    public void adicionarInformacoes(String nomeArquivo, String palavrasEncontradas) {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.addRow(new Object[] { nomeArquivo, palavrasEncontradas });
    }
}
