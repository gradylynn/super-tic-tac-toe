package gameMechanics;

public class BigGame
{   
    private String xName;
    
    private String oName;
    
    private Game[] games = new Game[9];
    
    private Game bigGame;
    
    private String winner = null;
    
    private String whoseTurn;
    
    private int gameInPlay = -1;
    
    // CONSTRUCTORS
    public BigGame(String xName, String oName)
    {
        this.xName = xName;
        this.oName = oName;
        whoseTurn = xName;
        
        bigGame = new Game();
        
        for(int i = 0; i < games.length; ++i)
        {
            games[i] = new Game();
        }
    }
    
    // GETTERS
    public String getWinner()
    {
        return this.winner;
    }
    
    public Game getGame(int game)
    {
        return games[game];
    }
    
    public Game getBigGame()
    {
        return this.bigGame;
    }
    
    public String getWhoseTurn()
    {
        return whoseTurn;
    }
    
    public int getGameInPlay()
    {
        return this.gameInPlay;
    }
    
    public int[] getValidPositions()
    {
        return this.games[gameInPlay].getAvailablePositions();
    }
    
    // METHODS
    // returns null if there is no winner yet
    public void makeMove(int position) throws PositionAlreadyTakenException
    {
        if (whoseTurn.equals(xName))
        {
            if (games[gameInPlay].makeMove(Game.X, position))
            {
                bigGame.makeMove(Game.X, gameInPlay);
            }
        }
        else if (whoseTurn.equals(oName))
        {
            if (games[gameInPlay].makeMove(Game.O, position))
            {
                bigGame.makeMove(Game.O, gameInPlay);
            }
        }
        
        if (!games[position].isFull())
        {
            gameInPlay = position;
        }
        else
        {
            gameInPlay = -1;
        }
        
        this.updateWinner();
        this.toggleTurn();
    }
    
    public boolean setGameInPlay(int gameOfPlay) throws GameAlreadyFullException, InvalidPositionException
    {
        if (gameInPlay == -1)
        {
            if (gameOfPlay <= 8 && gameOfPlay >= 0)
            {
                if (games[gameOfPlay].isFull())
                {
                    throw new GameAlreadyFullException();

                }
                else
                {
                    gameInPlay = gameOfPlay;
                    return true;
                }
            }
            else 
            {
                throw new InvalidPositionException();
            }
        }
        return false;
    }
    
    private String toggleTurn()
    {
        if (whoseTurn.equals(xName))
        {
            whoseTurn = oName;
            return oName;
        }
        if (whoseTurn.equals(oName))
        {
            whoseTurn = xName;
            return xName;
        }
        return null;
    }

    private void updateWinner()
    {
        if (winner == null)
        {
            winner = bigGame.getWinner();
        }
    }
    
    public String toString()
    {
        String out = "";
        
        out += ("game 0     |game 1       |game 2     " + "\n");
        out += (games[0].getMoves()[0] + " | " + games[0].getMoves()[1] + " | " + games[0].getMoves()[2]  + "  |  ");
        out += (games[1].getMoves()[0] + " | " + games[1].getMoves()[1] + " | " + games[1].getMoves()[2]  + "  |  ");
        out += (games[2].getMoves()[0] + " | " + games[2].getMoves()[1] + " | " + games[2].getMoves()[2]  + "\n");
        out += ("---------" + "  |  " + "---------" + "  |  " + "---------" + "\n");
        
        out += (games[0].getMoves()[3] + " | " + games[0].getMoves()[4] + " | " + games[0].getMoves()[5]  + "  |  ");
        out += (games[1].getMoves()[3] + " | " + games[1].getMoves()[4] + " | " + games[1].getMoves()[5]  + "  |  ");
        out += (games[2].getMoves()[3] + " | " + games[2].getMoves()[4] + " | " + games[2].getMoves()[5]  + "\n");
        out += ("---------" + "  |  " + "---------" + "  |  " + "---------" + "\n");
        
        out += (games[0].getMoves()[6] + " | " + games[0].getMoves()[7] + " | " + games[0].getMoves()[8]  + "  |  ");
        out += (games[1].getMoves()[6] + " | " + games[1].getMoves()[7] + " | " + games[1].getMoves()[8]  + "  |  ");
        out += (games[2].getMoves()[6] + " | " + games[2].getMoves()[7] + " | " + games[2].getMoves()[8]  + "\n");
        out += ("           |             |           " + "\n");
        
        out += ("-------------------------------------" + "\n");
        
        out += ("game 3     |game 4       |game 5     " + "\n");
        out += (games[3].getMoves()[0] + " | " + games[3].getMoves()[1] + " | " + games[3].getMoves()[2]  + "  |  ");
        out += (games[4].getMoves()[0] + " | " + games[4].getMoves()[1] + " | " + games[4].getMoves()[2]  + "  |  ");
        out += (games[5].getMoves()[0] + " | " + games[5].getMoves()[1] + " | " + games[5].getMoves()[2]  + "\n");
        out += ("---------" + "  |  " + "---------" + "  |  " + "---------" + "\n");
        
        out += (games[3].getMoves()[3] + " | " + games[3].getMoves()[4] + " | " + games[3].getMoves()[5]  + "  |  ");
        out += (games[4].getMoves()[3] + " | " + games[4].getMoves()[4] + " | " + games[4].getMoves()[5]  + "  |  ");
        out += (games[5].getMoves()[3] + " | " + games[5].getMoves()[4] + " | " + games[5].getMoves()[5]  + "\n");
        out += ("---------" + "  |  " + "---------" + "  |  " + "---------" + "\n");
        
        out += (games[3].getMoves()[6] + " | " + games[3].getMoves()[7] + " | " + games[3].getMoves()[8]  + "  |  ");
        out += (games[4].getMoves()[6] + " | " + games[4].getMoves()[7] + " | " + games[4].getMoves()[8]  + "  |  ");
        out += (games[5].getMoves()[6] + " | " + games[5].getMoves()[7] + " | " + games[5].getMoves()[8]  + "\n");
        out += ("           |             |           " + "\n");
        
        out += ("-------------------------------------" + "\n");
        
        out += ("game 6     |game 7       |game 8     " + "\n");
        out += (games[6].getMoves()[0] + " | " + games[6].getMoves()[1] + " | " + games[6].getMoves()[2]  + "  |  ");
        out += (games[7].getMoves()[0] + " | " + games[7].getMoves()[1] + " | " + games[7].getMoves()[2]  + "  |  ");
        out += (games[8].getMoves()[0] + " | " + games[8].getMoves()[1] + " | " + games[8].getMoves()[2]  + "\n");
        out += ("---------" + "  |  " + "---------" + "  |  " + "---------" + "\n");
        
        out += (games[6].getMoves()[3] + " | " + games[6].getMoves()[4] + " | " + games[6].getMoves()[5]  + "  |  ");
        out += (games[7].getMoves()[3] + " | " + games[7].getMoves()[4] + " | " + games[7].getMoves()[5]  + "  |  ");
        out += (games[8].getMoves()[3] + " | " + games[8].getMoves()[4] + " | " + games[8].getMoves()[5]  + "\n");
        out += ("---------" + "  |  " + "---------" + "  |  " + "---------" + "\n");
        
        out += (games[6].getMoves()[6] + " | " + games[6].getMoves()[7] + " | " + games[6].getMoves()[8]  + "  |  ");
        out += (games[7].getMoves()[6] + " | " + games[7].getMoves()[7] + " | " + games[7].getMoves()[8]  + "  |  ");
        out += (games[8].getMoves()[6] + " | " + games[8].getMoves()[7] + " | " + games[8].getMoves()[8]  + "\n");
        out += ("           |             |           ");
        
        return out;
    }
}
