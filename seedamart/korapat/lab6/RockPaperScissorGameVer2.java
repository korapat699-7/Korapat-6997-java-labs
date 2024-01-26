package seedamart.korapat.lab6;

/* 
 * Class RockPaperScissorGameVer2:
 * 
 * This class is inherited from RockPaperScissorGame.
 * It has gamePieces as a list for accepting arguments and initialized values of variables.
 * It overrides the method playGame(), and provides a customized toString() method.
 * It implements the interface HasRule to call the method gameRule().
 * 
 * From TestGame2, the output should be:
 * 
 *  --> Rock Paper Scissor Game Version 2 : { gameName='Rock Paper Scissor Game', numOfPlayers='2'}  
 *      { player1Choice= 'rock', player2Choice= 'rock' }
 *  --> Playing Rock Paper Scissor Game Version 2
 *  --> Rock Paper Scissor Game Rules : ...
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 26 January 2024
 */
public class RockPaperScissorGameVer2 extends RockPaperScissorGame implements HasRule {
    // Default constructor calling the superclass constructor
    RockPaperScissorGameVer2() {
        super();
    }

    // Parameterized constructor calling the superclass constructor with provided choices
    RockPaperScissorGameVer2(String player1Choice, String player2Choice) {
        super(player1Choice, player2Choice);
    }
    
    // Implementation of the playGame() method
    @Override
    public void playGame() {
        System.out.println("Playing " + gameName + " Version 2");
    }

    // Customized toString() method for displaying the object's information
    @Override
    public String toString() {
        return gameName + " Version 2 : " + super.toString();
    }

    // Implementation of the gameRule() method from the HasRule interface
    @Override
    public void gameRule() {
        System.out.println(gameName + " Rules : ...");
    }
}
