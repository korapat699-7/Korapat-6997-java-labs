package seedamart.korapat.lab6;

/* 
 * Class DungeonsAndDragonsGame:
 * 
 * This class is inherited from CardGame and implements interfaces HasRule, UseBoard, and UseDice.
 * It has 2 constructors:
 *      - DungeonsAndDragonsGame() accepts no argument.
 *      - DungeonsAndDragonsGame(int) accepts one int variable for numOfCardsPerPlayer.
 * 
 * Overrides the abstract method playGame(), and provides a customized toString() method.
 * It also overrides the methods from interfaces: gameRule(), setUpBoard(), and rollDice().
 * 
 * From TestGame3, the output should be:
 *  -->  Dungeons And Dragons Game : { gameName='Dungeons And Dragons Game', numOfPlayers='3'}  
 *       { numOfCardsPerPlayer='0'}
 *  --> Playing Dungeons And Dragons Game
 *  --> Dungeons And Dragons Game Rules : ...
 *  --> Setting up board for Dungeons And Dragons Game
 *  --> Rolling 2 dices for Dungeons And Dragons Game
 *  --> Dungeons And Dragons Game : { gameName='Dungeons And Dragons Game', numOfPlayers='3'}  
 *      { numOfCardsPerPlayer='3'} 
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 26 January 2024
 */
public class DungeonsAndDragonsGame extends CardGame implements HasRule, UseBoard, UseDice {

    // Default constructor setting default values for gameName and numOfPlayers
    DungeonsAndDragonsGame() {
        super();
        gameName = "Dungeons And Dragons Game";
        numOfPlayers = 3;
    }

    // Parameterized constructor calling the super constructor and setting numOfCardsPerPlayer
    DungeonsAndDragonsGame(int numOfCardsPerPlayer) {
        super(numOfCardsPerPlayer);
        gameName = "Dungeons And Dragons Game";
        numOfPlayers = 3;
    }

    // Customized toString() method for displaying the object's information
    @Override
    public String toString() {
        return gameName + " : " + super.toString();
    }

    // Implementation of the playGame() method
    @Override
    public void playGame() {
        System.out.println("Playing " + gameName);
    }

    // Implementation of the gameRule() method from HasRule interface
    @Override
    public void gameRule() {
        System.out.println(gameName + " Rules : ...");
    }

    // Implementation of the setUpBoard() method from UseBoard interface
    @Override
    public void setUpBoard() {
        System.out.println("Setting up board for " + gameName);
    }

    // Implementation of the rollDice() method from UseDice interface
    @Override
    public void rollDice() {
        System.out.println("Rolling 2 dices for " + gameName);
    }
}
