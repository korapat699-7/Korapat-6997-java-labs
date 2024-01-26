package seedamart.korapat.lab6;

/* 
 * Class Game:
 * This abstract class defines a basic structure for a game.
 * It contains getter and setter methods for game name and number of players,
 * overrides the abstract method playGame(), and provides a customized toString() method.
 * 
 * The output in the toString() method should be:
 *  -->  { gameName='<gameName>', numOfPlayers='<numOfPlayers>'}  
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 26 January 2024
 */

abstract class Game {
    // Fields for storing game name and number of players
    String gameName;
    int numOfPlayers;

    // Default constructor initializing fields with default values
    public Game() {
        gameName = "unknown game";
        numOfPlayers = 0;
    }

    // Getter method for retrieving the game name
    public String getName() {
        return gameName;
    }

    // Setter method for setting the game name
    public void setName(String gameName) {
        this.gameName = gameName;
    }

    // Getter method for retrieving the number of players
    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    // Setter method for setting the number of players
    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    // Abstract method representing the gameplay, to be implemented by subclasses
    abstract void playGame();

    // Customized toString() method for displaying the object's information
    @Override
    public String toString() {
        return "{ gameName='" + gameName + "', numOfPlayers='" + numOfPlayers + "'} ";
    }
}
