
package tetris;

import javax.swing.*;

public class TetrisUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TetrisGame game = new TetrisGame();
            JFrame frame = new JFrame("Tetris Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            TetrisPanel panel = new TetrisPanel(game);
            frame.add(panel);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(true); // optional - for fullscreen look

        });
    }
}
