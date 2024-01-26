package seedamart.korapat.lab6;

/* 
 * Class MonopolyGame:
 * 
 * This class is inherited from Game and represents a Monopoly game.
 * It has gamePieces as a list for accepting arguments and initialized values of variables.
 * It overrides the method playGame(), and provides a customized toString() method.
 * It has two constructors:
 *      - MonopolyGame()
 *      - MonopolyGame(String[])
 *
 * From TestGame1, the output should be:
 *  --> Monopoly Game
 *  --> { gameName='Monopoly Game', numOfPlayers='4'}  { game pieces='car top hat thimble boot'}
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 26 January 2024
 */
class MonopolyGame extends Game {
    // Field for storing game pieces
    protected String[] gamePieces;    

    // Default constructor initializing fields with default values
    MonopolyGame() {
        super();
        gameName = "Monopoly Game";
        numOfPlayers = 4;
        this.gamePieces = new String[] {"car", "top", "hat", "thimble", "boot"};
    } 

    // Parameterized constructor setting game pieces based on the provided array
    MonopolyGame(String[] gamePieces) {
        super();
        gameName = "Monopoly Game";
        numOfPlayers = 4;
        this.gamePieces = gamePieces;
    }

    // Getter method for retrieving game pieces
    public String[] getGamePieces() {
        return gamePieces;
    }

    // Setter method for setting game pieces
    public void setGamePieces(String[] gamePieces) {
        this.gamePieces = gamePieces;
    } 

    // Implementation of the playGame() method
    @Override
    public void playGame() {
        System.out.println("Playing Monopoly Game");
    }

    // Customized method for converting game pieces to a formatted string
    public String gamePiecesToString() {
        return String.join(" ", gamePieces);
    }

    // Customized toString() method for displaying the object's information
    @Override
    public String toString() {
        return super.toString() + " { game pieces='" + gamePiecesToString() + "'}" ;
    }
}
