package visao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import modelo.BotaoModel;
import controle.BotaoControle;

public class Frame {
    private BotaoModel botaoModel;
    private BotaoControle botaoControle;
    private JFrame frame;
    private JPanel panel;
    private JButton button1;
    private JButton button2;

    public void createAndShowGUI() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 600, 200);

        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        frame.setContentPane(panel);

        button2 = new JButton("");
        button2.setBounds(botaoModel.getX2(), botaoModel.getY2(), 75, 50);
        button2.setBackground(Color.WHITE);
        panel.add(button2);

        button1 = new JButton("");
        button1.setBounds(botaoModel.getX1(), botaoModel.getY1(), 75, 50);
        button1.setBackground(Color.RED);
        panel.add(button1);

        frame.setVisible(true);
    }

    public void updateButtonPositions() {
        button1.setBounds(botaoModel.getX1(), botaoModel.getY1(), 100, 50);
        button2.setBounds(botaoModel.getX2(), botaoModel.getY2(), 100, 50);
        frame.repaint();
    }

    public Frame(BotaoModel botaoModel) {
        this.botaoModel = botaoModel;
    }

    public void setBotaoControle(BotaoControle botaoControle) {
        this.botaoControle = botaoControle;
    }
    
    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public int getWidth() {
        return frame.getWidth();
    }

    public int getHeight() {
        return frame.getHeight();
    }

     public static void main(String[] args) {
        BotaoModel botaoModel = new BotaoModel();
        Frame frame = new Frame(botaoModel);
        BotaoControle botaoControle = new BotaoControle(botaoModel, frame);
        frame.setBotaoControle(botaoControle);

        frame.createAndShowGUI();
        botaoControle.startAnimation();
    }
}
