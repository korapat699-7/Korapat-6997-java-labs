package seedamart.korapat.lab6;

/* 
 * Class MonopolyGameVer2:
 * 
 * This class is inherited from MonopolyGame.
 * It overrides the methods toString() and playGame(). 
 * It also implements interfaces:
 *       - HasRule called gameRule() 
 *       - UseBoard called setUpBoard()
 *       - UseDice called rollDice()
 * 
 * From TestGame2, the output should be:
 * 
 *  --> Monopoly Game Version 2 : { gameName='Monopoly Game', numOfPlayers='4'}  
 *      { game pieces='car top hat thimble boot'}
 *  --> Monopoly Game Version 2 : { gameName='Monopoly Game', numOfPlayers='4'}  
 *      { game pieces='Thimble Cat Racecar Boot'}
 *  --> Playing Monopoly Game Version 2
 *  --> Set up monopoly board
 *  --> Monopoly Game Rules : ...
 *  --> Roll 2 dices for monopoly game
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 26 January 2024
 */
public class MonopolyGameVer2 extends MonopolyGame implements HasRule, UseBoard, UseDice {
    // Default constructor calling the superclass constructor
    MonopolyGameVer2() {
        super();
    }

    // Parameterized constructor calling the superclass constructor with provided game pieces
    MonopolyGameVer2(String[] gamePieces) {
        super(gamePieces);
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

    // Implementation of the setUpBoard() method from the UseBoard interface
    public void setUpBoard() {
        System.out.println("Set up monopoly board");
    }

    // Implementation of the gameRule() method from the HasRule interface
    public void gameRule() {
        System.out.println(gameName + " Rules : ...");
    }

    // Implementation of the rollDice() method from the UseDice interface
    public void rollDice() {
        System.out.println("Roll 2 dices for monopoly game");
    }
}
