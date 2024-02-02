package seedamart.korapat.lab7;

/* 
 * Class GuessNumberGameVer4:
 * It is extend from class GuessNumberGameVer3(lab5).
 * It is override method toString() to display the values of the min number to guess, 
 * the max number to guess, and the maximum number of tries.
 * 
 * From TestGuessNumberGameVer4, the output should be:
 * GuessNumberGameVer4 (min:1 ,max:10 ,max tries:3)
 * GuessNumberGameVer4 (min:1 ,max:10 ,max tries:5)
 * GuessNumberGameVer4 (min:1 ,max:5 ,max tries:5)
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 2 February 2024
 */

public class GuessNumberGameVer4 extends seedamart.korapat.lab5.GuessNumberGameVer3 {
    GuessNumberGameVer4(int minNum, int maxNum, int maxTries) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries; 
    }
    @Override
    public String toString() {
        return "GuessNumberGameVer4 (min:" + minNum + " ,max:" + maxNum + " ,max tries:" + maxTries + ")" ;
    }
}