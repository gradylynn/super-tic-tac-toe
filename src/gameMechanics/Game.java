package gameMechanics;

public class Game
{
    final static String X = "X";
    
    final static String O = "O";
    
    private String[] moves = {" "," "," "," "," "," "," "," "," "};
    
    private String winner = null;
    
    
    public Game()
    {
        
    }
    
    
    // returns true if someone won this turn
    public boolean makeMove(String XorO, int position) throws PositionAlreadyTakenException
    {
        if (!moves[position].equals(" "))
        {
            throw new PositionAlreadyTakenException();
        }
        if (XorO.equals(X) || XorO.equals(O))
        {
            moves[position] = XorO;
            return this.updateWinner();
        }
        return false;
    }
    
    public String[] getMoves()
    {
        return this.moves;
    }
    
    public String getWinner()
    {
        return this.winner;
    }
    
    public int[] getAvailablePositions()
    {
        int numAvailable = 0;
        
        for (int i = 0; i < moves.length; ++i)
        {
            if (moves[i].equals(" "))
            {
                ++numAvailable;
            }
        }
        
        int[] out = new int[numAvailable];
        
        for (int i = 0; i < moves.length; ++i)
        {
            if (moves[i].equals(" "))
            {
                out[out.length-numAvailable] = i;
                numAvailable--;
            }
        }
        
        return out;
    }
    
    // returns true if a win happens
    private boolean updateWinner()
    {
        if (winner == null)
        {
            // Top row win
            if (moves[0].equals(X)&&moves[1].equals(X)&&moves[2].equals(X))
            {
                return (winner = X) != null;
            }
            if (moves[0].equals(O)&&moves[1].equals(O)&&moves[2].equals(O))
            {
                return (winner = O) != null;
            }
            // Mid row win
            if (moves[3].equals(X)&&moves[4].equals(X)&&moves[5].equals(X))
            {
                return (winner = X) != null;
            }
            if (moves[3].equals(O)&&moves[4].equals(O)&&moves[5].equals(O))
            {
                return (winner = O) != null;
            }
            // Bottom row win
            if (moves[6].equals(X)&&moves[7].equals(X)&&moves[8].equals(X))
            {
                return (winner = X) != null;
            }
            if (moves[6].equals(O)&&moves[7].equals(O)&&moves[8].equals(O))
            {
                return (winner = O) != null;
            }
            // Left col win
            if (moves[0].equals(X)&&moves[3].equals(X)&&moves[6].equals(X))
            {
                return (winner = X) != null;
            }
            if (moves[0].equals(O)&&moves[3].equals(O)&&moves[6].equals(O))
            {
                return (winner = O) != null;
            }
            // Mid col win
            if (moves[1].equals(X)&&moves[4].equals(X)&&moves[7].equals(X))
            {
                return (winner = X) != null;
            }
            if (moves[1].equals(O)&&moves[4].equals(O)&&moves[7].equals(O))
            {
                return (winner = O) != null;
            }
            // Right col win
            if (moves[2].equals(X)&&moves[5].equals(X)&&moves[8].equals(X))
            {
                return (winner = X) != null;
            }
            if (moves[2].equals(O)&&moves[5].equals(O)&&moves[8].equals(O))
            {
                return (winner = O) != null;
            }
            // \ diag win
            if (moves[0].equals(X)&&moves[4].equals(X)&&moves[8].equals(X))
            {
                return (winner = X) != null;
            }
            if (moves[0].equals(O)&&moves[4].equals(O)&&moves[8].equals(O))
            {
                return (winner = O) != null;
            }
            // / diag win
            if (moves[2].equals(X)&&moves[4].equals(X)&&moves[6].equals(X))
            {
                return (winner = X) != null;
            }
            if (moves[2].equals(O)&&moves[4].equals(O)&&moves[6].equals(O))
            {
                return (winner = O) != null;
            }
        }
        return false;
    }
    
    public boolean isFull()
    {
        for (int i = 0; i < moves.length; ++i)
        {
            if (moves[i].equals(" "))
            {
                return false;
            }
        }
        return true;
    }
    
    public String toString()
    {
        String out = "";
        out += (moves[0] + " | " + moves[1] + " | " + moves[2] + "\n");
        out += ("---------\n");
        out += (moves[3] + " | " + moves[4] + " | " + moves[5] + "\n");
        out += ("---------\n");
        out += (moves[6] + " | " + moves[7] + " | " + moves[8]);
        return out;
    }
}
