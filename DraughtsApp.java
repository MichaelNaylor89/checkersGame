import java.util.Scanner;

public class DraughtsApp
{
	@SuppressWarnings("resource")
	public static void main (String [] args)
	{
		DraughtsBoard GameBoard = new DraughtsBoard();
		Scanner in = new Scanner(System.in);
		
		final int BLANK = 0;
    	final int BLACK = 1;
    	final int WHITE = 2; 
    	
		int X, Y;
		int Piece = 0;
		X=0;
		Y=0;
		int newX = 0;
		int newY = 0;
		int newSpace = 0;
		int turn = 1;
		
			while (X != -1)
			{		
				System.out.println();
				GameBoard.draw();
				System.out.println("\nEnter -1 to quit");
				System.out.print("Enter X coordinate: ");
				X = in.nextInt();
				if (X != -1)
				{
					System.out.print("Enter Y coordinate: ");
					Y = in.nextInt();
					
					Piece = GameBoard.get_square(X-1, Y-1);
					System.out.print("\nSquare at "+X+","+Y+" is ");
					switch (Piece)
					{
						case BLANK:
							System.out.println("blank");
							break;
						
						case BLACK:
							System.out.println("a black piece");
							break;
						
						case WHITE:
							System.out.println("a white piece");
							break;
					}
				}
			
				newX = 0;
				newY = 0;
				System.out.println("Enter a new X coordinate: ");
				while(!(newX > 0 && newX < 9))
				{
					newX = in.nextInt();
				}
				
				System.out.println("Enter a new Y coordinate: ");
				
				while(!(newY > 0 && newY < 9))
				{
					newY = in.nextInt();
				}
				
				newSpace = GameBoard.get_square(newX-1, newY-1);
				
				if(newSpace == WHITE)
				{
					System.out.println("This space is already occupied by a white piece");
				}
				else if(newSpace == BLACK)
				{
					System.out.println("This space is already occupied by a black piece");
				}
				else if(newSpace == BLANK)
				{
					if(newY - Y == 1 && newX - X == 1)
					{
						GameBoard.set_square(newX-1, newY-1, GameBoard.get_square(X-1, Y-1));
						GameBoard.set_square(X-1, Y-1, BLANK);
					}
					else if(newY - Y == 1 && newX - X == -1)
					{
						GameBoard.set_square(newX-1, newY-1, GameBoard.get_square(X-1, Y-1));
						GameBoard.set_square(X-1, Y-1, BLANK);
						
					}
					else
					{
						System.out.println("that move is not valid");
					}
					
				}
				
				turn++;
				System.out.println("turn: " + turn);
	
			}
	}
}
