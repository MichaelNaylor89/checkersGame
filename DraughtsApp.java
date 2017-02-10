import java.util.*;

public class DraughtsApp
{

	public static void main (String [] args)
	{
		DraughtsBoard GameBoard = new DraughtsBoard();
		Scanner in = new Scanner(System.in);
		
		final int BLANK = 0;
    	final int BLACK = 1;
    	final int WHITE = 2;

        int selectedPiece = 0;
        int jumpedPiece = 0;
    	
		int X, Y;
		int Piece;
		X=0;
		Y=0;
		int newX;
		int newY;
        int jpX;
        int jpY;
		int newSpace;
		int turn = 1;
        int whitePiecesRemaining = 12;
        int blackPiecesRemaining = 12;

        boolean moved = false;

        if (blackPiecesRemaining > 0 && whitePiecesRemaining > 0) {
            if (blackPiecesRemaining <= 0)
            {
                System.out.println ("White Wins");
            }
            else if (whitePiecesRemaining <= 0)
            {
                System.out.println("Black Wins");
            }
            else {

                while (X != -1) {
                    System.out.println();
                    GameBoard.draw();
                    if (turn % 2 == 1)
                    {
                        System.out.println("Whites Move");
                    }
                    else
                    {
                        System.out.println("Blacks Move");
                    }
                    System.out.println("\nEnter -1 to quit");
                    System.out.print("Enter X coordinate: ");
                    X = in.nextInt();
                    if (X != -1) {
                        System.out.print("Enter Y coordinate: ");
                        Y = in.nextInt();

                        Piece = GameBoard.get_square(X - 1, Y - 1);
                        System.out.print("\nSquare at " + X + "," + Y + " is ");
                        switch (Piece) {
                            case BLANK:
                                System.out.println("blank");
                                selectedPiece = 0;
                                break;

                            case BLACK:
                                System.out.println("a black piece");
                                selectedPiece = 1;
                                break;

                            case WHITE:
                                System.out.println("a white piece");
                                selectedPiece = 2;
                                break;
                        }
                    }

                    if (turn % 2 == 1 && selectedPiece == 2) {
                        newX = 0;
                        newY = 0;
                        jpX = 0;
                        jpY = 0;
                        System.out.println("Enter a new X coordinate: ");
                        while (!(newX > 0 && newX < 9)) {
                            newX = in.nextInt();
                        }

                        System.out.println("Enter a new Y coordinate: ");

                        while (!(newY > 0 && newY < 9)) {
                            newY = in.nextInt();
                        }

                        newSpace = GameBoard.get_square(newX - 1, newY - 1);

                        if (newSpace == WHITE)
                        {
                            System.out.println("This space is already occupied by a white piece");
                        }
                        else if (newSpace == BLACK)
                        {
                            System.out.println("This space is already occupied by a black piece");
                        }
                        else if (newSpace == BLANK)
                        {
                            if (newY - Y == 1 && newX - X == 1)
                            {
                                GameBoard.set_square(newX - 1, newY - 1, GameBoard.get_square(X - 1, Y - 1));
                                GameBoard.set_square(X - 1, Y - 1, BLANK);
                                moved = true;
                            }
                            else if (newY - Y == 1 && newX - X == -1)
                            {
                                GameBoard.set_square(newX - 1, newY - 1, GameBoard.get_square(X - 1, Y - 1));
                                GameBoard.set_square(X - 1, Y - 1, BLANK);
                                moved = true;
                            }
                            else if (newY - Y == 2 && newX - X == 2)
                            {
                                jpX = ((X - newX) / 2) + newX;
                                jpY = ((Y - newY) / 2) + newY;
                                jumpedPiece = GameBoard.get_square(jpX - 1, jpY - 1);

                                if (jumpedPiece == BLACK) {
                                    GameBoard.set_square(newX - 1, newY - 1, GameBoard.get_square(X - 1, Y - 1));
                                    GameBoard.set_square(X - 1, Y - 1, BLANK);
                                    GameBoard.set_square(jpX - 1, jpY - 1, BLANK);
                                    blackPiecesRemaining -= 1;
                                    System.out.println("black piece taken " + blackPiecesRemaining + " black pieces remaining");
                                    moved = true;
                                }
                                else
                                {
                                    System.out.println("this is not a valid move");
                                }
                            }
                            else if (newY - Y == 2 && newX - X == -2)
                            {
                                jpX = ((X - newX) / 2) + newX;
                                jpY = ((Y - newY) / 2) + newY;
                                jumpedPiece = GameBoard.get_square(jpX - 1, jpY - 1);
                                if (jumpedPiece == BLACK) {
                                    GameBoard.set_square(newX - 1, newY - 1, GameBoard.get_square(X - 1, Y - 1));
                                    GameBoard.set_square(X - 1, Y - 1, BLANK);
                                    GameBoard.set_square(jpX - 1, jpY - 1, BLANK);
                                    blackPiecesRemaining -= 1;
                                    System.out.println("Black piece taken " + blackPiecesRemaining + " black pieces remaining");
                                    moved = true;
                                }
                                else
                                {
                                    System.out.println("this is not a valid move");
                                }
                            }

                            else
                            {
                                System.out.println("that move is not valid");
                            }
                        }
                        if (moved == true) {
                            turn++;
                            System.out.println("turn: " + turn);
                            moved = false;
                        }
                    }
                    else if (turn % 2 == 0 && selectedPiece == 1)
                    {
                        newX = 0;
                        newY = 0;
                        jpX = 0;
                        jpY = 0;
                        System.out.println("Enter a new X coordinate: ");
                        while (!(newX > 0 && newX < 9)) {
                            newX = in.nextInt();
                        }
                        System.out.println("Enter a new Y coordinate: ");

                        while (!(newY > 0 && newY < 9)) {
                            newY = in.nextInt();
                        }
                        newSpace = GameBoard.get_square(newX - 1, newY - 1);

                        if (newSpace == WHITE)
                        {
                            System.out.println("This space is already occupied by a white piece");
                        }
                        else if (newSpace == BLACK)
                        {
                            System.out.println("This space is already occupied by a black piece");
                        }
                        else if (newSpace == BLANK)
                        {
                            if (newY - Y == -1 && newX - X == 1) {
                                GameBoard.set_square(newX - 1, newY - 1, GameBoard.get_square(X - 1, Y - 1));
                                GameBoard.set_square(X - 1, Y - 1, BLANK);
                                moved = true;
                            }
                            else if (newY - Y == -1 && newX - X == -1)
                            {
                                GameBoard.set_square(newX - 1, newY - 1, GameBoard.get_square(X - 1, Y - 1));
                                GameBoard.set_square(X - 1, Y - 1, BLANK);
                                moved = true;
                            }
                            else if (newY - Y == -2 && newX - X == 2)
                            {
                                jpX = ((X - newX) / 2) + newX;
                                jpY = ((Y - newY) / 2) + newY;
                                jumpedPiece = GameBoard.get_square(jpX - 1, jpY - 1);
                                if (jumpedPiece == WHITE)
                                {
                                    GameBoard.set_square(newX - 1, newY - 1, GameBoard.get_square(X - 1, Y - 1));
                                    GameBoard.set_square(X - 1, Y - 1, BLANK);
                                    GameBoard.set_square(jpX - 1, jpY - 1, BLANK);
                                    whitePiecesRemaining -= 1;
                                    System.out.println("White piece taken " + whitePiecesRemaining + " white pieces remaining");
                                    moved = true;
                                }
                                else
                                {
                                    System.out.println("this is not a valid move");
                                }
                            }
                            else if (newY - Y == -2 && newX - X == -2)
                            {
                                jpX = ((X - newX) / 2) + newX;
                                jpY = ((Y - newY) / 2) + newY;
                                jumpedPiece = GameBoard.get_square(jpX - 1, jpY - 1);
                                if (jumpedPiece == WHITE)
                                {
                                    GameBoard.set_square(newX - 1, newY - 1, GameBoard.get_square(X - 1, Y - 1));
                                    GameBoard.set_square(X - 1, Y - 1, BLANK);
                                    GameBoard.set_square(jpX - 1, jpY - 1, BLANK);
                                    whitePiecesRemaining -= 1;
                                    System.out.println("white piece taken " + whitePiecesRemaining + " white pieces remaining");
                                    moved = true;
                                }
                                else
                                {
                                    System.out.println("this is not a valid move");
                                }
                            }
                            else
                            {
                                System.out.println("that move is not valid");
                            }
                        }
                        if (moved == true) {
                            turn++;
                            System.out.println("turn: " + turn);
                            moved = false;
                        }
                    }
                    else
                    {
                        System.out.println("Please select one of your pieces");
                    }
                }
            }
        }
	}
}
