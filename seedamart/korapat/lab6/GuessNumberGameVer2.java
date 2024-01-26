package seedamart.korapat.lab6;

/* 
 * Class GuessNumberGameVer2 :
 * This is inherited from GuessNumberGameVer1.
 * gamePieces as list for accept argument
 * and initialized value of variable.
 * Overrides the method playGame(), and provides a customized toString() method.
 * It's implements interface HasRule to call method gameRule().
 * 
 * From TestGame2 The output sholud be :
 * 
 *  --> Guess Number Game Version 2 : { gameName='Guess Number Game', numOfPlayers='1'} 
 *      { minNum= '1', maxNum= '10', correctNum= '10', maxTries= '3'}
 *  --> Guess Number Game Version 2 : { gameName='Guess Number Game', numOfPlayers='1'}  
 *      { minNum= '1', maxNum= '20', correctNum= '3', maxTries= '7'}
 *  --> Playing Guess Number Game Version 2
 *  --> Guess Number Game Rules : ...
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 26 January 2024
 */

public class GuessNumberGameVer2 extends GuessNumberGameVer1 implements HasRule {

    GuessNumberGameVer2() {
        super();
    }

    GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    @Override
    public void playGame() {
        System.out.println("Playing " + gameName + " Version 2");
    }

    @Override
    public String toString() {
        return gameName + " Version 2 : " + super.toString();
    }

    public void gameRule() {
        System.out.println(gameName + " Rules : ...");
    }

}
