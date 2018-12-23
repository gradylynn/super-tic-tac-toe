package apps;

import java.util.InputMismatchException;
import java.util.Scanner;

import gameMechanics.BigGame;
import gameMechanics.GameAlreadyFullException;
import gameMechanics.InvalidPositionException;
import gameMechanics.PositionAlreadyTakenException;

public class PvPConsoleApp
{
    private static String player1;
    
    private static String player2;
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to SUPER TIC-TAC-TOE!!!\nEnter Player 1 name (X's):");
        
        player1 = sc.nextLine();
        
        System.out.println("Enter Player 2 name (O's):");
        
        player2 = sc.nextLine();
        
        BigGame game = new BigGame(player1,player2);
        
        System.out.println("Alrighty then. Let's start this game.");
        
        String turn;
        
        while (game.getWinner() == null)
        {
            turn = game.getWhoseTurn();
            
            System.out.println();
            
            System.out.print("It's " + game.getWhoseTurn() + "'s turn.");
            
            if (game.getWhoseTurn().equals(player1))
            {
                System.out.println(" (X's)");
            }
            else
            {
                System.out.println(" (O's)");
            }
            
            System.out.println("Here's the big game:");
            
            System.out.println(game.getBigGame());
            
            if (game.getGameInPlay() == -1)
            {
                System.out.println("You can play anywhere on the board. Select which game you want to play in (0-8):");
                
                System.out.println(game.toString());
                
                while (game.getGameInPlay() == -1)
                {
                    try
                    {
                        game.setGameInPlay(sc.nextInt());
                    }
                    catch (InputMismatchException e)
                    {
                        sc.nextLine();
                        System.out.println("That's an invalid entry. Enter an integer between 0 and 8 to choose what game to play in:");
                    }
                    catch (GameAlreadyFullException e)
                    {
                        sc.nextLine();
                        System.out.println("You cannot play in a game that's already full. Choose another game:");
                    }
                    catch (InvalidPositionException e)
                    {
                        sc.nextLine();
                        System.out.println("That is an invalid entry. Enter an integer between 0 and 8 to choose what game to play in:");
                    }
                }
            }
            else
            {
                System.out.println("Here's what the board looks like:");
                
                System.out.println(game.toString());
            }
            
            System.out.println("You must play in game number " + game.getGameInPlay() + ".");
            
            System.out.println("The valid positions you can play in are: ");
            
            for (int i = 0; i < game.getValidPositions().length; ++i)
            {
                if (i + 1 == game.getValidPositions().length)
                {
                    System.out.println("and " + game.getValidPositions()[i] + ".");
                }
                else
                {
                    System.out.print(game.getValidPositions()[i] + ", ");
                }
            }
            
            System.out.println("Enter your move:");
            
            while (turn == game.getWhoseTurn())
            {
                try
                {
                    game.makeMove(sc.nextInt());
                }
                catch (InputMismatchException e)
                {
                    sc.nextLine();
                    System.out.println("Invalid entry. Enter an integer representing a valid position to play:");
                }
                catch (PositionAlreadyTakenException e)
                {
                    sc.nextLine();
                    System.out.println("Someone has already played there. Enter an integer representing a valid position to play:");
                }
            }
        }
        sc.close();
        
        System.out.println();
        System.out.println("Game over. " + game.getWinner() + " has won the game!!!");
    }
}
