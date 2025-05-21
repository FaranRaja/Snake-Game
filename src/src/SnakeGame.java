package src;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SnakeGame {
    public static void main(String[] args) {

        String playerName = JOptionPane.showInputDialog(null,
                "Enter your name:",
                "Snake Game",
                JOptionPane.QUESTION_MESSAGE);


        if (playerName == null || playerName.trim().isEmpty()) {
            playerName = "Anonymous";
        }

        JFrame obj = new JFrame();
        Gameplay gameplay = new Gameplay(playerName);

        obj.setBounds(10, 10, 910, 750);
        obj.setBackground(Color.DARK_GRAY);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);
    }
}