import java.util.Random;

/*
 * Author: Stephanie Villalobos
 * Course: CSC 311
 * Date: 9/16/19
 * Assignment 1(part2) : Chessboard
 * 
 */
public class ChessboardPart2 
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
		int R = 8;
		int x = 0, y = 0;

		RandomRook(board);
		
        for (x = 0; x < R; x++) 
        {  
            for (y = 0; y < R; y++) 
                System.out.print(" " + board[x][y] + " "); 
            	System.out.println(); 
        } 
    }
	

		//Checking the Rook positions
	    public static boolean RCheck(int c, int r, int board[][])
	    {
	    	int start = board[c][r];
			int x, y;
			int R = 8;
			int N= -1;
			
			if(start == 1)
			{
				return false;
			}
			
			for(x = c + 1; x < R; x++)
			{
				if(board[x][r] == 1)
				{
					return false;
				}
			}
			
			for(x = c - 1; x > N; x--) 
			{
				if(board[x][r]== 1) 
				{
					return false;
				}
			}
			
			for(y = r + 1 ; y < R; y++)
			{
				if(board[c][y] == 1)
				{
					return false;
				}
			}
			
			for(y = r - 1; y > N; y--)
			{
				if(board[c][y] == 1)
				{
					return false;
				}
			}
			
			return true;
	}

	//Randomize the Rooks
	public static void RandomRook(int board [][])
	{
		Random rand = new Random();
		int counter = 0;
		
		while(counter < 8)
		{
				int randomrook_x = rand.nextInt(8);
				int randomrook_y = rand.nextInt(8);
				
				if(RCheck(randomrook_x, randomrook_y, board) == true)
				{
					board[randomrook_x][randomrook_y] = 1;
					
					if(counter == 8)
					{
						break;
					}
					counter++;
				}
		 }	
	}
	
	public static void main(String [] args)
	{
		int board[][] = Board(); 
		Rook(board); 
		
	}
}