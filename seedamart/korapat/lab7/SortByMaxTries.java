package seedamart.korapat.lab7;
import java.util.Comparator;
/* 
 * Class SortByMaxTries:
 * SortByMaxTries such that it can sort the objects of  GuessNumberGameVer4 
 * by comparing the values of max tries.  The greater the max tries, the greater the object of GuessNumberGameVer4.
 * 
 * From TestGamesProb1, the output should be:
 * 
 * ===== Unsorted games list: =====
 * GuessNumberGameVer4 (min:1 ,max:10 ,max tries:7)
 * GuessNumberGameVer4 (min:1 ,max:10 ,max tries:5)
 * GuessNumberGameVer4 (min:1 ,max:5 ,max tries:5)
 * ===== Sorted games list: =====
 * GuessNumberGameVer4 (min:1 ,max:10 ,max tries:5
 * GuessNumberGameVer4 (min:1 ,max:5 ,max tries:5)
 * GuessNumberGameVer4 (min:1 ,max:10 ,max tries:7)
 * 
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 2 February 2024
 */

public class SortByMaxTries implements Comparator<GuessNumberGameVer4> {
    @Override
    public int compare(GuessNumberGameVer4 g1, GuessNumberGameVer4 g2) {
        return g1.getMaxTries() - g2.getMaxTries();
    }
}