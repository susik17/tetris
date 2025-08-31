package tetris;

public class GameBoard {
	//1.Setup Project and Board
	//private - Encapsulation final- immutable and constants
	private final int width = 15;
    private final int height = 20;
    final int[][] grid;
    
    public GameBoard() {
    	      grid = new int[height][width];
    }
    /*
    
    //print Empty or current State of Board
    public void printBoard() {
    for(int[] row : grid) {
    	    for(int cell : row) {
    	    	     System.out.print(cell==0 ? "."+" " : "#"+" ");
    	    }
    	    System.out.println();
    }
    System.out.println();
    }*/
    //getters 
    public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	//4.Render Tetromino on Board (Overlay)

	void printWithPiece(Tetrimino piece) {
		 //display matrix - create
		  char[][] display = new char[height][width];
		  for(int i=0;i<height;i++) {
			  for(int j=0;j<width;j++) {
				  display[i]	[j]	= (grid[i][j] == 0)?'.': '#';
			  }
		  }
		  //shape apply 
		  int[][] shape = piece.getCurrentShape();
		  for(int i=0;i<shape.length;i++) {
			  for(int j=0;j<shape[0].length;j++) {
				  if(shape[i][j] == 1) {
					  int xpos = piece.x + j;
					  int ypos = piece.y+i;
					  //within boundry
					  if(xpos>=0 && xpos<width && ypos>=0 && ypos<height) {
						  display[ypos][xpos] ='|';
					  }
				  }
			  }
		  }
		  
		  //print display
		  for(char[] row:display) {
			  for(char c : row) {
				  System.out.print(c+" ");
			  }
			  System.out.println();
		  }
		  System.out.println();
	}
		public boolean isValidPosition(Tetrimino piece,int newX,int newY,int[][] shape) {
			 for(int i=0;i<shape.length;i++) {
				 for(int j=0;j<shape[0].length;j++) {
					 if(shape[i][j] == 1) {
						 int x = newX+j;
						 int y = newY+i;
						 //out of boundry
						 if(x < 0 || x >= width || y < 0 || y >= height) {return false;}
						 //collision - > not overlap on already present cell
						 if(grid[y][x] != 0) { return false;}
					 }
				 }
			 }
			 return true;
	    }
		 
		
		public int clearLines() {
			int LinesCleared = 0;
			for(int i=height-1;i>=0;i--) {
				boolean isFull = true;
				for(int j=0;j<width;j++) {
					if(grid[i][j] == 0) {
						isFull = false;
						break;
					}
				}
				if(isFull) {
					LinesCleared++;
					//shift rows down
					for(int row = i;row > 0;row--) {
						grid[row] = grid[row-1].clone();
					}
					grid[0] = new int[width];
					i++; //recheck the current line
				}
				
			}
			return LinesCleared;
			
		}
		 // Locks (places) the given Tetromino blocks permanently on the board grid
	    public void placeTetromino(Tetrimino piece) {
	        int[][] shape = piece.getCurrentShape();

	        for (int i = 0; i < shape.length; i++) {
	            for (int j = 0; j < shape[i].length; j++) {
	                if (shape[i][j] == 1) {  // block present in shape at this cell
	                    int xPos = piece.x + j;  // calculate absolute x position on board
	                    int yPos = piece.y + i;  // calculate absolute y position on board

	                    if (yPos >= 0 && yPos < height && xPos >= 0 && xPos < width) {
	                        grid[yPos][xPos] = 1; // mark this position as occupied
	                    }
	                }
	            }
	        }
	    }


}
	  
     
      

