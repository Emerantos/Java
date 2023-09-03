package visao;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import controle.ControladorBuscaPalavraChave;

public class Frame extends JFrame {

	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	
	public Frame() {
		super("Buscador de Palavras-Chave");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(0,0);
		this.setSize(d.width, d.height-50);
		repaint();
		validate();
	}
}
