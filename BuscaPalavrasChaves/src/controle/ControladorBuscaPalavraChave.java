package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import visao.PanelBuscaPalavraChave;

public class ControladorBuscaPalavraChave implements ActionListener {

	PanelBuscaPalavraChave panelBPC;
	public DefaultListModel dlm = new DefaultListModel();
	Map<String, Integer> keywordCounts = new HashMap<>();

	public ControladorBuscaPalavraChave(PanelBuscaPalavraChave panelBPC) {
		this.panelBPC = panelBPC;
		addEventos();
	}

	private void addEventos() {
		panelBPC.getListaPalavrasChave().setModel(dlm);
		panelBPC.getButtonAddPalavraChave().addActionListener(this);
		panelBPC.getButtonPesquisar().addActionListener(this);
		panelBPC.getButtonRemover().addActionListener(this);
		panelBPC.getRadioButtonE().addActionListener(this);
		panelBPC.getRadioButtonOu().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == panelBPC.getButtonAddPalavraChave()) {
			addListaPalavra(panelBPC.getTextFieldKey().getText());
		} else if (e.getSource() == panelBPC.getButtonPesquisar()) {
			if (panelBPC.getRadioButtonE().isSelected()) {
				pesquisaArtigosE();
			} else if (panelBPC.getRadioButtonOu().isSelected()) {
				pesquisaArtigosOU();
			}

		} else if (e.getSource() == panelBPC.getButtonRemover()) {
			removeChaveDaLista();
		}

	}

	private void pesquisaArtigosE() { // Selecionou o botão AND (E)

		File caminho = panelBPC.getFileChooser().getSelectedFile();
		String[] palavras = null;
		String[] buscaPalavras = getKeyValues();
		int count = 0;
		boolean encontrada = true;

		for (String keyword : keywordCounts.keySet()) {
			keywordCounts.put(keyword, 0);
		}

		if (caminho.isFile()) {
			try {
				BufferedReader buffRead = new BufferedReader(new FileReader(caminho.getAbsolutePath()));
				String linha = "";

				while ((linha = buffRead.readLine()) != null) {
					palavras = linha.split("\n");
					encontrada = true;

					for (String word : palavras) {
						if (wordHasCurrentKeyWord(buscaPalavras, word) == 0) {
							encontrada = false;
							break;
						}
					}
					if (encontrada) {
						count++;
					}

				}
				buffRead.close();

				// Verificar se alguma palavra-chave não foi encontrada
				boolean algumaPalavraNaoEncontrada = false;
				for (String palavraChave : buscaPalavras) {
					if (palavraNaoEncontrada(palavraChave)) {
						algumaPalavraNaoEncontrada = true;
						break;
					}
				}

				if (algumaPalavraNaoEncontrada) {
					JOptionPane.showMessageDialog(null, "Algumas palavras não foram encontradas!");
				} else {
					/*
					 * Pega o nome do arquivo, as palavras chaves
					 * encontradas e manda essas
					 * informações para panelBPC, para
					 * inserir na tabela
					 */
					String nomeArquivo = caminho.getName();
					String palavrasEncontradas = getKeywordOccurrencesString();
					panelBPC.adicionarInformacoes(nomeArquivo, palavrasEncontradas);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (caminho.isDirectory()) {
			JOptionPane.showMessageDialog(null, "Falha!");
		}

	}

	private boolean palavraNaoEncontrada(String palavraChave) {
		return keywordCounts.containsKey(palavraChave) && keywordCounts.get(palavraChave) == 0;
	}

	private void pesquisaArtigosOU() { // Selecionou o botão OR (OU)

		File caminho = panelBPC.getFileChooser().getSelectedFile();
		String[] palavras = null;
		String[] buscaPalavras = getKeyValues();
		int count = 0;
		boolean palavraOU = false, encontrada = true;

		for (String keyword : keywordCounts.keySet()) {
			keywordCounts.put(keyword, 0);
		}

		if (caminho.isFile()) {
			try {
				BufferedReader buffRead = new BufferedReader(new FileReader(caminho.getAbsolutePath()));
				String linha = "";

				while ((linha = buffRead.readLine()) != null) {
					palavras = linha.split("\n");
					encontrada = true;

					for (String word : palavras) {
						if (wordHasCurrentKeyWord(buscaPalavras, word) == 0) {
							encontrada = false;
							break;
						}
					}

					if (encontrada) {
						count++;
						palavraOU = true;
					}
				}
				buffRead.close();

				/*
				 * Pega o nome do arquivo, as palavras chaves encontradas e manda essas
				 * informações para panelBPC, para
				 * inserir na tabela
				 */
				if (palavraOU) {
					String nomeArquivo = caminho.getName();
					String palavrasEncontradas = getKeywordOccurrencesString();
					panelBPC.adicionarInformacoes(nomeArquivo, palavrasEncontradas);
				} else {
					JOptionPane.showMessageDialog(null, "Não tem OU!");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (caminho.isDirectory()) {
			JOptionPane.showMessageDialog(null, "Falha!");
		}

	}
/* 
	private int wordHasCurrentKeyWord(String[] keys, String current) {
		int count = 0;
		System.out.println(current);// palavra atual
		if (current != null) {
			for (String key : keys) {
				if (key != null && current.equals(key)) {

					if (!keywordCounts.containsKey(key) || keywordCounts.get(key) == 0) {
						count++;
					}
					incrementKeywordCount(key);
				}
			}
		}
		return count;
	}*/

	private int wordHasCurrentKeyWord(String[] keys, String current) {
		int count = 0;
		String[] words = current.split(" "); 
		for (String key : keys) {
			for (String word : words) {
				if (key != null && word.equals(key)) {
					if (!keywordCounts.containsKey(key) || keywordCounts.get(key) == 0) {
						count++;
					}
					incrementKeywordCount(key);
					break; 
				}
			}
		}
	
		return count;
	}
	

	/*
	 * Verifica verifica se a palavra-chave já existe no mapa "keywordCounts". Se
	 * existir, incrementa sua contagem em 1
	 * se não existir, adiciona a palavra-chave ao mapa com uma contagem inicial de
	 * 1.
	 */
	private void incrementKeywordCount(String keyword) {
		int count = keywordCounts.getOrDefault(keyword, 0);
		keywordCounts.put(keyword, count + 1);
	}

	private void removeChaveDaLista() {
		String palavra = (String) panelBPC.getListaPalavrasChave().getSelectedValue();
		dlm.removeElement(palavra);
		keywordCounts.remove(palavra);
	}

	/*
	 * Essa fnção é responsável por cria um array com todas as palavras chaves
	 * passada pelo usuário, o tamanho foi
	 * delimitado a 15, mas o número pode ser alterado a depender da demanda e
	 * necessidade do software.
	 */
	private String[] getKeyValues() {
		String[] keys = new String[15];

		for (int i = 0; i < dlm.size(); i++) {
			keys[i] = dlm.get(i).toString();
		}

		return keys;
	}

	private void addListaPalavra(String chave) {
		if (!dlm.contains(chave)) {
			dlm.addElement(chave);
			keywordCounts.put(chave, 0);
			panelBPC.getTextFieldKey().setText(""); // Limpa o campo de entrada de palavra-chave
		}
	}

	/*
	 * Essa função é responsável por receber as palavras chaves e a quantidades de
	 * vezes que ela foi encontrada, ela liga * a palavra a quantidade de vezes
	 * encontrada!
	 */
	private String getKeywordOccurrencesString() {
		StringBuilder sb = new StringBuilder();

		for (Map.Entry<String, Integer> entry : keywordCounts.entrySet()) {
			String keyword = entry.getKey();
			int count = entry.getValue();
			sb.append(keyword).append("(").append(count).append(") ");
		}

		return sb.toString();
	}

}
