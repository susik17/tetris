package tetris;

import java.util.Random;
import java.util.Scanner;




public class TetrisGame {
	//object reference for classes 
	 private GameBoard board;
	 private Tetrimino currentPiece;
	 private Tetrimino nextPiece;
	 private Random random;
	 private boolean gameOver ;
	 private int score;
     
	 
	 
	 public TetrisGame() {
		 setBoard(new GameBoard());
		 random = new Random();
		 setCurrentPiece(generateRandomTetrimino());
		 nextPiece = generateRandomTetrimino();
		 setGameOver(false);
		 setScore(0);
		 
	 }
	 /*
	 public void gameLoop() {
		    Scanner scanner = new Scanner(System.in);
		    while (!gameOver) {
		        board.printWithPiece(currentPiece);
		        System.out.println("Enter move (a=left, d=right, w=rotate, s=down, q=quit):");
		        String input = scanner.nextLine();

		        switch (input) {
		            case "a":
		                moveLeft();
		                break;
		            case "d":
		                moveRight();
		                break;
		            case "w":
		                rotatePiece();
		                break;
		            case "s":
		                if (!moveDown()) {
		                    // Can't move down, lock piece & spawn new
		                    lockAndSpawnNewPiece();
		                }
		                break;
		            case "q":
		                gameOver = true;
		                System.out.println("Quitting game.");
		                break;
		            default:
		                System.out.println("Invalid input.");
		        }
		    }
		    scanner.close();
		    System.out.println("Final score: " + score);
		}
		*/
	 public Tetrimino generateRandomTetrimino() {
		 ShapeType[] types = ShapeType.values();        // All possible shapes (I,O,T,S,Z,J,L)
	     ShapeType randomType = types[random.nextInt(types.length)];
	     Tetrimino newPiece = new Tetrimino(randomType, getBoard().getWidth());
	     return newPiece;
	 }

	public boolean moveLeft() {
		if(getBoard().isValidPosition(getCurrentPiece(), getCurrentPiece().x -1,getCurrentPiece().y ,getCurrentPiece().getCurrentShape())) {
			getCurrentPiece().x--;
			return true;
		}
		return false;
	}
	public boolean moveRight() {
		if(getBoard().isValidPosition(getCurrentPiece(), getCurrentPiece().x + 1,getCurrentPiece().y ,getCurrentPiece().getCurrentShape())) {
			getCurrentPiece().x++;
			return true;
		}
		return false;
	}
	public boolean moveDown() {
		if(getBoard().isValidPosition(getCurrentPiece(), getCurrentPiece().x,getCurrentPiece().y+1 ,getCurrentPiece().getCurrentShape())) {
			getCurrentPiece().y++;
			return true;
		}
		return false;
	}
	public void rotatePiece() {
		
		
		getCurrentPiece().rotate();
		if(!getBoard().isValidPosition(getCurrentPiece(), getCurrentPiece().x,getCurrentPiece().y ,getCurrentPiece().getCurrentShape())) {
			getCurrentPiece().rotateBack();
		}
		 
	}
	
	public void lockAndSpawnNewPiece() {
		getBoard().placeTetromino(getCurrentPiece());
		int clearedLines = getBoard().clearLines() ;
		setScore(getScore() + clearedLines*100);
		//System.out.println("Your Score is:"+score);
		
		setCurrentPiece(nextPiece);
		nextPiece = generateRandomTetrimino();
		//check for valid p
		if(!getBoard().isValidPosition(getCurrentPiece(), getCurrentPiece().x, getCurrentPiece().y, getCurrentPiece().getCurrentShape())) {
			setGameOver(true);
			//System.out.println("------Game Over--------");
		}
		
	}
		
	/*
	//Main function - for console output
	public static void main(String[] args) {
		TetrisGame t = new TetrisGame();
		t.gameLoop();

	}*/
	public boolean isGameOver() {
		return gameOver;
	}
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public GameBoard getBoard() {
		return board;
	}
	public void setBoard(GameBoard board) {
		this.board = board;
	}
	public Tetrimino getCurrentPiece() {
		return currentPiece;
	}
	public void setCurrentPiece(Tetrimino currentPiece) {
		this.currentPiece = currentPiece;
	}
	
}
