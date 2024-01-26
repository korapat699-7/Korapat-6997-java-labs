package seedamart.korapat.lab6;

/* 
 * Class GuessNumberGameVer1:
 * This class is inherited from Game.
 * It has variables minNum, maxNum, correctNum, and maxTries for accepting arguments
 * and initializing the values of variables.
 * It has three constructors:
 *      - GuessNumberGameVer1()
 *      - GuessNumberGameVer1(int, int) 
 *      - GuessNumberGameVer1(int, int, int) 
 * Overrides the method playGame(), and provides a customized toString() method.
 * 
 * From TestGame1, the output should be:
 *  --> Playing Guessing Number Game
 *  --> { gameName='Guess Number Game', numOfPlayers='1'}  
 *      { minNum= '<minNum>', maxNum= '<maxNum>', correctNum= '<correctNum>', maxTries= '<maxTries>'}
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 26 January 2024
 */
public class GuessNumberGameVer1 extends Game {
    protected int minNum;
    protected int maxNum;
    protected int correctNum;
    protected int maxTries;

    GuessNumberGameVer1() {
        super();
        minNum = 1;
        maxNum = 10;
        maxTries = 3;
        numOfPlayers = 1;
        // Generate a random correctNum within the range [minNum, maxNum]
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        gameName = "Guess Number Game";
    }

    GuessNumberGameVer1(int minNum, int maxNum) {
        super();
        this.minNum = minNum;
        this.maxNum = maxNum;
        numOfPlayers = 1;
        // Generate a random correctNum within the range [minNum, maxNum]
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        gameName = "Guess Number Game";
    }

    GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        super();
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries;
        numOfPlayers = 1;
        // Generate a random correctNum within the range [minNum, maxNum]
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        gameName = "Guess Number Game";
    }

    public int getMinNum() {
        return minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getCorrectNum() {
        return correctNum;
    }

    public void setCorrectNum(int correctNum) {
        this.correctNum = correctNum;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    @Override
    public void playGame() {
        System.out.println("Playing Guessing Number Game");
    }

    @Override
    public String toString() {
        return super.toString() + " { minNum= '" + minNum + "', maxNum= '" + maxNum + "', correctNum= '" + correctNum
                + "', maxTries= '" + maxTries + "'}";
    }
}
