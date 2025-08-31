package tetris;


enum ShapeType {I,O,T,S,Z,J,L}
//2. Define Tetromino Shapes
public class ShapeShapes {
	//define shapes -  roatation states - degrees 0,90,180,270
        public static int[][][] getShapes(ShapeType type){
        	     switch(type) {
        	     case I:
   			  {   return new int[][][] {
   				    {{1,1,1,1}},
   			        {{1},{1},{1},{1}},
   			        {{1,1,1,1}},
   			        {{1},{1},{1},{1}}
   			           };
   				  
   			  }
   			  case O:
   			  {
   				  return new int[][][]{
   					  //return new int[][][]  {{1,1},{1,1}}; -single line also used
   						  {{1,1},{1,1}},
   						  {{1,1},{1,1}},
   						  {{1,1},{1,1}},
   						  {{1,1},{1,1}},
   						  
   				  };
   				  
   				  
   			  }
   			case T:
   			    return new int[][][] {
   			        {   // 0°
   			            {0,1,0},
   			            {1,1,1},
   			            {0,0,0}
   			        },
   			        {   // 90°
   			            {0,1,0},
   			            {0,1,1},
   			            {0,1,0}
   			        },
   			        {   // 180°
   			            {0,0,0},
   			            {1,1,1},
   			            {0,1,0}
   			        },
   			        {   // 270°
   			            {0,1,0},
   			            {1,1,0},
   			            {0,1,0}
   			        }
   			    };

   			  case S:
   			  {
   				  return new int[][][]{
   						  {{0,1,1},{1,1,0}},
   						  {{1,0},
   						   {1,1},
   						   {0,1}},
   						  {{1,1,0},
   						   {0,1,1}},
   						  {{1,0},
   						   {1,1},
   						   {0,1}}
   				  };  
   			  }
   			case L:
   			    return new int[][][]{
   			        {   // 0°
   			            {1,0,0},
   			            {1,1,1},
   			            {0,0,0}
   			        },
   			        {   // 90°
   			            {0,1,1},
   			            {0,1,0},
   			            {0,1,0}
   			        },
   			        {   // 180°
   			            {0,0,0},
   			            {1,1,1},
   			            {0,0,1}
   			        },
   			        {   // 270°
   			            {0,1,0},
   			            {0,1,0},
   			            {1,1,0}
   			        }
   			    };

   			  case J:
   			  {
   				  return new int[][][] {
   						  {{1,1,1},{0,0,1}},
   						  {{0,1},{0,1},{1,1}},
   						  {{1,0,0},{1,1,1}},
   						  {{1,1},{1,0},{1,0}}
   				  };
   				  
   				 
   				  
   			  }
   			  case Z:
   			  {
   				  return new int[][][]{
   						  {{1,1,0},{0,1,1}},
   						  {{1,0},
   						   {1,1},
   						   {0,1}},
   						  {{0,1,1},
   						   {1,1,0}},
   						  {{1,0},
   						   {1,1},
   						   {0,1}}
   				  };
   				  
   				  
   			  }
   			  
   			  default:
   				 return new int[][][] {{{0}}};
   		  }
        	     
        	
        }
	
	
}
