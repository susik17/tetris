package tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TetrisPanel extends JPanel implements ActionListener {
    private final int CELL_SIZE = 25;  // pixels
    private TetrisGame game;
    private Timer timer;

    public TetrisPanel(TetrisGame game) {
        this.game = game;
        setPreferredSize(new Dimension(game.getBoard().getWidth()*CELL_SIZE, game.getBoard().getHeight()*CELL_SIZE));
        setBackground(Color.BLACK);

        timer = new Timer(400, this);
        timer.start();

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(game.isGameOver()) return;

                switch(e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        game.moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        game.moveRight();
                        break;
                    case KeyEvent.VK_DOWN:
                        if(!game.moveDown()) {
                            game.lockAndSpawnNewPiece();
                        }
                        break;
                    case KeyEvent.VK_UP:
                        game.rotatePiece();
                        break;
                    case KeyEvent.VK_SPACE:
                        // Hard drop
                        while(game.moveDown()){}
                        game.lockAndSpawnNewPiece();
                        break;
                }
                repaint();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(game.isGameOver()) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over\nScore: " + game.getScore());
            return;
        }
        if(!game.moveDown()) {
            game.lockAndSpawnNewPiece();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw board blocks
        for(int i=0; i<game.getBoard().getHeight(); i++) {
            for(int j=0; j<game.getBoard().getWidth(); j++) {
                if(game.getBoard().grid[i][j] != 0) {
                    drawBlock(g, j, i, Color.BLUE);
                } else {
                    drawBlock(g, j, i, Color.DARK_GRAY.darker());
                }
            }
        }

        // draw current piece
        int[][] shape = game.getCurrentPiece().getCurrentShape();
        int px = game.getCurrentPiece().x;
        int py = game.getCurrentPiece().y;

        for(int i=0; i<shape.length; i++) {
            for(int j=0; j<shape[0].length; j++) {
                if(shape[i][j] == 1) {
                    drawBlock(g, px + j, py + i, Color.CYAN);
                }
            }
        }

        // Draw score
        g.setColor(Color.WHITE);
        g.drawString("Score: " + game.getScore(), 10, 20);
    }

    private void drawBlock(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x*CELL_SIZE, y*CELL_SIZE, CELL_SIZE, CELL_SIZE);
        g.setColor(Color.BLACK);
        g.drawRect(x*CELL_SIZE, y*CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }
}

