package seedamart.korapat.lab6;

/* 
 * Class PokerGame:
 * 
 * It is inherited from CardGame.
 * It implements interface HasRule.
 * It has 2 constructors:
 *      - PokerGame() accepts no argument.
 *      - PokerGame(int) accepts one int variable for numOfCardsPerPlayer 
 * 
 * Overrides the abstract method playGame(), and provides a customized toString() method.
 * It overrides the methods from the interface, gameRule().
 * 
 * From TestGame3, the output should be:
 *  --> { gameName='Poker Game', numOfPlayers='4'}  { numOfCardsPerPlayer='5'}
 *  --> Playing Poker Game.
 *  --> Poker Game Rules : ...
 *  --> { gameName='Poker Game', numOfPlayers='4'}  { numOfCardsPerPlayer='10'}
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 26 January 2024
 */
public class PokerGame extends CardGame implements HasRule {

    // Default constructor setting default values for Poker Game
    PokerGame() {
        super();
        numOfCardsPerPlayer = 5;
        gameName = "Poker Game";
        numOfPlayers = 4;
    }   

    // Constructor accepting the number of cards per player as an argument
    PokerGame(int numOfCardsPerPlayer) {
        super();
        this.numOfCardsPerPlayer = numOfCardsPerPlayer;
        gameName = "Poker Game";
        numOfPlayers = 4;
    }

    // Customized toString() method for displaying the object's information
    @Override
    public String toString() {
        return super.toString();
    }

    // Implementation of the playGame() method
    @Override
    public void playGame() {
        System.out.println("Playing " + gameName + ".");
    }
    
    // Implementation of the gameRule() method from the HasRule interface
    @Override
    public void gameRule() {
        System.out.println(gameName + " Rules : ...");
    }
}
