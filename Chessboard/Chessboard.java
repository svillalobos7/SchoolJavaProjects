import java.util.Random;

/*
 * Author: Stephanie Villalobos
 * Course: CSC 311
 * Date: 9/11/19
 * Assignment 1: Chessboard
 * 
 */
public class Chessboard 
{
	//Creating Chessboard
	public static int[][] Board()
	{
		int board[][] = { 
				
					 { 0, 0, 0, 0, 0, 0, 0, 0 }, 
				      	 { 0, 0, 0, 0, 0, 0, 0, 0 }, 
				         { 0, 0, 0, 0, 0, 0, 0, 0 },
				      	 { 0, 0, 0, 0, 0, 0, 0, 0 }, 
				      	 { 0, 0, 0, 0, 0, 0, 0, 0 }, 
				         { 0, 0, 0, 0, 0, 0, 0, 0 }, 
				         { 0, 0, 0, 0, 0, 0, 0, 0 }, 
				         { 0, 0, 0, 0, 0, 0, 0, 0 }
				      		  
				}; 
		
			return board;
		
	}
	

	//Placing and creating Rook pattern
	public static void Rook(int[][] board)
    	{    
       	 	board[0][1] = 1;
        	board[1][3] = 1;
        	board[2][5] = 1;
        	board[3][7] = 1;
        	board[4][6] = 1;
        	board[5][4] = 1;
        	board[6][2] = 1;
        	board[7][0] = 1;

        	int R = 8;
		int x, y;
		
        	for (x = 0; x < R; x++) 
        	{ 
 
            		for (y = 0; y < R; y++) 
            	
                		System.out.print(" " + board[x][y] + " "); 
            			System.out.println(); 
        	} 
    	}
	

	//Checking the Rook positions(not completed)-due Monday
	public static boolean RCheck(int column, int row, int board[][])
	{
		int x, y;
		int R = 8;
		
		//Check row
		for(x = 0; x< row;x++)
			if(board[column][x] == 1)
				return false;
		
		//Check upper diagonal
		for(x = column, y = row; x >= 0 && y >= 0; x--,y--)
			if(board[x][y] == 1)
				return false;
		
		//Check lower diagonal
		for(x = column, y = row; y >= 0 && x < R; x++,y--)
			if(board[x][y] == 1)
				return false;

		return true;
		
	}


	//Randomize the Rooks(not completed)- due Monday
	public static void RandomRook()
	{
		Random rand = new Random();

		 for(int i = 0; i< 8; i++)
		 {
			 int randomrook = rand.nextInt(8)+1;
			 System.out.println(randomrook);
		 }
	
		
	}
	

	public static void main(String [] args)
	{
		int board[][] = Board(); 
		Rook(board); 
	
	}
}