package seedamart.korapat.lab6;

/* 
 * Class CardGame:
 * 
 * This abstract class is inherited from Game and represents a card game.
 * It contains getter and setter methods for numOfCardsPerPlayer,
 * overrides the abstract method playGame(), and provides a customized toString() method.
 * 
 * The output in the toString() method should be:
 *  -->  { gameName='<gameName>', numOfPlayers='<numOfPlayers>'}  { numOfCardsPerPlayer='<numOfCardsPerPlayer>'} 
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 26 January 2024
 */
abstract class CardGame extends Game {
    // Field for storing the number of cards per player
    protected int numOfCardsPerPlayer;

    // Default constructor initializing numOfCardsPerPlayer with default value
    CardGame() {
        numOfCardsPerPlayer = 0;
    }

    // Parameterized constructor calling the super constructor and setting numOfCardsPerPlayer
    CardGame(int numOfCardPerPlayer) {
        super();
        this.numOfCardsPerPlayer = numOfCardPerPlayer;
    }

    // Getter method for retrieving the number of cards per player
    public int getNumOfCardPerPlayer() {
        return numOfCardsPerPlayer;
    }

    // Setter method for setting the number of cards per player
    public void setNumOfCardPerPlayer(int numOfCardPerPlayer) {
        this.numOfCardsPerPlayer = numOfCardPerPlayer;
    }

    // Abstract method representing the gameplay, to be implemented by subclasses
    abstract void playGame();

    // Customized toString() method for displaying the object's information, including numOfCardsPerPlayer
    @Override
    public String toString() {
        return super.toString() + " { numOfCardsPerPlayer='" + numOfCardsPerPlayer + "'}";
    }
}
