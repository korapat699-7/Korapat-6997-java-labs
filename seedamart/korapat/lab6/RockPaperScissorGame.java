package seedamart.korapat.lab6;

/* 
 * Class RockPaperScissorGame:
 * 
 * This class is inherited from Game.
 * It has variables player1Choice and player2Choice for accepting arguments.
 * It has two constructors: RockPaperScissorGame() and RockPaperScissorGame(String, String),
 * and initializes the values of the variables.
 * It overrides the method playGame(), and provides a customized toString() method.
 * 
 * From TestGame1, the output should be:
 *  --> Playing RockPaperScissor Game
 *  --> { gameName='Rock Paper Scissor Game', numOfPlayers='2'}  { player1Choice= 'rock', player2Choice= 'rock' }
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 26 January 2024
 */
public class RockPaperScissorGame extends Game {
    // Fields for storing player choices
    protected String player1Choice, player2Choice;

    // Default constructor initializing fields with default values
    RockPaperScissorGame() {
        super();
        gameName = "Rock Paper Scissor Game";
        numOfPlayers = 2;
        this.player1Choice = "rock";
        this.player2Choice = "rock";
    }

    // Parameterized constructor setting player choices based on provided arguments
    RockPaperScissorGame(String player1Choice, String player2Choice) {
        super();
        this.player1Choice = player1Choice;
        this.player2Choice = player2Choice;
        gameName = "Rock Paper Scissor Game";
        numOfPlayers = 2;
    }

    // Getter method for retrieving player1's choice
    public String getPlayer1Choice() {
        return player1Choice;
    }

    // Setter method for setting player1's choice
    public void setPlayer1Choice(String player1Choice) {
        this.player1Choice = player1Choice;
    }

    // Getter method for retrieving player2's choice
    public String getPlayer2Choice() {
        return player2Choice;
    }

    // Setter method for setting player2's choice
    public void setPlayer2Choice(String player2Choice) {
        this.player2Choice = player2Choice;
    }

    // Implementation of the playGame() method
    @Override
    public void playGame() {
        System.out.println("Playing RockPaperScissor Game");
    }

    // Customized toString() method for displaying the object's information
    @Override
    public String toString() {
        return super.toString() + " { player1Choice= '" + player1Choice + "', player2Choice= '" + player2Choice + "' }" ;
    }
}
